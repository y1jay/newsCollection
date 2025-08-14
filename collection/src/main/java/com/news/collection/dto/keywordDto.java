package com.news.collection.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class keywordDto {
    @NotBlank(message = "회원번호가 비어있습니다.")
    private Long um_idx;
    private Boolean use_yn;
    @NotBlank(message = "키워드가 비어있습니다.")
    private String keyword;
    private LocalDate reg_dt;
    private String reg_ip;

}
