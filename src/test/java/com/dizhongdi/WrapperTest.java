package com.dizhongdi;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.dizhongdi.mapper.UserMapper;
import com.dizhongdi.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ClassName:WrapperTest
 * Package:com.dizhongdi
 * Description:
 *
 * @Date: 2021/8/8 15:20
 * @Author:dizhongdi
 */
@SpringBootTest
public class WrapperTest {

    @Autowired
    UserMapper userMapper;

    // 查询name不为空的用户，并且邮箱不为空的用户，年龄大于等于12
    @Test
    public void test1(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name");
        wrapper.isNotNull("email");
        wrapper.ge("age",12);
        userMapper.selectList(wrapper).forEach(System.out::println);

    }

    // 查询名字弟中弟
    @Test
    public void test2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","弟中弟");
        System.out.println(userMapper.selectOne(wrapper));
    }

    // 查询年龄在 20 ~ 30 岁之间的用户人数
    @Test
    public void test3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,30);
        System.out.println(userMapper.selectCount(wrapper));
    }

    // 模糊查询
    @Test
    public void test4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 左和右 t%
        //邮箱以t开头的
        wrapper
                .likeLeft("email","m")
                //名字里没有J的
                .notLike("name","J");
        userMapper.selectMaps(wrapper).forEach(System.out::println);
    }

    // 模糊查询
    @Test
    public void test5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // id 在子查询中查出来
        wrapper.inSql("id","select id from user where id>3 and age >18");
        userMapper.selectMaps(wrapper).forEach(System.out::println);
    }

    // 通过id进行排序
    @Test
    public void test6(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        userMapper.selectMaps(wrapper).forEach(System.out::println);
    }


}
