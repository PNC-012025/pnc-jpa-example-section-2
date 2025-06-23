INSERT INTO public.roles(name) VALUES ('ROLE_ADMIN');
INSERT INTO public.roles(name) VALUES ('ROLE_USER');

INSERT INTO public.departments(department_name) VALUES ('IT');
INSERT INTO public.departments(department_name) VALUES ('HR');

INSERT INTO employees(name, last_name, email, username, password, department_id) VALUES ('John', 'Doe', 'john@doe.com', 'johndoe', '$2a$10$ULkGlX7Fngg3EyrQgkGKYer82kijXaD0fUzN6wB1lC7rENit7CTOS', 1);
INSERT INTO employees(name, last_name, email, username, password, department_id) VALUES ('Jane', 'Smith', 'jane@smith.com', 'janesmith', '$2a$10$uucg/9uwwabhOMRCyMnHZextDtEUXzgcHyOJ7LElv5BFxQ8eMFdMa', 2);

INSERT INTO public.employee_roles(employee_id, role_id) VALUES (1, 1);
INSERT INTO public.employee_roles(employee_id, role_id) VALUES (2, 2);