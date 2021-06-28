package com.sinoduck.api.web.portal.pojo.converter;

import com.sinoduck.api.db.entity.Folder;
import com.sinoduck.api.web.portal.pojo.dto.FolderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author where.liu
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface FolderDtoConverter {
    FolderDtoConverter INSTANCE = Mappers.getMapper(FolderDtoConverter.class);

    /**
     * do 转 dto
     *
     * @param folder 实体模型
     * @return dto
     */
    FolderDTO fromFolderDO(Folder folder);
}
