
[//]: # (create DB and user)
CREATE DATABASE cy CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'cy'@'localhost' IDENTIFIED BY 'cy20240708';
GRANT ALL PRIVILEGES ON cy.* TO 'cy'@'localhost';

[//]: # (create test table)
create table TEST
(
DB_STAT char null comment '数据库状态'
)comment '测试表';
insert into TEST values('N');
