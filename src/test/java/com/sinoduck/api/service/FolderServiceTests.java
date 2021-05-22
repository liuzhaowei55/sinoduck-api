package com.sinoduck.api.service;

import com.sinoduck.api.exception.ErrorResponseException;
import com.sinoduck.api.model.entity.Folder;
import com.sinoduck.api.model.entity.User;
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
        User user = new User();
        user.setId(userId);
        Folder folder = folderService.createFolder(user, title);
        log.debug("folder {}", folder);
        Assert.isTrue(folder.getId() > 0L, "文件夹添加失败");
    }
}
