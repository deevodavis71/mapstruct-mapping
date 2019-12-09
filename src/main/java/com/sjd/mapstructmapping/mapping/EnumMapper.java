package com.sjd.mapstructmapping.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.sjd.mapstructmapping.dto.EnumDto;
import com.sjd.mapstructmapping.entity.EnumEntity;
import com.sjd.mapstructmapping.enums.DayOfWeek;
import com.sjd.mapstructmapping.mapping.base.SmolBaseMapper;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EnumMapper extends SmolBaseMapper<EnumDto, EnumEntity>
{
    default DayOfWeek toDayOfWeek(Integer day)
    {
        return DayOfWeek.values()[day];
    }

    default Integer fromDayOfWeek(DayOfWeek day)
    {
        return day.ordinal();
    }

}
