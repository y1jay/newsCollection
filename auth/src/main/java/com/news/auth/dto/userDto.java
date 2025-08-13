package com.news.auth.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class userDto {
    private String name;
    private String email;
    private String uuid;
    private String join_type;
    private Date join_dt;
    private String join_ip;
}
