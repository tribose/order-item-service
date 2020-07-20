DROP TABLE IF EXISTS tbl_orderitem;
	 
CREATE TABLE tbl_orderitem (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  product_code INT NOT NULL,
  product_name VARCHAR(250) NOT NULL,
  quantity INT NOT NULL
);