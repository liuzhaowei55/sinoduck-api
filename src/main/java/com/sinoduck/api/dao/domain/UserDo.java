package com.sinoduck.api.dao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author where.liu
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "user")
public class UserDo extends BaseDomain {

}
