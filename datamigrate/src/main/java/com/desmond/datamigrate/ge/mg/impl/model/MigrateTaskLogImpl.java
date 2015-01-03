package com.desmond.datamigrate.ge.mg.impl.model;

import com.desmond.datamigrate.ge.mg.intf.MigrateTaskLog;

import com.desmond.datamigrate.ge.mg.impl.model.base.BaseModelImpl;

public class MigrateTaskLogImpl extends BaseModelImpl implements MigrateTaskLog{
		private long migrateTaskLogId;
	private long migrateTaskId;
	private long sourceId;
	private int type_;
	private int statusId;
	private long elapsedMillisec;
	private int successCount;
	private int failureCount;
	private String result;

		public long getMigrateTaskLogId() {		return migrateTaskLogId;	}
	public void setMigrateTaskLogId(long migrateTaskLogId) {		this.migrateTaskLogId = migrateTaskLogId;	}
	public long getMigrateTaskId() {		return migrateTaskId;	}
	public void setMigrateTaskId(long migrateTaskId) {		this.migrateTaskId = migrateTaskId;	}
	public long getSourceId() {		return sourceId;	}
	public void setSourceId(long sourceId) {		this.sourceId = sourceId;	}
	public int getType_() {		return type_;	}
	public void setType_(int type_) {		this.type_ = type_;	}
	public int getStatusId() {		return statusId;	}
	public void setStatusId(int statusId) {		this.statusId = statusId;	}
	public long getElapsedMillisec() {		return elapsedMillisec;	}
	public void setElapsedMillisec(long elapsedMillisec) {		this.elapsedMillisec = elapsedMillisec;	}
	public int getSuccessCount() {		return successCount;	}
	public void setSuccessCount(int successCount) {		this.successCount = successCount;	}
	public int getFailureCount() {		return failureCount;	}
	public void setFailureCount(int failureCount) {		this.failureCount = failureCount;	}
	public String getResult() {		return result;	}
	public void setResult(String result) {		this.result = result;	}

	
	public MigrateTaskLog mockMigrateTaskLogImpl() {
		MigrateTaskLog migratetasklog = new MigrateTaskLogImpl();
				migratetasklog.setMigrateTaskLogId(Math.round(10000));		migratetasklog.setMigrateTaskId(Math.round(10000));		migratetasklog.setSourceId(Math.round(10000));		migratetasklog.setType_(Math.round(100));		migratetasklog.setStatusId(Math.round(100));		migratetasklog.setElapsedMillisec(Math.round(10000));		migratetasklog.setSuccessCount(Math.round(100));		migratetasklog.setFailureCount(Math.round(100));		migratetasklog.setResult("Result" + Math.round(100000000));
		
		return migratetasklog;
	}
}
