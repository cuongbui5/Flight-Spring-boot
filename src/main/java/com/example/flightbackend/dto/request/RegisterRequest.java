package com.example.flightbackend.dto.request;

import com.example.flightbackend.validator.PasswordMatches;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@PasswordMatches
public class RegisterRequest {
    @Size(min = 4, message = "Tài khoản phải có ít nhất 4 kí tự")
    private String username;
    @Size(min = 6, message = "Mật khẩu phải có ít nhất 6 kí tự")
    private String password;
    private String passwordConfirm;
}
