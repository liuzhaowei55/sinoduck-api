package com.sinoduck.manage.service.portal.pojo.converter;

import com.sinoduck.db.entity.User;
import com.sinoduck.manage.service.portal.pojo.dto.UserProfileDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


/**
 * @author where.liu
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    /**
     * @param user user 实体
     * @return 前端展示的用户信息
     */
    UserProfileDTO toUserProfileDTO(User user);
}
