CREATE DATABASE cy CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'cy'@'localhost' IDENTIFIED BY 'cy20240708';
GRANT ALL PRIVILEGES ON cy.* TO 'cy'@'localhost';

create table TEST
(
    DB_STAT char null comment '数据库状态'
)comment '测试表';
insert into TEST values('N');


-- mysql序列表
drop table if exists sequence;
create table sequence (
                          seq_name        VARCHAR(50) NOT NULL, -- 序列名称
                          current_val     INT         NOT NULL, -- 当前值
                          increment_val   INT         NOT NULL    DEFAULT 1, -- 步长(跨度)
                          PRIMARY KEY (seq_name)
);
-- 创建 函数 用于获取序列当前值(v_seq_name 参数值 代表序列名称)（提供两种执行方式）
create function currval(v_seq_name VARCHAR(50))
    returns integer(11)
begin
 declare value integer;
 set value = 0;
select current_val into value  from sequence where seq_name = v_seq_name;
return value;
end;
-- 创建 函数 用于获取序列下一个值(v_seq_name 参数值 代表序列名称)
create function nextval (v_seq_name VARCHAR(50)) returns integer
begin
update sequence set current_val = current_val + increment_val  where seq_name = v_seq_name;
return currval(v_seq_name);
end;


INSERT INTO sequence VALUES ('CY_ORD_SEQ_ID', '0', '1');


-- auto-generated definition
create table cy_ord_log
(
    trans_date   char(8)                             not null comment '交易日期',
    trans_seq_id varchar(10)                         not null comment '交易流水',
    trans_type   varchar(4)                          not null comment '交易类型',
    mu_card      varchar(16)                         not null comment '东航卡号',
    points       varchar(10)                         not null comment '充值东航积分',
    ip_address   varchar(15)                         not null comment '请求IP',
    partner_id   varchar(10)                         null comment '商户编号',
    stat         char                                not null comment '订单状态',
    ord_id       varchar(28)                         null comment '流水号',
    resp_code    varchar(6)                          null,
    resp_msg     text                                null,
    create_at    timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    update_at    timestamp                           null on update CURRENT_TIMESTAMP,
    primary key (trans_date, trans_seq_id)
)
    comment '畅由订单';



