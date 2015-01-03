package com.desmond.datamigrate.ge.mg.intf;


import com.desmond.datamigrate.ge.mg.intf.base.BaseModel;

public interface MigrateBatch extends BaseModel{
		public long getMigrateBatchId();
	public void setMigrateBatchId(long migrateBatchId);
	public long getMigrateProviderId();
	public void setMigrateProviderId(long migrateProviderId);
	public long getGroupId();
	public void setGroupId(long groupId);
	public String getGroupName();
	public void setGroupName(String groupName);
	public int getMigrateStatusId();
	public void setMigrateStatusId(int migrateStatusId);
	public String getName();
	public void setName(String name);
	public String getParameters();
	public void setParameters(String parameters);
	public String getServer();
	public void setServer(String server);
	public long getTotalCount();
	public void setTotalCount(long totalCount);
	public long getSuccessCount();
	public void setSuccessCount(long successCount);
	public long getFailureCount();
	public void setFailureCount(long failureCount);
	public String getNote();
	public void setNote(String note);
	public long getCreatedBy();
	public void setCreatedBy(long createdBy);
	public long getModifiedBy();
	public void setModifiedBy(long modifiedBy);

}
