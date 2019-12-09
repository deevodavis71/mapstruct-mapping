package com.sjd.mapstructmapping.entity;

import java.util.Date;

import lombok.Data;

@Data
public class UnlockRecordEntity
{

    private String uuidUser;

    private String unlockedSlotUuid;

    private Date createdAt;

}
