package com.sinoduck.api.service;

import com.sinoduck.api.pojo.domain.FolderDO;
import com.sinoduck.api.pojo.domain.UserDO;
import com.sinoduck.api.repository.FolderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * @author where.liu
 */
@Service
public class FolderService {
    @Resource
    private FolderRepository folderRepository;

    public FolderDO createFolder(@NotNull UserDO userDO, @NotEmpty String title) {
        FolderDO folderDO = new FolderDO();
        folderDO.setUserId(userDO.getId());
        folderDO.setTitle(title);
        return this.folderRepository.save(folderDO);
    }

    public List<FolderDO> listFolderRows(@NotNull UserDO userDO) {
        return folderRepository.findAllByUserId(userDO.getId());
    }

    public void update(@NotNull FolderDO folderDO) {
        this.folderRepository.save(folderDO);
       // this.folderRepository.updateTitleById(folderDO.getId(), folderDO.getTitle());
    }

    public Optional<FolderDO> find(@NotNull Long id) {
        return this.folderRepository.findById(id);
    }
}
