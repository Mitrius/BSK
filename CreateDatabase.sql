CREATE TABLE `Customers` (
  `id`          INTEGER PRIMARY KEY AUTO_INCREMENT,
  `name`        VARCHAR(255) NOT NULL,
  `surname`     VARCHAR(255) NOT NULL,
  `objectclass` INTEGER      NOT NULL
);

CREATE TABLE `Employees` (
  `id`                 INTEGER PRIMARY KEY AUTO_INCREMENT,
  `userclearancelevel` INTEGER      NOT NULL,
  `objectclass`        INTEGER      NOT NULL,
  `name`               VARCHAR(255) NOT NULL,
  `surname`            VARCHAR(255) NOT NULL,
  `position`           VARCHAR(255) NOT NULL
);

CREATE TABLE `AccessLevelChanges` (
  `id`          INTEGER PRIMARY KEY AUTO_INCREMENT,
  `employee`    INTEGER NOT NULL,
  `objectclass` INTEGER NOT NULL
);

CREATE INDEX `idx_accesslevelchanges__employee`
  ON `AccessLevelChanges` (`employee`);

ALTER TABLE `AccessLevelChanges`
  ADD CONSTRAINT `fk_accesslevelchanges__employee` FOREIGN KEY (`employee`) REFERENCES `Employees` (`id`);

CREATE TABLE `Transactions` (
  `id`          INTEGER PRIMARY KEY AUTO_INCREMENT,
  `objectclass` INTEGER NOT NULL,
  `employee`    INTEGER NOT NULL,
  `customer`    INTEGER NOT NULL
);

CREATE INDEX `idx_transactions__customer`
  ON `Transactions` (`customer`);

CREATE INDEX `idx_transactions__employee`
  ON `Transactions` (`employee`);

ALTER TABLE `Transactions`
  ADD CONSTRAINT `fk_transactions__customer` FOREIGN KEY (`customer`) REFERENCES `Customers` (`id`);

ALTER TABLE `Transactions`
  ADD CONSTRAINT `fk_transactions__employee` FOREIGN KEY (`employee`) REFERENCES `Employees` (`id`);

CREATE TABLE `Videos` (
  `id`          INTEGER PRIMARY KEY AUTO_INCREMENT,
  `title`       VARCHAR(255)   NOT NULL,
  `price`       DECIMAL(12, 2) NOT NULL,
  `objectclass` INTEGER        NOT NULL,
  `status`      VARCHAR(255)   NOT NULL
);

CREATE TABLE `Rentals` (
  `video`       INTEGER        NOT NULL,
  `transaction` INTEGER        NOT NULL,
  `cost`        DECIMAL(12, 2) NOT NULL,
  `tilldate`    DATE           NOT NULL,
  `date`        DATE           NOT NULL,
  `objectclass` INTEGER        NOT NULL,
  `id`          VARCHAR(255) PRIMARY KEY
);

CREATE INDEX `idx_rentals__transaction`
  ON `Rentals` (`transaction`);

CREATE INDEX `idx_rentals__video`
  ON `Rentals` (`video`);

ALTER TABLE `Rentals`
  ADD CONSTRAINT `fk_rentals__transaction` FOREIGN KEY (`transaction`) REFERENCES `Transactions` (`id`);

ALTER TABLE `Rentals`
  ADD CONSTRAINT `fk_rentals__video` FOREIGN KEY (`video`) REFERENCES `Videos` (`id`)
