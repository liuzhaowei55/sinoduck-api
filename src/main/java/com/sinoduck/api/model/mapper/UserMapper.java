package com.sinoduck.api.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinoduck.api.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author where.liu
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
