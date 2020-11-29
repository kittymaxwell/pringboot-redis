package com.rambo.plugin.module.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * <p>
 *   处理新增和更新的基础数据填充，配合BaseEntity和MyBatisPlusConfig使用
 * </p>
 *
 * @author Rambo
 * @since 2020-11-28
 */
@Component
public class MetaHandler implements MetaObjectHandler {

    private static final Logger logger = LoggerFactory.getLogger(MetaHandler.class);

    /**
     * 新增数据执行
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", LocalDateTime.now(ZoneId.of("Asia/Shanghai")), metaObject);
        //this.setFieldValByName("createBy", userEntity.getLoginName(), metaObject);
        //this.setFieldValByName("updateBy", userEntity.getLoginName(), metaObject);
    }

    /**
     * 更新数据执行
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", LocalDateTime.now(ZoneId.of("Asia/Shanghai")), metaObject);
        //this.setFieldValByName("updateBy", userEntity.getLoginName(), metaObject);
    }

}