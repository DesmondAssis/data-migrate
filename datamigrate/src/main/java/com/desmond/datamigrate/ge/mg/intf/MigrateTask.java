package com.desmond.datamigrate.ge.mg.intf;


import com.desmond.datamigrate.ge.mg.intf.base.BaseModel;

public interface MigrateTask extends BaseModel{
		public long getMigrateTaskId();
	public void setMigrateTaskId(long migrateTaskId);
	public long getMigrateBatchId();
	public void setMigrateBatchId(long migrateBatchId);
	public long getSourceId();
	public void setSourceId(long sourceId);
	public int getMigrateTypeId();
	public void setMigrateTypeId(int migrateTypeId);
	public String getName();
	public void setName(String name);
	public int getPriority();
	public void setPriority(int priority);
	public int getMigrateStatusId();
	public void setMigrateStatusId(int migrateStatusId);
	public long getElapsedMillisec();
	public void setElapsedMillisec(long elapsedMillisec);
	public String getResult();
	public void setResult(String result);
	public String getServer();
	public void setServer(String server);
	public int getSuccessCount();
	public void setSuccessCount(int successCount);
	public int getFailureCount();
	public void setFailureCount(int failureCount);
	public long getCreatedBy();
	public void setCreatedBy(long createdBy);
	public long getModifiedBy();
	public void setModifiedBy(long modifiedBy);

}
