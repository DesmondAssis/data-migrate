package com.desmond.datamigrate.util.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class DBPool {
	private static BoneCP connectionPool = null;
	
	public static void init(Properties property) throws Exception {
		if(property != null) {
			Class.forName(property.getProperty(DB_DRIVER));
			BoneCPConfig config = new BoneCPConfig();
			config.setJdbcUrl(property.getProperty(JDBC_URL));
			config.setUsername(property.getProperty(USER_NAME));
			config.setPassword(property.getProperty(PASSWORD));
			config.setMinConnectionsPerPartition(Integer.valueOf(property.getProperty(BONECP_MIN_CONN_PER_PARTITION, "1")));
			config.setMaxConnectionsPerPartition(Integer.valueOf(property.getProperty(BONECP_MAX_CONN_PER_PARTITION, "2")));
			config.setPartitionCount(Integer.valueOf(property.getProperty(BONECP_PARTITION_COUNT, "2")));
			config.setIdleMaxAge(Integer.valueOf(property.getProperty(BONECP_IDLEMAXAGE, "10")), TimeUnit.MINUTES);
			
			connectionPool = new BoneCP(config);
			
		}
	}
	
	public static boolean isDBPoolReady() {
		if(connectionPool == null) {
			return false;
		}
		
		return true;
	}
	
	public static int getPoolConnectionCounts() {
		int count = 0;
		if(connectionPool != null) {
			count = connectionPool.getTotalCreatedConnections();
		}
		
		return count;
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		if(connectionPool == null) {
			return null;
		} else {
			try {
				conn = connectionPool.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
	}
	
	public static void shutDownPool() {
		if(connectionPool != null) {
			connectionPool.shutdown();
		}
	}
	
	public static void mock() {
		String url = "jdbc:mysql://localhost:3306/liferay?useUnicode=true&characterEncoding=UTF-8";
		String user = "root";
		String pwd = "root";
		String driverClass = "com.mysql.jdbc.Driver";
		Properties pro = new Properties();
		pro.setProperty(DB_DRIVER, driverClass);
		pro.setProperty(JDBC_URL, url);
		pro.setProperty(USER_NAME, user);
		pro.setProperty(PASSWORD, pwd);
		
		try {
			init(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static final String SERVER_NAME = "server-name";
	public static final String DB_DRIVER = "db-driver";
	public static final String JDBC_URL = "jdbc-url";
	public static final String USER_NAME = "user-name";
	public static final String PASSWORD = "password";
	public static final String BONECP_MIN_CONN_PER_PARTITION = "bonecp.min.connections.per.partition";
	public static final String BONECP_MAX_CONN_PER_PARTITION = "bonecp.max.connections.per.partition";
	public static final String BONECP_PARTITION_COUNT = "bonecp.partition.count";
	public static final String BONECP_IDLEMAXAGE = "bonecp.partition.idle.max.age";
}
