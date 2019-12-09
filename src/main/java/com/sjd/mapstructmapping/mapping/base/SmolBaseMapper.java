package com.sjd.mapstructmapping.mapping.base;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.util.UUID;

public interface SmolBaseMapper<D, E> extends BaseMapper<D, E>
{
    default UUID map(String value)
    {
        return !isNullOrEmpty(value) ? UUID.fromString(value) : null;
    }

    default String map(UUID uuid)
    {
        return uuid != null ? uuid.toString() : null;
    }
}
