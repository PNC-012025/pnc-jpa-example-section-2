package com.ldar01.demoemployees.security;

import com.ldar01.demoemployees.entities.Employee;
import com.ldar01.demoemployees.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private EmployeeRepository employeeRepository; // Repository to access employee data

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        // Fetches an employee by username or email, throws an exception if not found
        Employee employee = employeeRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException(usernameOrEmail));

        // Maps the employee's roles to granted authorities
        Set<GrantedAuthority> grantedAuthorities = employee.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())) // Converts each role to a granted authority
                .collect(Collectors.toSet());

        // Returns a Spring Security User object with the employee's username, password, and authorities
        return new User(employee.getUsername(), employee.getPassword(), grantedAuthorities);
    }
}
