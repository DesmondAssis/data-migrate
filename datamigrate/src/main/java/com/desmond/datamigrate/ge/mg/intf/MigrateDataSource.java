package com.desmond.datamigrate.ge.mg.intf;


import com.desmond.datamigrate.ge.mg.intf.base.BaseModel;

public interface MigrateDataSource extends BaseModel{
		public long getDataSourceId();
	public void setDataSourceId(long dataSourceId);
	public String getServerName();
	public void setServerName(String serverName);
	public String getJdbcURL();
	public void setJdbcURL(String jdbcURL);
	public String getUserName();
	public void setUserName(String userName);
	public String getPassword();
	public void setPassword(String password);

}
