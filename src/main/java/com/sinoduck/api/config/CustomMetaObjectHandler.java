package com.sinoduck.api.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * @author where.liu
 */
@Slf4j
@Component
public class CustomMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Date now = Calendar.getInstance().getTime();
        this.strictInsertFill(metaObject, "createdAt", Date.class, now);
        this.strictInsertFill(metaObject, "updatedAt", Date.class, now);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date now = Calendar.getInstance().getTime();
        this.strictInsertFill(metaObject, "createdAt", Date.class, now);
        this.strictInsertFill(metaObject, "updatedAt", Date.class, now);
    }
}
