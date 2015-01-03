

drop table if exists migrate_MigrateTaskLog;
create table migrate_MigrateTaskLog (	migrateTaskLogId BIGINT(25) PRIMARY KEY ,	migrateTaskId BIGINT(25) ,	sourceId BIGINT(25) ,	type_ INT ,	statusId INT ,	elapsedMillisec BIGINT(25) ,	successCount INT ,	failureCount INT ,	result VARCHAR(75) ) engine InnoDB;