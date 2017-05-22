CREATE TABLE `Customers` (
  `id`      INTEGER PRIMARY KEY AUTO_INCREMENT,
  `name`    NCHAR(255)
            COLLATE utf8_polish_ci NOT NULL,
  `surname` NCHAR(255)
            COLLATE utf8_polish_ci NOT NULL
)
  CHARACTER SET utf8
  COLLATE utf8_polish_ci;

CREATE TABLE `Employees` (
  `id`       INTEGER PRIMARY KEY AUTO_INCREMENT,
  `name`     NCHAR(255)
             COLLATE utf8_polish_ci NOT NULL,
  `surname`  NCHAR(255)
             COLLATE utf8_polish_ci NOT NULL,
  `position` NCHAR(255)
             COLLATE utf8_polish_ci
)
  CHARACTER SET utf8
  COLLATE utf8_polish_ci;

CREATE TABLE `TableClassLevels` (
  `tablename`  NCHAR(255)
               COLLATE utf8_polish_ci PRIMARY KEY,
  `classlevel` INTEGER NOT NULL
)
  CHARACTER SET utf8
  COLLATE utf8_polish_ci;

CREATE TABLE `Transactions` (
  `id`       INTEGER PRIMARY KEY AUTO_INCREMENT,
  `employee` INTEGER NOT NULL,
  `customer` INTEGER NOT NULL
)
  CHARACTER SET utf8
  COLLATE utf8_polish_ci;

CREATE INDEX `idx_transactions__customer`
  ON `Transactions` (`customer`);

CREATE INDEX `idx_transactions__employee`
  ON `Transactions` (`employee`);

ALTER TABLE `Transactions`
  ADD CONSTRAINT `fk_transactions__customer` FOREIGN KEY (`customer`) REFERENCES `Customers` (`id`);

ALTER TABLE `Transactions`
  ADD CONSTRAINT `fk_transactions__employee` FOREIGN KEY (`employee`) REFERENCES `Employees` (`id`);

CREATE TABLE `Users` (
  `username`       NCHAR(255)
                   COLLATE utf8_polish_ci PRIMARY KEY,
  `password`       NCHAR(255)
                   COLLATE utf8_polish_ci NOT NULL,
  `clearancelevel` INTEGER                NOT NULL,
  `role`           NCHAR(255)
                   COLLATE utf8_polish_ci NOT NULL,
  `enabled`        INTEGER                NOT NULL
)
  CHARACTER SET utf8
  COLLATE utf8_polish_ci;

CREATE TABLE `Videos` (
  `id`     INTEGER PRIMARY KEY AUTO_INCREMENT,
  `title`  NCHAR(255)
           COLLATE utf8_polish_ci NOT NULL,
  `price`  DECIMAL(12, 2)         NOT NULL,
  `status` NCHAR(255)
           COLLATE utf8_polish_ci NOT NULL
)
  CHARACTER SET utf8
  COLLATE utf8_polish_ci;

CREATE TABLE `Rentals` (
  `video`       INTEGER        NOT NULL,
  `transaction` INTEGER        NOT NULL,
  `cost`        DECIMAL(12, 2) NOT NULL,
  `tilldate`    DATE           NOT NULL,
  `rentaldate`  DATE           NOT NULL,
  `id`          INTEGER PRIMARY KEY AUTO_INCREMENT
)
  CHARACTER SET utf8
  COLLATE utf8_polish_ci;

CREATE INDEX `idx_rentals__transaction`
  ON `Rentals` (`transaction`);

CREATE INDEX `idx_rentals__video`
  ON `Rentals` (`video`);

ALTER TABLE `Rentals`
  ADD CONSTRAINT `fk_rentals__transaction` FOREIGN KEY (`transaction`) REFERENCES `Transactions` (`id`);

ALTER TABLE `Rentals`
  ADD CONSTRAINT `fk_rentals__video` FOREIGN KEY (`video`) REFERENCES `Videos` (`id`)