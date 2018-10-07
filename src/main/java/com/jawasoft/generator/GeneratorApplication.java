package com.jawasoft.generator;

import com.jawasoft.generator.application.Application;
import com.jawasoft.generator.task.*;

/**
 * 程序入口
 * 
 * @version
 * 
 * <pre>
 * Author	Version		Date		Changes
 * qiyongkang 	1.0  		2017年4月25日 	Created
 * </pre>
 * 
 * @since 1.
 */
public class GeneratorApplication {

    public static void main(String[] args) {
        // 程序入口
        Application application = new Application(GeneratorApplication.class.getSimpleName());
        application.parseArgs(args);
        application.setApplicationName(GeneratorApplication.class.getName());
        application.addApplicationTask(InitTask.class) // 获取数据库表以及字段相关信息
            .addApplicationTask(CombineInfoTask.class) // 基本信息封装
            .addApplicationTask(EntityTask.class) // 生成Entity
            .addApplicationTask(DaoTask.class) // 生成Dao
            .addApplicationTask(MapperTask.class) // 生成Mapper.xml
            .addApplicationTask(ServiceTask.class) // 生成Service
            .addApplicationTask(ServiceImplTask.class) // 生成ServiceImpl
            .work();
    }
}
