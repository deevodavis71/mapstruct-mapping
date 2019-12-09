package com.sjd.mapstructmapping;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.sjd.mapstructmapping.dto.EnumDto;
import com.sjd.mapstructmapping.entity.EnumEntity;
import com.sjd.mapstructmapping.enums.DayOfWeek;
import com.sjd.mapstructmapping.mapping.EnumMapper;
import com.sjd.mapstructmapping.mapping.EnumMapperImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
public class EnumMappingTest
{
    private EnumMapper enumMapper = new EnumMapperImpl();

    @Test
    public void testFromEntity()
    {
        EnumEntity entity = new EnumEntity();
        entity.setId(123);
        entity.setDay(5);

        EnumDto dto = enumMapper.toDto(entity);

        Assert.assertEquals(123, dto.getId());
        Assert.assertEquals(DayOfWeek.SATURDAY, dto.getDay());
    }

    @Test
    public void testToEntity()
    {
        EnumDto dto = new EnumDto();
        dto.setId(456);
        dto.setDay(DayOfWeek.FRIDAY);

        EnumEntity entity = enumMapper.fromDto(dto);

        Assert.assertEquals(456, entity.getId());
        Assert.assertEquals(4, entity.getDay().intValue());
    }

}
