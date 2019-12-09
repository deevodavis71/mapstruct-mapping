package com.sjd.mapstructmapping;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.sjd.mapstructmapping.dto.UnlockRecord;
import com.sjd.mapstructmapping.entity.UnlockRecordEntity;
import com.sjd.mapstructmapping.mapping.UnlockRecordMapper;
import com.sjd.mapstructmapping.mapping.UnlockRecordMapperImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
public class EntityMappingTest
{
    private UnlockRecordMapper mapper = new UnlockRecordMapperImpl();

    private Date now = new Date();

    private UUID uuidUser = UUID.randomUUID();

    private UUID uuid1 = UUID.randomUUID();
    private UUID uuid2 = UUID.randomUUID();

    @Test
    public void testFromEntityToRecordSingle()
    {

        UnlockRecordEntity entity = new UnlockRecordEntity();
        entity.setCreatedAt(now);
        entity.setUuidUser(uuidUser.toString());
        entity.setUnlockedSlotUuid(uuid1.toString());

        UnlockRecord record = mapper.toDto(entity);

        Assert.assertEquals(now, record.getCreatedAt());
        Assert.assertEquals(uuidUser, record.getUuidUser());

        Assert.assertEquals(1, record.getUnlockedSlotUuid().size());
        Assert.assertEquals(uuid1.toString(), record.getUnlockedSlotUuid().get(0));

    }

    @Test
    public void testFromEntityToRecordDouble()
    {

        UnlockRecordEntity entity = new UnlockRecordEntity();
        entity.setCreatedAt(now);
        entity.setUuidUser(uuidUser.toString());
        entity.setUnlockedSlotUuid(uuid1.toString() + "," + uuid2.toString());

        UnlockRecord record = mapper.toDto(entity);

        Assert.assertEquals(now, record.getCreatedAt());
        Assert.assertEquals(uuidUser, record.getUuidUser());

        Assert.assertEquals(2, record.getUnlockedSlotUuid().size());
        Assert.assertEquals(uuid1.toString(), record.getUnlockedSlotUuid().get(0));
        Assert.assertEquals(uuid2.toString(), record.getUnlockedSlotUuid().get(1));

    }

    @Test
    public void testFromRecordToEntitySingle()
    {

        UnlockRecord record = new UnlockRecord();
        record.setCreatedAt(now);
        record.setUuidUser(uuidUser);
        record.setUnlockedSlotUuid(Arrays.asList(uuid1.toString()));

        UnlockRecordEntity entity = mapper.fromDto(record);

        Assert.assertEquals(now, entity.getCreatedAt());
        Assert.assertEquals(uuidUser.toString(), entity.getUuidUser());
        Assert.assertEquals(uuid1.toString(), entity.getUnlockedSlotUuid());

    }

    @Test
    public void testFromRecordToEntityDouble()
    {

        UnlockRecord record = new UnlockRecord();
        record.setCreatedAt(now);
        record.setUuidUser(uuidUser);
        record.setUnlockedSlotUuid(Arrays.asList(uuid1.toString(), uuid2.toString()));

        UnlockRecordEntity entity = mapper.fromDto(record);

        Assert.assertEquals(now, entity.getCreatedAt());
        Assert.assertEquals(uuidUser.toString(), entity.getUuidUser());
        Assert.assertEquals(uuid1.toString() + "," + uuid2.toString(), entity.getUnlockedSlotUuid());

    }

}
