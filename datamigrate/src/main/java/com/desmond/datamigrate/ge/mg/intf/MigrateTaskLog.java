package com.desmond.datamigrate.ge.mg.intf;


import com.desmond.datamigrate.ge.mg.intf.base.BaseModel;

public interface MigrateTaskLog extends BaseModel{
		public long getMigrateTaskLogId();
	public void setMigrateTaskLogId(long migrateTaskLogId);
	public long getMigrateTaskId();
	public void setMigrateTaskId(long migrateTaskId);
	public long getSourceId();
	public void setSourceId(long sourceId);
	public int getType_();
	public void setType_(int type_);
	public int getStatusId();
	public void setStatusId(int statusId);
	public long getElapsedMillisec();
	public void setElapsedMillisec(long elapsedMillisec);
	public int getSuccessCount();
	public void setSuccessCount(int successCount);
	public int getFailureCount();
	public void setFailureCount(int failureCount);
	public String getResult();
	public void setResult(String result);

}
