package com.news.collection.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class keywordDto {
    private Integer um_idx;
    private Boolean use_yn =true;
    @NotBlank(message = "키워드가 비어있습니다.")
    private String keyword;
    @NotBlank(message = "도메인 타입이 비어있습니다.")
    private String domain_type;
    private LocalDate reg_dt;
    private String reg_ip;

}
