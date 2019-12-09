package com.sjd.mapstructmapping.dto;

import com.sjd.mapstructmapping.enums.DayOfWeek;

import lombok.Data;

@Data
public class EnumDto
{
    private int id;

    private DayOfWeek day;
}
