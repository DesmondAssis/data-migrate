

drop table if exists migrate_MigrateTask;
create table migrate_MigrateTask (	migrateTaskId BIGINT(25) PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	migrateBatchId BIGINT(25) ,	sourceId BIGINT(25) ,	migrateTypeId INT ,	name VARCHAR(75) ,	priority INT ,	migrateStatusId INT ,	elapsedMillisec BIGINT(25) ,	result VARCHAR(75) ,	server VARCHAR(75) ,	successCount INT ,	failureCount INT ,	createdBy BIGINT(25) ,	modifiedBy BIGINT(25) ) engine InnoDB;