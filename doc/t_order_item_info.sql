CREATE TABLE `t_order_item_info` (
                                     `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
                                     `order_id` BIGINT(20) NOT NULL COMMENT '订单id',
                                     `pro_id` BIGINT(20) NOT NULL COMMENT '商品id',
                                     `pro_name` VARCHAR(255) NOT NULL COMMENT '商品名称',
                                     `pro_price` DECIMAL(10, 2) NOT NULL COMMENT '商品价格（单价）',
                                     `number` INT(11) NOT NULL COMMENT '购买数量',
                                     `is_deleted` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '删除标志位。0：未删除；1：已删除',
                                     `gmt_create` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `gmt_updated` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                     PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单项表';