create table project (id bigint not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table version (version integer not null, id bigint not null auto_increment, project_id bigint not null, primary key (id)) engine=InnoDB;
alter table version add constraint FK5q7csydn4alo2pf0bbv74g9ko foreign key (project_id) references project (id);
create table project (id bigint not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table version (version integer not null, id bigint not null auto_increment, project_id bigint not null, primary key (id)) engine=InnoDB;
alter table version add constraint FK5q7csydn4alo2pf0bbv74g9ko foreign key (project_id) references project (id);
