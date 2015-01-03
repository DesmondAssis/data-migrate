package com.desmond.datamigrate.ge.mg.impl.model;

import com.desmond.datamigrate.ge.mg.intf.MigrateDataSource;

import com.desmond.datamigrate.ge.mg.impl.model.base.BaseModelImpl;

public class MigrateDataSourceImpl extends BaseModelImpl implements MigrateDataSource{
		private long dataSourceId;
	private String serverName;
	private String jdbcURL;
	private String userName;
	private String password;

		public long getDataSourceId() {		return dataSourceId;	}
	public void setDataSourceId(long dataSourceId) {		this.dataSourceId = dataSourceId;	}
	public String getServerName() {		return serverName;	}
	public void setServerName(String serverName) {		this.serverName = serverName;	}
	public String getJdbcURL() {		return jdbcURL;	}
	public void setJdbcURL(String jdbcURL) {		this.jdbcURL = jdbcURL;	}
	public String getUserName() {		return userName;	}
	public void setUserName(String userName) {		this.userName = userName;	}
	public String getPassword() {		return password;	}
	public void setPassword(String password) {		this.password = password;	}

	
	public MigrateDataSource mockMigrateDataSourceImpl() {
		MigrateDataSource migratedatasource = new MigrateDataSourceImpl();
				migratedatasource.setDataSourceId(Math.round(10000));		migratedatasource.setServerName("ServerName" + Math.round(100000000));		migratedatasource.setJdbcURL("JdbcURL" + Math.round(100000000));		migratedatasource.setUserName("UserName" + Math.round(100000000));		migratedatasource.setPassword("Password" + Math.round(100000000));
		
		return migratedatasource;
	}
}
