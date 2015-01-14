

drop table if exists art_MigrateArticle;
create table art_MigrateArticle (	articleId BIGINT(25) PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	companyId BIGINT(25) ,	groupId BIGINT(25) ,	pubDate TIMESTAMP ,	title VARCHAR(75) ,	description LONGTEXT ,	link VARCHAR(300) ,	author VARCHAR(75) ,	guid VARCHAR(75) ,	category VARCHAR(75) ,	comments LONGTEXT ) engine InnoDB;