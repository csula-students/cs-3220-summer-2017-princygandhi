-- Princy Gandhi Lab 5 Queries --
--=================================
--Create restaurant food item table

CREATE TABLE FoodItems (
    ID INTEGER IDENTITY(1,1) PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Description VARCHAR(255) NOT NULL,
    Price DECIMAL(18,2) 
)

--Create restaurant order statuses table

 CREATE TABLE Orders (
    ID INTEGER IDENTITY(1,1) PRIMARY KEY,
    Customer_Name VARCHAR(255) NOT NULL,
    Created DATETIME
)

 CREATE TABLE OrderFoods (
    OrderID INTEGER ,
    FoodID INTEGER ,
    Quantity INTEGER 
)

--Create restaurant cart table

CREATE TABLE ShoppingCart (
    ID INTEGER ,
    Customer_Name VARCHAR(255) NOT NULL,
    FoodID INTEGER,
    Quantity INTEGER
    
)

--Insert default food items into food items table

INSERT INTO FoodItems VALUES
('Hamburger','A Hamburger', 9.99),
('Fries','Some Fries', 4.99),
('Coke','Coke Cola', 2.99);

--Insert default order statuses into order statuses table

INSERT INTO Orders VALUES
('Eric','2017-07-20 13:35:55'),
('John','2017-07-22 10:35:55'), 
('Jane','2017-07-22 15:35:55'), 
('Alice','2017-07-22 16:35:55');

INSERT INTO OrderFoods VALUES 
(1,1,1),(1,2,2),(2,2,2),
(2,3,1),(3,3,1),(4,2,1),(4,3,2);

INSERT INTO ShoppingCart VALUES 
(1,'Anonymous',1,2),(1,'Anonymous',2,1),
(1,'Anonymous',2,1),(2,'Mike',1,1),
(2,'Mike',2,1),(3,'Bob',3,1);


--UPDATE food item name FROM "Hamburger" to "Salad"

UPDATE FoodItems SET Name = 'Salad' WHERE id =1;

--UPDATE customer name FROM "Jane" to "Doe"

UPDATE Orders SET Customer_Name = 'Doe' WHERE id =3;

--Find out which food item has the most orders

SELECT TOP 1 Name, MAX(Quantity) as NumberOfOrders
FROM
(
  SELECT FoodItems.Name,Sum(OrderFoods.Quantity) as Quantity FROM FoodItems INNER JOIN OrderFoods ON FoodItems.ID = OrderFoods.FoodID  
  GROUP BY OrderFoods.FoodID,FoodItems.Name
) a GROUP BY Name ORDER BY MAX(Quantity) DESC


--Find out which food item in least shopping carts

SELECT TOP 1 Name, MIN(Quantity) as NumberOfOrders
FROM
(
  SELECT FoodItems.Name,Sum(OrderFoods.Quantity) as Quantity FROM FoodItems INNER JOIN OrderFoods ON FoodItems.ID = OrderFoods.FoodID  
  GROUP BY OrderFoods.FoodID,FoodItems.Name
) a GROUP BY Name ORDER BY MIN(Quantity) ASC


--Find out all restaurant food items using SELECT query

SELECT * FROM FoodItems;

--Find out all restaurant order statuses using SELECT query

SELECT * FROM OrderFoods;

--Find out the order statuses that is created today

SELECT * FROM Orders WHERE Created = GETDATE();

--DELETE restaurant food items table

DELETE FROM foodItems

--Delete restaurant order statuses table

DELETE FROM Orders
DELETE FROM OrderFoods

--Delete restaurant cart table

DELETE FROM ShoppingCart

