SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

USE MangoMDB;

SET AUTOCOMMIT=0;

INSERT INTO User VALUES
    (1, 'Sam Kuo', 'account1', 'samkuo'),
    (2, 'Joan Wu', 'account2', 'jaonwu'),
    (3, 'Zongyao Li', 'account3', 'zongyaoli'),
    (4, 'Yichen Hao', 'account4', 'yichenhao'),
    (5, 'hahaha', 'hahaha', 'hahaha');
COMMIT;