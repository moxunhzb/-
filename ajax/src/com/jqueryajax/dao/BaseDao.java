package com.jqueryajax.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	  private static final String DRIVER = "com.mysql.jdbc.Driver";
	    private static final String URL = "jdbc:mysql://localhost:3306/ajax?useUnicode=true&characterEncoding=UTF-8";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "281014";

	    private Connection conn;
	    private PreparedStatement psmt;
	    public ResultSet rs;

	    /**
	     * 获取连接 alt+shift+z:捕获异常
	     */
	    public void getConn() {
	        try {
	            Class.forName(DRIVER);
	            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * 释放资源
	     */
	    public void closeAll() {
	        try {
	            if (rs != null)
	                rs.close();
	            if (psmt != null)
	                psmt.close();
	            if (conn != null)
	                conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * 执行查询的方法
	     * 
	     * @param sql
	     *            :执行的SQL语句
	     * @param parmms
	     *            :占位符的值
	     * @return 封装数据的结果集 String
	     *        
	     */
	    public ResultSet execQuery(String sql, String[] params) {
	        getConn();
	        try {
	            psmt = conn.prepareStatement(sql);// 创建PreparedStatement对象，执行增,删,改,查
	            if (params != null && params.length > 0) {
	                for (int i = 0; i < params.length; i++) {
	                    psmt.setString(i + 1, params[i]);// psmt.setString(1,"aa");
	                }
	            }
	            rs = psmt.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return rs;
	    }

}
