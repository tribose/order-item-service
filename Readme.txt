A > Exposed REST URI:

1. Create an Order Item : POST Service

	http://localhost:8082/items
	
	Sample Request Body: 
	{
		"productName" : "Shirt",
		"quantity" : 20
	}
	
2. Get All Order Items: GET Service

	http://localhost:8082/items
	
3. Get Order Item by Item name : GET Service

	http://localhost:8082/items/product/{productName}
	
4. Get Single ORder Item by product code

	http://localhost:8082/items/{id}
	
B > To Open H2 DB UI console

	http://localhost:8082/h2-console/

	Driver class : org.h2.Driver

	JDBC URL : jdbc:h2:mem:orderitemdb
	
	User name : admin
	
	Password: password