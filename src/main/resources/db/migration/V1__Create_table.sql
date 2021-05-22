CREATE TABLE `user`
(
    `id`         BIGINT UNSIGNED AUTO_INCREMENT         NOT NULL COMMENT '主键',
    `username`   VARCHAR(255) DEFAULT ''                NOT NULL COMMENT '用户名',
    `password`   VARCHAR(255) DEFAULT ''                NOT NULL COMMENT '密码',
    `nickname`   VARCHAR(255) DEFAULT ''                NOT NULL COMMENT '昵称',
    `avatar`     VARCHAR(255) DEFAULT ''                NOT NULL COMMENT '头像',
    `version`    INT UNSIGNED DEFAULT 0                 NOT NULL COMMENT '乐观锁',
    `deleted_at` TIMESTAMP    DEFAULT NULL              NULL COMMENT '删除时间',
    `updated_at` TIMESTAMP    DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `created_at` TIMESTAMP    DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    INDEX `idx_username` (`username`),
    INDEX `idx_deleted_at` (`deleted_at`),
    INDEX `idx_created_at` (`created_at`),
    INDEX `idx_updated_at` (`updated_at`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4`
  COLLATE = `utf8mb4_unicode_ci` COMMENT ='用户表';
CREATE TABLE `token`
(
    `id`           BIGINT UNSIGNED AUTO_INCREMENT            NOT NULL COMMENT '主键',
    `user_id`      BIGINT UNSIGNED DEFAULT 0                 NOT NULL COMMENT '用户 ID',
    `access_token` VARCHAR(255)    DEFAULT ''                NOT NULL COMMENT 'access_token',
    `user_agent`   varchar(255)    DEFAULT ''                NOT NULL COMMENT 'ua',
    `ip`           varchar(255)    DEFAULT ''                NOT NULL COMMENT 'ip',
    `version`      INT UNSIGNED    DEFAULT 0                 NOT NULL COMMENT '乐观锁',
    `deleted_at`   TIMESTAMP       DEFAULT NULL              NULL COMMENT '删除时间',
    `updated_at`   TIMESTAMP       DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `created_at`   TIMESTAMP       DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    INDEX `idx_user_id` (`user_id`),
    INDEX `idx_access_token` (`access_token`),
    INDEX `idx_deleted_at` (`deleted_at`),
    INDEX `idx_created_at` (`created_at`),
    INDEX `idx_updated_at` (`updated_at`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4`
  COLLATE = `utf8mb4_unicode_ci` COMMENT ='token 表';

CREATE TABLE `folder`
(
    `id`         BIGINT UNSIGNED AUTO_INCREMENT            NOT NULL COMMENT '主键',
    `user_id`    BIGINT UNSIGNED DEFAULT 0                 NOT NULL COMMENT '用户 ID',
    `title`      VARCHAR(255)    DEFAULT ''                NOT NULL COMMENT '名称',
    `version`    INT UNSIGNED    DEFAULT 0                 NOT NULL COMMENT '乐观锁',
    `deleted_at` TIMESTAMP       DEFAULT NULL              NULL COMMENT '删除时间',
    `updated_at` TIMESTAMP       DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `created_at` TIMESTAMP       DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    INDEX `idx_user_id_title` (`user_id`, `title`),
    INDEX `idx_deleted_at` (`deleted_at`),
    INDEX `idx_created_at` (`created_at`),
    INDEX `idx_updated_at` (`updated_at`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4`
  COLLATE = `utf8mb4_unicode_ci` COMMENT ='文件夹表';