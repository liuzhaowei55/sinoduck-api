package com.sinoduck.api.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

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
    @Enumerated(EnumType.STRING)
    private TypeEnum type;
    private String memo;

    public enum TypeEnum {
        /**
         * 值类型：字符串
         */
        STRING("STRING"),
        /**
         * 值类型：数字
         */
        NUMERIC("NUMERIC"),
        /**
         * 值类型：JSON 字符串
         */
        JSON("JSON");

        @Getter
        private final String code;

        private TypeEnum(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return this.code;
        }
    }
}
