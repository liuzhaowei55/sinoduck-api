package com.sinoduck.api.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author where.liu
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "data_dictionary")
@EntityListeners(AuditingEntityListener.class)
public class DataDictionary {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String key;
    private String value;
    /**
     * @see TypeEnum
     */
    private String type;
    private String memo;

    @Version
    private Integer version;

    @JsonIgnore
    private LocalDateTime deletedAt;

    @JsonIgnore
    @LastModifiedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime updatedAt;

    @JsonIgnore
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

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

        TypeEnum(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return this.code;
        }
    }
}
