

drop table if exists migrate_MigrateBatch;
create table migrate_MigrateBatch (	migrateBatchId BIGINT(25) PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	migrateProviderId BIGINT(25) ,	groupId BIGINT(25) ,	groupName VARCHAR(75) ,	migrateStatusId INT ,	name VARCHAR(75) ,	parameters VARCHAR(75) ,	server VARCHAR(75) ,	totalCount BIGINT(25) ,	successCount BIGINT(25) ,	failureCount BIGINT(25) ,	note VARCHAR(75) ,	createdBy BIGINT(25) ,	modifiedBy BIGINT(25) ) engine InnoDB;