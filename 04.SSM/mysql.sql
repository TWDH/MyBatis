CREATE DATABASE ssm;
USE ssm

-- 商品
CREATE TABLE product
(
id INT AUTO_INCREMENT PRIMARY KEY ,
productNum VARCHAR(50) UNIQUE NOT NULL,
productName VARCHAR(50),
cityName VARCHAR(50),
DepartureTime TIMESTAMP,
productPrice DOUBLE,
productDesc VARCHAR(500),
productStatus INT
);


INSERT INTO product(id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus) VALUES (1, 'itcast-001', '北京三日游', '北京', '20181010101000', 1200, '不错的旅行', 1);
INSERT INTO product (id, productnum, productname, cityname, departuretime, productprice,productdesc, productstatus) VALUES (2,'itcast-002', '北京一日游', '北京', '20181010101000', 1200, '不错的旅行', 1); 
INSERT INTO product (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus) VALUES (3, 'itcast-003', '上海五日游', '上海', '20180425143000', 1800, '魔都我来了', 0);

-- 会员
CREATE TABLE member(
       id INT AUTO_INCREMENT PRIMARY KEY,
       NAME VARCHAR(20),
       nickname VARCHAR(20),
       phoneNum VARCHAR(20),
       email VARCHAR(20) 
);
INSERT INTO MEMBER (id, NAME, nickname, phonenum, email)
VALUES (1, '张三', '小三', '18888888888', 'zs@163.com');

-- 旅行
CREATE TABLE traveller(
  id INT AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(20),
  sex VARCHAR(20),
  phoneNum VARCHAR(20),
  credentialsType INT,
  credentialsNum VARCHAR(50),
  travellerType INT
);

INSERT INTO traveller (id, NAME, sex, phonenum, credentialstype, credentialsnum, travellertype)
VALUES (1, '张龙', '男', '13333333333', 0,'123456789009876543', 0);
INSERT INTO traveller (id, NAME, sex, phonenum, credentialstype, credentialsnum, travellertype)
VALUES (2, '张小龙', '男', '15555555555', 0,'987654321123456789', 1);

-- 订单
CREATE TABLE orders(
  id INT AUTO_INCREMENT PRIMARY KEY,
  orderNum VARCHAR(20) NOT NULL UNIQUE,
  orderTime TIMESTAMP,
  peopleCount INT,
  orderDesc VARCHAR(500),
  payType INT,
  orderStatus INT,
  productId INT,
  memberId INT,
  FOREIGN KEY (productId) REFERENCES product(id),
  FOREIGN KEY (memberId) REFERENCES member(id)
)

INSERT INTO orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
VALUES (1, '67890', '20180302120000', 2, '没什么', 0, 1, 1,1);
INSERT INTO orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
VALUES (2, '12345', '20180302120000', 2, '没什么', 0, 1, 2,1);
INSERT INTO orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
VALUES (3, '54321', '20180302120000', 2, '没什么', 0, 1, 3,1);
INSERT INTO orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
VALUES (4, '98765','20180302120000', 2, '没什么', 0, 1, 1,1);
INSERT INTO orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
VALUES (5, '11111', '20180302120000', 2, '没什么', 0, 1, 2, 1);
INSERT INTO orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
VALUES (6, '22222', '20180302120000', 2, '没什么', 0, 1, 3, 1);
INSERT INTO orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
VALUES (7, '33333', '20180302120000', 2, '没什么', 0, 1, 3, 1);
INSERT INTO orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
VALUES (8, '44444','20180302120000', 2, '没什么', 0, 1, 2, 1);
INSERT INTO orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid, memberid)
VALUES (9, '55555','20180302120000', 2, '没什么', 0, 1, 1, 1);

-- 订单与旅客中间表

CREATE TABLE order_traveller(
  orderId INT,
  travellerId INT,
  PRIMARY KEY (orderId,travellerId),
  FOREIGN KEY (orderId) REFERENCES orders(id),
  FOREIGN KEY (travellerId) REFERENCES traveller(id)
)

INSERT INTO order_traveller (orderid, travellerid)
VALUES (1, 1);
INSERT INTO order_traveller (orderid, travellerid)
VALUES (2, 1);
INSERT INTO order_traveller (orderid, travellerid)
VALUES (3, 2);
INSERT INTO order_traveller (orderid, travellerid)
VALUES (4, 2);
INSERT INTO order_traveller (orderid, travellerid)
VALUES (5, 1);
INSERT INTO order_traveller (orderid, travellerid)
VALUES (6, 2);
INSERT INTO order_traveller (orderid, travellerid)
VALUES (7, 1);
INSERT INTO order_traveller (orderid, travellerid)
VALUES (8, 2);
INSERT INTO order_traveller (orderid, travellerid)
VALUES (9, 2);


-- 权限
-- 用户表
CREATE TABLE users(
id INT AUTO_INCREMENT PRIMARY KEY,
email VARCHAR(50) NOT NULL UNIQUE,
username VARCHAR(50),
PASSWORD VARCHAR(50),
phoneNum VARCHAR(20),
STATUS INT
)


-- 角色表
CREATE TABLE role(
id AUTO_INCREMENT INT PRIMARY KEY,
roleName VARCHAR(50) ,
roleDesc VARCHAR(50)
)


-- 用户角色关联表
CREATE TABLE users_role(
userId INT,
roleId INT,
PRIMARY KEY(userId,roleId),
FOREIGN KEY (userId) REFERENCES users(id),
FOREIGN KEY (roleId) REFERENCES role(id)
)

-- 资源权限表
CREATE TABLE permission(
id INT AUTO_INCREMENT PRIMARY KEY,
permissionName VARCHAR(50) ,
url VARCHAR(50)
)

-- 角色权限关联表
CREATE TABLE role_permission(
permissionId INT,
roleId INT,
PRIMARY KEY(permissionId,roleId),
FOREIGN KEY (permissionId) REFERENCES permission(id),
FOREIGN KEY (roleId) REFERENCES role(id)
)

-- AOP log
CREATE TABLE sysLog(
id INT AUTO_INCREMENT PRIMARY KEY,
visitTime TIMESTAMP,
username VARCHAR(50),
ip VARCHAR(30),
url VARCHAR(50),
executionTime INT,
method VARCHAR(200)
)

-- select * from role where id in (select roleId from users_role where userId=1)
-- select * from users;
-- select * from role where id in (select roleId from users_role where userId=1)
-- select * from permission 
