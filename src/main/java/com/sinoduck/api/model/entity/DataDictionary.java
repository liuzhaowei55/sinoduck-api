package com.sinoduck.api.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * @author where.liu
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "data_dictionary")
@EntityListeners(AuditingEntityListener.class)
public class DataDictionary extends AbstractEntity {
    private String name;
    private String key;
    private String value;
    @Builder.Default
    private TypeEnum type = TypeEnum.STRING;
    private String memo;

    enum TypeEnum {
        /**
         * 值类型：字符串
         */
        STRING,
        /**
         * 值类型：数字
         */
        NUMERIC,
        /**
         * 值类型：JSON 字符串
         */
        JSON
    }
}
