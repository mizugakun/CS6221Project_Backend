
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

USE MangoMDB;

SET AUTOCOMMIT=0;
INSERT INTO User VALUE
    (1, 'account1', 'samkuo'),
    (2, 'account2', 'jaonwu'),
    (3, 'account3', 'zongyaoli'),
    (4, 'account4', 'yichenhao');
COMMIT;

SET AUTOCOMMIT=0;
INSERT INTO Item VALUE
    (1, "Joe's O's Toasted Whole Grain Oats Cereal", NULL, NULL, 425, "g", 1.99),
    (2, "Chicken Fried Rice", NULL, NULL, 567, "g", 2.99),
    (3, "Honey O's Toasted Whole Grain Oats Cereal", NULL, NULL, 425, "g", 2.29),
    (4, "Apple Bag Honey Crisp", NULL, NULL, 2, "lb", 2.99),
    (5, "Black Forest Uncured Ham", NULL, NULL, 227, "g", 3.69),
    (6, "100% Whole Grain Fiber Bread", NULL, NULL, 680, "g", 2.99),
    (7, "Russet Potatos", NULL, NULL, 1.36, "kg", 2.99),
    (8, "Sauder's Eggs", NULL, NULL, 12, NULL, 1.69),
    (9, "Tomato Basil", NULL, NULL, 737, "g", 3.49),
    (10, "Joe's Whole Milk", NULL, NULL, 1, "l", 2.89),
    (11, "Sliced Part Skim Mozzarella Cheese", NULL, NULL, 340, "g", 3.69),
    (12, "Steamed Pork & Ginger Soup Dumplings", NULL, NULL, 6, NULL, 4.19);
COMMIT;

SET AUTOCOMMIT=0;
INSERT INTO OrderHistory VALUE
    (1, 1, '2020-03-10 13:03:42'),
    (2, 2, '2020-03-12 15:23:31'),
    (3, 3, '2020-03-13 19:44:03'),
    (4, 4, '2020-03-14 10:34:16');
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
    (4, 12, 1);
COMMIT;

SET AUTOCOMMIT=0;
INSERT INTO StorageDetail VALUE
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
    (4, 12, 1);
COMMIT;