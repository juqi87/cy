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
DELIMITER //
create function currval(v_seq_name VARCHAR(50))
    returns integer(11)
begin
 declare value integer;
 set value = 0;
select current_val into value  from  `sequence` where seq_name = v_seq_name;
return value;
end;//
DELIMITER ;
-- 创建 函数 用于获取序列下一个值(v_seq_name 参数值 代表序列名称)
DELIMITER //
create function nextval (v_seq_name VARCHAR(50)) returns integer
begin
update sequence set current_val = current_val + increment_val  where seq_name = v_seq_name;
return currval(v_seq_name);
end;//
DELIMITER ;

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



INSERT INTO cy.cy_ord_log (trans_date, trans_seq_id, trans_type, mu_card, points, ip_address, partner_id, stat, ord_id, resp_code, resp_msg, create_at, update_at) VALUES ('20240716', '0000000001', 'CYDH', '614011667001', '500', '112.64.63.231', 'S9990188', 'I', null, null, null, '2024-07-16 15:11:16', '2024-07-16 15:11:16');
INSERT INTO cy.cy_ord_log (trans_date, trans_seq_id, trans_type, mu_card, points, ip_address, partner_id, stat, ord_id, resp_code, resp_msg, create_at, update_at) VALUES ('20240717', '0000000002', 'CYDH', '111', '100', '112.64.63.231', 'S9990188', 'F', null, '9999', 'IP白名单校验失败', '2024-07-17 15:17:12', '2024-07-17 15:17:23');
INSERT INTO cy.cy_ord_log (trans_date, trans_seq_id, trans_type, mu_card, points, ip_address, partner_id, stat, ord_id, resp_code, resp_msg, create_at, update_at) VALUES ('20240717', '0000000003', 'CYDH', '614011667001', '100', '112.64.63.231', 'S9990188', 'P', 'MU24071716481287000059', '0', '成功', '2024-07-17 16:48:01', '2024-07-17 16:48:13');
INSERT INTO cy.cy_ord_log (trans_date, trans_seq_id, trans_type, mu_card, points, ip_address, partner_id, stat, ord_id, resp_code, resp_msg, create_at, update_at) VALUES ('20240717', '0000000004', 'CYDH', '614011667001', '100', '112.64.63.231', 'S9990188', 'P', 'MU24071717021287000062', '0', '成功', '2024-07-17 17:02:01', '2024-07-17 17:02:01');
INSERT INTO cy.cy_ord_log (trans_date, trans_seq_id, trans_type, mu_card, points, ip_address, partner_id, stat, ord_id, resp_code, resp_msg, create_at, update_at) VALUES ('20240717', '0000000005', 'CYDH', '614011667001', '100', '112.64.63.231', 'S9990188', 'P', 'MU24071717041287000063', '0', '成功', '2024-07-17 17:04:10', '2024-07-17 17:04:21');
INSERT INTO cy.cy_ord_log (trans_date, trans_seq_id, trans_type, mu_card, points, ip_address, partner_id, stat, ord_id, resp_code, resp_msg, create_at, update_at) VALUES ('20240717', '0000000006', 'CYDH', '614011667001', '100', '112.64.63.231', 'S9990188', 'P', 'MU24071717051287000064', '0', '成功', '2024-07-17 17:05:09', '2024-07-17 17:05:09');
INSERT INTO cy.cy_ord_log (trans_date, trans_seq_id, trans_type, mu_card, points, ip_address, partner_id, stat, ord_id, resp_code, resp_msg, create_at, update_at) VALUES ('20240717', '0000000007', 'CYDH', '614011667001', '100', '112.64.63.231', 'S9990188', 'F', 'MU24071717071287000065', '0', '成功', '2024-07-17 17:07:17', '2024-07-17 18:39:45');
