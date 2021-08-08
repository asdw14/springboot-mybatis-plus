package com.dizhongdi;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dizhongdi.mapper.UserMapper;
import com.dizhongdi.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class SpringbootMybatisPlusApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        for (User user:
             users) {
            System.out.println(user);
        }
    }
    @Test
    void insertUser(){
        User user = new User();
        user.setAge(16);
        user.setId(1424013626208956419L);
        user.setEmail("2755063993@qq.com");
        user.setName("弟中弟");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    // 测试乐观锁成功！
    @Test
    public void testOptimisticLocker(){
        // 1、查询用户信息
        User user = userMapper.selectById(6L);
        // 2、修改用户信息
        user.setName("asdw14");
        user.setEmail("1556035287@qq.com");
        // 3、执行更新操作
        userMapper.updateById(user);
    }

    @Test
    //测试乐观锁失败！
    public void testOptimisticLocker2() throws InterruptedException {
        User user = userMapper.selectById(6L);
        user.setName("asdw14111111");
        user.setEmail("155603528711111@qq.com");
        User user2 = userMapper.selectById(6L);
        user2.setName("2222222");
        user2.setEmail("155603528722@qq.com");
        userMapper.updateById(user2);
        Thread.sleep(100);
        userMapper.updateById(user);

    }

    @Test
    public void selectTest1(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    public void selectTest2(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 3, 2));
        users.forEach(System.out::println);
    }

    @Test
    public void selectTest3(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","弟中弟");
        map.put("id",1424013626208956420L);
        userMapper.selectByMap(map);
    }

    //分页
    @Test
    public void pageTest(){
        Page<User> page = new Page<>(2,5);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
    }

    //删除
    @Test
    public void deleteTest(){
        userMapper.deleteById(1424013626208956422L);
        userMapper.deleteBatchIds(Arrays.asList(1424013626208956420L,1424013626208956421L));
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",1424013626208956419L);
        userMapper.deleteByMap(map);
    }
}
