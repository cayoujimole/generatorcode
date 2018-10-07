/**
 * Project Name:testJava
 * File Name:DbUtil.java
 * Package Name:com.qiyongkang.db.util
 * Date:2015年11月13日下午6:00:34
 * Copyright (c) 2015, CANNIKIN(http://http://code.taobao.org/p/cannikin/src/) All Rights Reserved.
 *
*/

package com.jawasoft.generator.util;

import com.jawasoft.generator.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Properties;

/**
 * 数据库连接工具类
 */
public class DbUtil {

    /**
     * 日志类
     */
    private static Logger logger = LoggerFactory.getLogger("DbUtil");

    /**
     * 加载驱动
     */
    static {
        try {
            String driverName = Configuration.getString("jdbc.driverName");
            Class.forName(driverName);

            logger.info("加载驱动成功：{}", driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * getConn:获取连接.
     */
    public static Connection getConn() {
        Connection conn = null;
        try {
            String jdbcUrl = Configuration.getString("jdbc.url");
            String userName = Configuration.getString("jdbc.username");
            String password = Configuration.getString("jdbc.password");
            Properties props = new Properties();
            props.put("remarksReporting", "true");
            props.put("user", userName);
            props.put("password", password);
            conn = DriverManager.getConnection(jdbcUrl, props);
        } catch (SQLException e) {
            logger.error("数据连接异常", e);
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * closeConn:关闭连接
     */
    public static void closeReso(Connection conn, Statement stat, ResultSet resultSet) {
        try {
            if (conn != null) conn.close();
            if (stat != null) stat.close();
            if (resultSet != null) resultSet.close();
            logger.info("关闭资源成功。。。");
        } catch (SQLException e) {
            logger.error("关闭连接异常", e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(getConn());
    }
}
