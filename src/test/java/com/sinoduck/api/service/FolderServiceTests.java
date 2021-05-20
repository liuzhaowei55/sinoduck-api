package com.sinoduck.api.service;

import com.sinoduck.api.exception.ErrorResponseException;
import com.sinoduck.api.dao.domain.FolderDo;
import com.sinoduck.api.dao.domain.UserDo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class FolderServiceTests {
    @Resource
    private FolderService folderService;

    @Test
    public void testCreateFolder() throws ErrorResponseException {
        long userId = 1L;
        String title = "cc";
        UserDo userDO = new UserDo();
        userDO.setId(userId);
        FolderDo folderDO = folderService.createFolder(userDO, title);
        log.debug("folder {}", folderDO);
        Assert.isTrue(folderDO.getId() > 0L, "文件夹添加失败");
    }
}
