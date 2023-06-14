package com.java.docker.test.myip.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class ActivityDto {
    private String activity;
    private String type;
    private int participants;
    private double price;
    private String key;
    private double accessibility;

}
