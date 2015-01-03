package com.desmond.datamigrate.ge.mg.impl.model;

import com.desmond.datamigrate.ge.mg.intf.MigrateBatch;

import com.desmond.datamigrate.ge.mg.impl.model.base.BaseModelImpl;

public class MigrateBatchImpl extends BaseModelImpl implements MigrateBatch{
		private long migrateBatchId;
	private long migrateProviderId;
	private long groupId;
	private String groupName;
	private int migrateStatusId;
	private String name;
	private String parameters;
	private String server;
	private long totalCount;
	private long successCount;
	private long failureCount;
	private String note;
	private long createdBy;
	private long modifiedBy;

		public long getMigrateBatchId() {		return migrateBatchId;	}
	public void setMigrateBatchId(long migrateBatchId) {		this.migrateBatchId = migrateBatchId;	}
	public long getMigrateProviderId() {		return migrateProviderId;	}
	public void setMigrateProviderId(long migrateProviderId) {		this.migrateProviderId = migrateProviderId;	}
	public long getGroupId() {		return groupId;	}
	public void setGroupId(long groupId) {		this.groupId = groupId;	}
	public String getGroupName() {		return groupName;	}
	public void setGroupName(String groupName) {		this.groupName = groupName;	}
	public int getMigrateStatusId() {		return migrateStatusId;	}
	public void setMigrateStatusId(int migrateStatusId) {		this.migrateStatusId = migrateStatusId;	}
	public String getName() {		return name;	}
	public void setName(String name) {		this.name = name;	}
	public String getParameters() {		return parameters;	}
	public void setParameters(String parameters) {		this.parameters = parameters;	}
	public String getServer() {		return server;	}
	public void setServer(String server) {		this.server = server;	}
	public long getTotalCount() {		return totalCount;	}
	public void setTotalCount(long totalCount) {		this.totalCount = totalCount;	}
	public long getSuccessCount() {		return successCount;	}
	public void setSuccessCount(long successCount) {		this.successCount = successCount;	}
	public long getFailureCount() {		return failureCount;	}
	public void setFailureCount(long failureCount) {		this.failureCount = failureCount;	}
	public String getNote() {		return note;	}
	public void setNote(String note) {		this.note = note;	}
	public long getCreatedBy() {		return createdBy;	}
	public void setCreatedBy(long createdBy) {		this.createdBy = createdBy;	}
	public long getModifiedBy() {		return modifiedBy;	}
	public void setModifiedBy(long modifiedBy) {		this.modifiedBy = modifiedBy;	}

	
	public MigrateBatch mockMigrateBatchImpl() {
		MigrateBatch migratebatch = new MigrateBatchImpl();
				migratebatch.setMigrateBatchId(Math.round(10000));		migratebatch.setMigrateProviderId(Math.round(10000));		migratebatch.setGroupId(Math.round(10000));		migratebatch.setGroupName("GroupName" + Math.round(100000000));		migratebatch.setMigrateStatusId(Math.round(100));		migratebatch.setName("Name" + Math.round(100000000));		migratebatch.setParameters("Parameters" + Math.round(100000000));		migratebatch.setServer("Server" + Math.round(100000000));		migratebatch.setTotalCount(Math.round(10000));		migratebatch.setSuccessCount(Math.round(10000));		migratebatch.setFailureCount(Math.round(10000));		migratebatch.setNote("Note" + Math.round(100000000));		migratebatch.setCreatedBy(Math.round(10000));		migratebatch.setModifiedBy(Math.round(10000));
		
		return migratebatch;
	}
}
