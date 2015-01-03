package com.desmond.datamigrate.ge.mg.impl.model;

import com.desmond.datamigrate.ge.mg.intf.MigrateTask;

import com.desmond.datamigrate.ge.mg.impl.model.base.BaseModelImpl;

public class MigrateTaskImpl extends BaseModelImpl implements MigrateTask{
		private long migrateTaskId;
	private long migrateBatchId;
	private long sourceId;
	private int migrateTypeId;
	private String name;
	private int priority;
	private int migrateStatusId;
	private long elapsedMillisec;
	private String result;
	private String server;
	private int successCount;
	private int failureCount;
	private long createdBy;
	private long modifiedBy;

		public long getMigrateTaskId() {		return migrateTaskId;	}
	public void setMigrateTaskId(long migrateTaskId) {		this.migrateTaskId = migrateTaskId;	}
	public long getMigrateBatchId() {		return migrateBatchId;	}
	public void setMigrateBatchId(long migrateBatchId) {		this.migrateBatchId = migrateBatchId;	}
	public long getSourceId() {		return sourceId;	}
	public void setSourceId(long sourceId) {		this.sourceId = sourceId;	}
	public int getMigrateTypeId() {		return migrateTypeId;	}
	public void setMigrateTypeId(int migrateTypeId) {		this.migrateTypeId = migrateTypeId;	}
	public String getName() {		return name;	}
	public void setName(String name) {		this.name = name;	}
	public int getPriority() {		return priority;	}
	public void setPriority(int priority) {		this.priority = priority;	}
	public int getMigrateStatusId() {		return migrateStatusId;	}
	public void setMigrateStatusId(int migrateStatusId) {		this.migrateStatusId = migrateStatusId;	}
	public long getElapsedMillisec() {		return elapsedMillisec;	}
	public void setElapsedMillisec(long elapsedMillisec) {		this.elapsedMillisec = elapsedMillisec;	}
	public String getResult() {		return result;	}
	public void setResult(String result) {		this.result = result;	}
	public String getServer() {		return server;	}
	public void setServer(String server) {		this.server = server;	}
	public int getSuccessCount() {		return successCount;	}
	public void setSuccessCount(int successCount) {		this.successCount = successCount;	}
	public int getFailureCount() {		return failureCount;	}
	public void setFailureCount(int failureCount) {		this.failureCount = failureCount;	}
	public long getCreatedBy() {		return createdBy;	}
	public void setCreatedBy(long createdBy) {		this.createdBy = createdBy;	}
	public long getModifiedBy() {		return modifiedBy;	}
	public void setModifiedBy(long modifiedBy) {		this.modifiedBy = modifiedBy;	}

	
	public MigrateTask mockMigrateTaskImpl() {
		MigrateTask migratetask = new MigrateTaskImpl();
				migratetask.setMigrateTaskId(Math.round(10000));		migratetask.setMigrateBatchId(Math.round(10000));		migratetask.setSourceId(Math.round(10000));		migratetask.setMigrateTypeId(Math.round(100));		migratetask.setName("Name" + Math.round(100000000));		migratetask.setPriority(Math.round(100));		migratetask.setMigrateStatusId(Math.round(100));		migratetask.setElapsedMillisec(Math.round(10000));		migratetask.setResult("Result" + Math.round(100000000));		migratetask.setServer("Server" + Math.round(100000000));		migratetask.setSuccessCount(Math.round(100));		migratetask.setFailureCount(Math.round(100));		migratetask.setCreatedBy(Math.round(10000));		migratetask.setModifiedBy(Math.round(10000));
		
		return migratetask;
	}
}
