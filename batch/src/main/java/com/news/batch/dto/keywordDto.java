package com.news.batch.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class keywordDto {
    private Integer uk_idx;
    private Integer um_idx;
    private Boolean use_yn;
    private String keyword;
    private String domain_type;
}