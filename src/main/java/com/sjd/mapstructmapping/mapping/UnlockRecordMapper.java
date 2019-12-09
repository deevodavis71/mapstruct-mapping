package com.sjd.mapstructmapping.mapping;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import com.sjd.mapstructmapping.dto.UnlockRecord;
import com.sjd.mapstructmapping.entity.UnlockRecordEntity;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UnlockRecordMapper
{
    @Mapping(target = "unlockedSlotUuid", ignore = true)
    UnlockRecord toDto(UnlockRecordEntity entity);

    @Mapping(target = "unlockedSlotUuid", ignore = true)
    UnlockRecordEntity fromDto(UnlockRecord entity);

    List<UnlockRecord> toDtoList(List<UnlockRecordEntity> list);

    List<UnlockRecordEntity> fromDtoList(List<UnlockRecord> list);

    default UUID map(String value)
    {
        return !isNullOrEmpty(value) ? UUID.fromString(value) : null;
    }

    default String map(UUID uuid)
    {
        return uuid != null ? uuid.toString() : null;
    }

    // ====================================================================================

    @AfterMapping
    default void after(UnlockRecordEntity unlockRecordEntity, @MappingTarget UnlockRecord domain)
    {
        if (unlockRecordEntity != null && domain != null)
            domain.setUnlockedSlotUuid(Arrays.asList(unlockRecordEntity.getUnlockedSlotUuid().split(",")));
    }

    @AfterMapping
    default void after(UnlockRecord unlockRecord, @MappingTarget UnlockRecordEntity entity)
    {
        if (unlockRecord != null && entity != null)
            entity.setUnlockedSlotUuid(String.join(",", unlockRecord.getUnlockedSlotUuid()));
    }

}
