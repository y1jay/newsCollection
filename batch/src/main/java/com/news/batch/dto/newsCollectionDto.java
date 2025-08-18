package com.news.batch.dto;


import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class newsCollectionDto {
    private String title;
    private String link;
    private String subject;
    private LocalDate reg_dt;
    private String pub_dt;
    private Integer um_idx;
    private String domain_type;
    private Integer uk_idx;
}
