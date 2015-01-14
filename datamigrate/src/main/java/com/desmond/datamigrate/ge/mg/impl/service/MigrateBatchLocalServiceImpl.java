package com.desmond.datamigrate.ge.mg.impl.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

import com.desmond.datamigrate.enums.MigrateStatusEnum;
import com.desmond.datamigrate.ge.mg.impl.model.MigrateBatchImpl;
import com.desmond.datamigrate.ge.mg.intf.MigrateBatch;

public class MigrateBatchLocalServiceImpl extends MigrateBatchServiceBaseImpl{
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. 
	 * Add your custom code here.
	 */
	
	public MigrateBatch setStatus(long batchId, int migrateStatusId, String username, boolean throwError) throws Exception {
		MigrateBatch batch = this.fetchByPrimaryKey(batchId);
		int migStatus = batch.getMigrateStatusId();
		
		// if status is not changed
		if(migrateStatusId == migStatus) {
			return batch;
		}
		
		boolean isInvalidTransition = false;
		
		switch(MigrateStatusEnum.getMigrateStatus(migrateStatusId)) {
			case RUNNING:
			case PENDING:
				if(migStatus != MigrateStatusEnum.PAUSED.getId()) {
					isInvalidTransition = true;
				}
				break;
				
			case PAUSED:
				if(batch.getMigrateBatchId() != MigrateStatusEnum.PENDING.getId() && migStatus != MigrateStatusEnum.RUNNING.getId()) {
					isInvalidTransition = true;
				}
				break;
			
			case CANCELED:
				if(migStatus != MigrateStatusEnum.RUNNING.getId() && migStatus != MigrateStatusEnum.PENDING.getId() && migStatus != MigrateStatusEnum.PAUSED.getId()) {
					isInvalidTransition = true;
				}
				break;
				
			case COMPLETED:
				if(migStatus != MigrateStatusEnum.RUNNING.getId() && !(batch.getTotalCount()==0 && migStatus == MigrateStatusEnum.PAUSED.getId())) {
					isInvalidTransition = true;
				}
				break;
				
			default:
				isInvalidTransition = true;
				break;
		}
		
		if(isInvalidTransition) {
			if(throwError) {
				throw new Exception("Invalid status change from " + MigrateStatusEnum.getName(migStatus) + " to　" + MigrateStatusEnum.getName(migrateStatusId) + " for migrate batch " + batch.getMigrateBatchId());
			} else {
				return batch;
			}
		}
		
		batch.setMigrateStatusId(migrateStatusId);
		batch.setModifiedDate(new Timestamp(new Date().getTime()));
		batch.setModifiedBy(1);
		
		this.update(batch);
		
		return batch;
	}
	
	public void addMigrateBatch(long providerId, long groupId, String server, String name, Properties properties, long count, String note, String user) {
		MigrateBatch batch = new MigrateBatchImpl();
		
		batch.setMigrateProviderId(providerId);
		batch.setGroupId(groupId);
		batch.setGroupName("id=" + groupId);
		batch.setServer(server);
		batch.setMigrateStatusId(MigrateStatusEnum.PAUSED.getId());
		batch.setName(name);
		batch.setParameters(properties.toString());
		batch.setTotalCount(count);
		batch.setNote(note);
		batch.setCreatedBy(1);
		
		this.add(batch);
	}
}

















