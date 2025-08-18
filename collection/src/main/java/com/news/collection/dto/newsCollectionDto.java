package com.news.collection.dto;


import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class newsCollectionDto {
     String title;
     String link;
     String subject;
     LocalDate reg_dt;
     String pub_dt;
     Integer um_idx;
     String domain_type;
     Integer uk_idx;
     Integer page = 1;
     Integer size = 10;
}
