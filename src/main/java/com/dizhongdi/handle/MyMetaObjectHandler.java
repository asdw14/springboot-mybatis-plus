package com.dizhongdi.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ClassName:MyMetaObjectHandler
 * Package:com.dizhongdi.handle
 * Description:
 *
 * @Date: 2021/8/7 22:47
 * @Author:dizhongdi
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insert .....date");
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("update .....date");
        this.setFieldValByName("updateTime",new Date(),metaObject);

    }
}
