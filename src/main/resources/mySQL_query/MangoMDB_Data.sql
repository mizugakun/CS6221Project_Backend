
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

USE MangoMDB;

SET AUTOCOMMIT=0;
INSERT INTO User VALUE
    (1, 'account1', 'samkuo', 0),
    (2, 'account2', 'jaonwu', 0),
    (3, 'account3', 'zongyaoli', 0),
    (4, 'account4', 'yichenhao', 0);
COMMIT;

SET AUTOCOMMIT=0;
INSERT INTO Item VALUE
    (1, "Joe's O's Toasted Whole Grain Oats Cereal", NULL, NULL, 425, "g", 1.99),
    (2, "Chicken Fried Rice", NULL, NULL, 567, "g", 2.99),
    (3, "Honey O's Toasted Whole Grain Oats Cereal", NULL, NULL, 425, "g", 2.29),
    (4, "Apple Bag Honey Crisp", NULL, NULL, 2, "lb", 2.99),
    (5, "Black Forest Uncured Ham", NULL, NULL, 227, "g", 3.69),
    (6, "Whole Grain Fiber Bread", NULL, NULL, 680, "g", 2.99),
    (7, "Russet Potatos", NULL, NULL, 1.36, "kg", 2.99),
    (8, "Sauder's Eggs", NULL, NULL, 12, NULL, 1.69),
    (9, "Tomato Basil", NULL, NULL, 737, "g", 3.49),
    (10, "Joe's Whole Milk", NULL, NULL, 1, "l", 2.89),
    (11, "Sliced Part Skim Mozzarella Cheese", NULL, NULL, 340, "g", 3.69),
    (12, "Steamed Pork & Ginger Soup Dumplings", NULL, NULL, 6, NULL, 4.19);
COMMIT;

SET AUTOCOMMIT=0;
INSERT INTO OrderHistory VALUE
    (1, 1, '2021-03-10 13:03:42'),
    (2, 2, '2021-03-12 15:23:31'),
    (3, 3, '2021-03-13 19:44:03'),
    (4, 4, '2021-03-14 10:34:16'),
    (5, 1,'2021-03-17 13:03:42'),
    (6, 1,'2021-03-24 13:03:42'),
    (7, 1,'2021-03-31 13:03:42'),
    (8, 1,'2021-03-31 13:03:42'),
    (9, 1,'2021-04-07 13:03:42'),
    (10, 1, '2021-04-14 13:03:42');
COMMIT;

SET AUTOCOMMIT=0;
INSERT INTO OrderDetail VALUE
    (1, 1, 1),
    (1, 2, 2),
    (1, 4, 3),
    (1, 8, 1),
    (2, 6, 1),
    (2, 9, 1),
    (2, 11, 1),
    (3, 1, 1),
    (3, 3, 2),
    (3, 6, 1),
    (3, 9, 2),
    (4, 1, 1),
    (4, 2, 2),
    (4, 5, 2),
    (4, 7, 2),
    (4, 12, 1),
    (5, 1, 1),
    (6, 1, 1),
    (7, 1, 1),
    (8, 1, 1),
    (9, 1, 100),
    (10, 1, 1);
COMMIT;

SET AUTOCOMMIT=0;
INSERT INTO StorageDetail VALUE
    (1, 1, 1, 0.0, 2.0),
    (1, 2, 2, 0.0, 1.0),
    (1, 4, 3, 0.0, 3.0),
    (1, 8, 1, 0.0, 0.0),
    (2, 6, 1, 0.0, 0.0),
    (2, 9, 1, 0.0, 0.0),
    (2, 11, 1, 0.0, 0.0),
    (3, 1, 1, 0.0, 0.0),
    (3, 3, 2, 0.0, 0.0),
    (3, 6, 1, 0.0, 0.0),
    (3, 9, 2, 0.0, 0.0),
    (4, 1, 1, 0.0, 0.0),
    (4, 2, 2, 0.0, 0.0),
    (4, 5, 2, 0.0, 0.0),
    (4, 7, 2, 0.0, 0.0),
    (4, 12, 1, 0.0, 0.0);
COMMIT;