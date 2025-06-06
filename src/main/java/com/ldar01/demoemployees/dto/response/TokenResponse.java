package com.ldar01.demoemployees.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenResponse {
    private String accessToken;
    @Builder.Default
    private String type = "Bearer";
}
