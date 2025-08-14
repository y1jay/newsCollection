package com.news.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class userDto {
    @NotBlank(message = "이름 값이 비어있습니다.")
    private String name;
    @NotBlank(message = "이메일이 비어있습니다.")
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;
    @NotBlank
    private String uuid;
    private String join_type;
    private LocalDate join_dt;
    private String join_ip;

}
