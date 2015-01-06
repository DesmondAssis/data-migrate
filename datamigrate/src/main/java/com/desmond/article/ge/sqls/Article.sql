

drop table if exists art_Article;
create table art_Article (	articleId BIGINT(25) PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	pubDate TIMESTAMP ,	title VARCHAR(75) ,	description LONGTEXT ,	link VARCHAR(300) ,	author VARCHAR(75) ,	guid VARCHAR(75) ,	category VARCHAR(75) ,	comments LONGTEXT ) engine InnoDB;