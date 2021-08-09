package com.dizhongdi.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:MybatisPlusConfig
 * Package:com.dizhongdi.config
 * Description:
 *
 * @Date: 2021/8/7 23:09
 * @Author:dizhongdi
 */
@Configuration
public class MybatisPlusConfig {
    //注册乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    //注册分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
// 逻辑删除组件！
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

//    配置SQL执行效率插件
    @Bean
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setFormat(true); //设置SQL格式化
        performanceInterceptor.setMaxTime(100);   //设置SQL执行最大时间
        return performanceInterceptor;
    }

}
