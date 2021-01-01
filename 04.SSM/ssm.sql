-- 企业权限管理用mysql做的代码：
CREATE DATABASE ssm;
USE ssm

CREATE TABLE order_traveller(
  orderId INT,
  travellerId INT,
  PRIMARY KEY (orderId,travellerId),
  FOREIGN KEY (orderId) REFERENCES orders(id),
  FOREIGN KEY (travellerId) REFERENCES traveller(id)
)

-- 会员
CREATE TABLE member(
       id VARCHAR(32) PRIMARY KEY,
       NAME VARCHAR(20),
       nickname VARCHAR(20),
       phoneNum VARCHAR(20),
       email VARCHAR(50) 
);

CREATE TABLE product
(
id VARCHAR(32) PRIMARY KEY ,
productNum VARCHAR(50) UNIQUE NOT NULL,
productName VARCHAR(50),
cityName VARCHAR(50),
DepartureTime TIMESTAMP,
productPrice DOUBLE,
productDesc VARCHAR(500),
productStatus INT
);

CREATE TABLE traveller(
id varchar(32)  PRIMARY KEY,
NAME VARCHAR(20),
sex VARCHAR(20),
phoneNum VARCHAR(20),
credentialsType INT,
credentialsNum VARCHAR(50),
travellerType INT
);

CREATE TABLE orders(
  id VARCHAR(32) PRIMARY KEY,
  orderNum VARCHAR(50) NOT NULL UNIQUE,
  orderTime TIMESTAMP,
  peopleCount INT,
  orderDesc VARCHAR(500),
  payType INT,
  orderStatus INT,
  productId VARCHAR(32),
  memberId VARCHAR(32),
  FOREIGN KEY (productId) REFERENCES product(id),
  FOREIGN KEY (memberId) REFERENCES member(id)
);


CREATE TABLE order_traveller(
orderId varchar(32),
travellerId varchar(32),
PRIMARY KEY (orderId,travellerId),
FOREIGN KEY (orderId) REFERENCES orders(id),
FOREIGN KEY (travellerId) REFERENCES traveller(id)
)


--产品
INSERT INTO product(id, productnum, productname, cityname, departuretime, productprice,
productdesc, productstatus)
VALUES ('9F71F01CB448476DAFB309AA6DF9497F', 'itcast-001', '北京三日游', '北京', '20181010101000', 1200, '不错的旅行', 1);


INSERT INTO product (id, productnum, productname, cityname, departuretime, productprice,
productdesc, productstatus)
VALUES ('676C5BD1D35E429A8C2E114939C5685A','itcast-002', '北京一日游', '北京', '20181010101000', 1200, '不错的旅行', 1);


INSERT INTO product (id, productnum, productname, cityname, departuretime, productprice,
productdesc, productstatus)
VALUES ('12B7ABF2A4C544568B0A7C69F36BF8B7', 'itcast-003', '上海五日游', '上海', '20180425143000', 1800, '魔都我来了', 0);


--订单


insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
values ('2FF351C4AC744E2092DCF08CFD314420', '67890', '20180302120000', 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7','E61D65F673D54F68B0861025C69773DB');
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
values ('0E7231DC797C486290E8713CA3C6ECCC', '12345', '20180302120000', 2, '没什么', 0, 1, '676C5BD1D35E429A8C2E114939C5685A','E61D65F673D54F68B0861025C69773DB');
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
values ('5DC6A48DD4E94592AE904930EA866AFA', '54321', '20180302120000', 2, '没什么', 0, 1, '676C5BD1D35E429A8C2E114939C5685A','E61D65F673D54F68B0861025C69773DB');
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
values ('A0657832D93E4B10AE88A2D4B70B1A28', '98765','20180302120000', 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7','E61D65F673D54F68B0861025C69773DB');
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
values ('E4DD4C45EED84870ABA83574A801083E', '11111', '20180302120000', 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7','E61D65F673D54F68B0861025C69773DB');
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
values ('96CC8BD43C734CC2ACBFF09501B4DD5D', '22222', '20180302120000', 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7','E61D65F673D54F68B0861025C69773DB');
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
values ('55F9AF582D5A4DB28FB4EC3199385762', '33333', '20180302120000', 2, '没什么', 0, 1, '9F71F01CB448476DAFB309AA6DF9497F','E61D65F673D54F68B0861025C69773DB');
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
values ('CA005CF1BE3C4EF68F88ABC7DF30E976', '44444','20180302120000', 2, '没什么', 0, 1, '9F71F01CB448476DAFB309AA6DF9497F','E61D65F673D54F68B0861025C69773DB');
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
values ('3081770BC3984EF092D9E99760FDABDE', '55555','20180302120000', 2, '没什么', 0, 1, '9F71F01CB448476DAFB309AA6DF9497F','E61D65F673D54F68B0861025C69773DB');


--会员
insert into member (id, name, nickname, phonenum, email)
values ('E61D65F673D54F68B0861025C69773DB', '张三', '小三', '18888888888', 'zs@163.com');


--旅客
insert into traveller (id, name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('3FE27DF2A4E44A6DBC5D0FE4651D3D3E', '张龙', '男', '13333333333', 0,
'123456789009876543', 0);
insert into traveller (id, name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('EE7A71FB6945483FBF91543DBE851960', '张小龙', '男', '15555555555', 0,
'987654321123456789', 1);

--中间表
insert into order_traveller (orderid, travellerid)
values ('0E7231DC797C486290E8713CA3C6ECCC', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into order_traveller (orderid, travellerid)
values ('2FF351C4AC744E2092DCF08CFD314420', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into order_traveller (orderid, travellerid)
values ('3081770BC3984EF092D9E99760FDABDE', 'EE7A71FB6945483FBF91543DBE851960');
insert into order_traveller (orderid, travellerid)
values ('55F9AF582D5A4DB28FB4EC3199385762', 'EE7A71FB6945483FBF91543DBE851960');
insert into order_traveller (orderid, travellerid)
values ('5DC6A48DD4E94592AE904930EA866AFA', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into order_traveller (orderid, travellerid)
values ('96CC8BD43C734CC2ACBFF09501B4DD5D', 'EE7A71FB6945483FBF91543DBE851960');
insert into order_traveller (orderid, travellerid)
values ('A0657832D93E4B10AE88A2D4B70B1A28', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into order_traveller (orderid, travellerid)
values ('CA005CF1BE3C4EF68F88ABC7DF30E976', 'EE7A71FB6945483FBF91543DBE851960');
insert into order_traveller (orderid, travellerid)
values ('E4DD4C45EED84870ABA83574A801083E', 'EE7A71FB6945483FBF91543DBE851960');
