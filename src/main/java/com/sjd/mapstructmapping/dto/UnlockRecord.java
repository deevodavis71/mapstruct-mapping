package com.sjd.mapstructmapping.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class UnlockRecord
{
    private UUID uuidUser;

    private List<String> unlockedSlotUuid;

    private Date createdAt;
}
