DROP TABLE IF EXISTS tbl_orderitem;
	 
CREATE TABLE tbl_orderitem (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  product_code VARCHAR(250) NOT NULL,
  product_name VARCHAR(250) NOT NULL,
  quantity INT NOT NULL
);

INSERT INTO tbl_orderitem (product_code, product_name, quantity) VALUES ('P1000', 'Shirt', 10);
INSERT INTO tbl_orderitem (product_code, product_name, quantity) VALUES ('P1001', 'Trouser', 10);
INSERT INTO tbl_orderitem (product_code, product_name, quantity) VALUES ('P1002', 'Mask', 15);
INSERT INTO tbl_orderitem (product_code, product_name, quantity) VALUES ('P1003', 'Mobile', 5);