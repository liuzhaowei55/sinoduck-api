package com.sinoduck.api.db.entity;

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
@Table(name = "place")
@EntityListeners(AuditingEntityListener.class)
public class Place extends AbstractEntity {
    private String districtCode;
    private String name;
    private Double longitude;
    private Double latitude;
    private String address;
    private String memo;
    private String extra;
}
