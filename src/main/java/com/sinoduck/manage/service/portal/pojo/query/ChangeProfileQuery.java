package com.sinoduck.manage.service.portal.pojo.query;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author where.liu
 */
@Data
public class ChangeProfileQuery {
    @Length(min = 3, max = 16, message = "昵称长度在 3 ~ 16 位之间")
    private String nickname;
}
