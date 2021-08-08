package com.dizhongdi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dizhongdi.pojo.User;
import org.springframework.stereotype.Component;

/**
 * ClassName:UserMapper
 * Package:com.dizhongdi.mapper
 * Description:
 *
 * @Date: 2021/8/7 18:42
 * @Author:dizhongdi
 */
@Component
public interface UserMapper extends BaseMapper<User> {
    void updateById(long l);
}
