package com.sinoduck.api.portal.pojo.converter;

import com.sinoduck.api.pojo.domain.FolderDO;
import com.sinoduck.api.portal.pojo.dto.FolderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author where.liu
 */
@Mapper
public interface FolderDtoConverter {
    FolderDtoConverter INSTANCE = Mappers.getMapper(FolderDtoConverter.class);

    /**
     * do 转 dto
     *
     * @param folderDO 实体模型
     * @return dto
     */
    FolderDTO fromFolderDO(FolderDO folderDO);
}
