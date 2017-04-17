CREATE TABLE `Customers` (
  `id`      INTEGER PRIMARY KEY AUTO_INCREMENT,
  `name`    VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL
);

CREATE TABLE `Employees` (
  `id`       INTEGER PRIMARY KEY AUTO_INCREMENT,
  `name`     VARCHAR(255) NOT NULL,
  `surname`  VARCHAR(255) NOT NULL,
  `position` VARCHAR(255) NOT NULL
);

CREATE TABLE `TableClassLevels` (
  `tablename`  VARCHAR(255) PRIMARY KEY,
  `classlevel` INTEGER NOT NULL
);

CREATE TABLE `ShopTransactions` (
  `id`       INTEGER PRIMARY KEY AUTO_INCREMENT,
  `employee` INTEGER NOT NULL,
  `customer` INTEGER NOT NULL
);

CREATE INDEX `idx_transactions__customer`
  ON `ShopTransactions` (`customer`);

CREATE INDEX `idx_transactions__employee`
  ON `ShopTransactions` (`employee`);

ALTER TABLE `ShopTransactions`
  ADD CONSTRAINT `fk_transactions__customer` FOREIGN KEY (`customer`) REFERENCES `Customers` (`id`);

ALTER TABLE `ShopTransactions`
  ADD CONSTRAINT `fk_transactions__employee` FOREIGN KEY (`employee`) REFERENCES `Employees` (`id`);

CREATE TABLE `Users` (
  `username`       VARCHAR(255) PRIMARY KEY,
  `password`       VARCHAR(255) NOT NULL,
  `clearancelevel` INTEGER      NOT NULL,
  `role`           VARCHAR(255) NOT NULL,
  `enabled`        INTEGER      NOT NULL
);

CREATE TABLE `Videos` (
  `id`     INTEGER PRIMARY KEY AUTO_INCREMENT,
  `title`  VARCHAR(255)   NOT NULL,
  `price`  DECIMAL(12, 2) NOT NULL,
  `status` VARCHAR(255)   NOT NULL
);

CREATE TABLE `Rentals` (
  `video`       INTEGER        NOT NULL,
  `transaction` INTEGER        NOT NULL,
  `cost`        DECIMAL(12, 2) NOT NULL,
  `tilldate`    DATE           NOT NULL,
  `rentaldate`  DATE           NOT NULL,
  `id`          INTEGER PRIMARY KEY AUTO_INCREMENT
);

CREATE INDEX `idx_rentals__transaction`
  ON `Rentals` (`transaction`);

CREATE INDEX `idx_rentals__video`
  ON `Rentals` (`video`);

ALTER TABLE `Rentals`
  ADD CONSTRAINT `fk_rentals__transaction` FOREIGN KEY (`transaction`) REFERENCES `ShopTransactions` (`id`);

ALTER TABLE `Rentals`
  ADD CONSTRAINT `fk_rentals__video` FOREIGN KEY (`video`) REFERENCES `Videos` (`id`)