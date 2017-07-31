CREATE TABLE `mydatabase`.`fooditems` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(300) NOT NULL,
  `Description` VARCHAR(1000) NOT NULL,
  `ImgURL` VARCHAR(500) NOT NULL,
  `Price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
  
  
ALTER TABLE FoodItems AUTO_INCREMENT=1;
  
  
INSERT INTO FoodItems (Name,Description,ImgURL,Price) VALUES
('Chipotle','A Hamburger','https://blogs.hopkins-interactive.com/2019/files/Chipotle_Barbacoa_Bowl_2x.jpg', 9.99),
('Hamburger','Americal Food','http://www.in-n-out.com/images/menu_v2/cheeseburger_meal.png', 4.99),
('Pizza','Delicious Pizza','https://s-media-cache-ak0.pinimg.com/originals/22/52/a9/2252a9064d6aa07990f9c8b8c5644b61.jpg', 12.99);

select * from foodItems