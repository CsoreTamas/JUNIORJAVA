CREATE TABLE `shop_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item_name` varchar(20) NOT NULL DEFAULT 'UNKNOWN',
  `item_price` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `date_added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `shop_item_chk_1` CHECK ((`item_price` > 1)),
  CONSTRAINT `shop_item_chk_2` CHECK ((`quantity` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO shop_item (item_name, item_price, quantity) VALUES ("Banana", 34, 6);
INSERT INTO shop_item (item_name, item_price, quantity, date_added) VALUES ("Apple", 15, 3, 2013-30-21);

UPDATE shop_item SET item_name = "Watermelon XIXO TEA", item_price = 123, quantity = 32 WHERE id = 6;

SELECT COUNT(*) FROM shop_item;

SELECT COUNT(*) FROM shop_item WHERE quantity > 0;

SELECT SUM(quantity) FROM shop_item;

SELECT AVG(item_price) AS avg_price FROM shop_item;

SELECT SUM(item_price * quantity) / SUM(quantity) AS weighted_avg_price FROM shop_item WHERE item_price > 0 AND quantity > 0;

SELECT
(SELECT item_name FROM shop_item ORDER BY item_price DESC LIMIT 1) AS most_expensive,
(SELECT item_name FROM shop_item ORDER BY item_price LIMIT 1) AS cheapest;

SELECT item_name FROM shop_item ORDER BY date_added LIMIT 1;

SELECT item_name FROM shop_item ORDER BY date_added DESC LIMIT 1;


