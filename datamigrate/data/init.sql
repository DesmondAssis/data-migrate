drop table if exists Article;
create table Article (
	articleId bigint not null primary key,
	createDate datetime null,
	modifiedDate datetime null,
	pubDate datetime null,
	title longtext not null,
	description longtext null,
	link varchar(300) null,
	author varchar(75) null,
	guid varchar(75) null,
	category varchar(75) null,
	comments longtext null
) engine InnoDB;

