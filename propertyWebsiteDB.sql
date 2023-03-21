
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Bookings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Bookings` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Bookings` (
  `bookingsID` INT NOT NULL,
  `propertyID` INT NOT NULL,
  PRIMARY KEY (`bookingsID`, `propertyID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Properties`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Properties` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Properties` (
  `propertiesID` INT NOT NULL,
  `propertyLocation` VARCHAR(45) NULL,
  `propertyName` VARCHAR(45) NULL,
  `rating` VARCHAR(45) NULL,
  `ammenitiesID` INT NULL,
  `perNightPrice` VARCHAR(45) NULL,
  `propertyType` VARCHAR(45) NULL,
  PRIMARY KEY (`propertiesID`))
ENGINE = InnoDB;

INSERT INTO `Properties` (`propertiesID`, `propertyLocation`, `propertyName`, `rating`, `ammenitiesID`, `perNightPrice`, `propertyType`) VALUES
(1, 'New York City', 'Parkview Suites', '4.5 stars', 1, '250', 'hotel'),
(2, 'Los Angeles', 'Ocean View Villa', '5 stars', 2, '500', 'house'),
(3, 'Miami', 'Beachside Condo', '4 stars', 3, '150', 'apartment'),
(4, 'Chicago', 'The Windy City Hostel', '3.5 stars', 4, '50', 'hostel'),
(5, 'Paris', 'Eiffel Tower View Apartment', '4.5 stars', 5, '300', 'apartment'),
(6, 'London', 'Covent Garden Hotel', '4 stars', 6, '200', 'hotel'),
(7, 'Tokyo', 'Shinjuku Loft', '4 stars', 7, '150', 'apartment'),
(8, 'Sydney', 'Harbour View House', '5 stars', 8, '750', 'house'),
(9, 'Barcelona', 'Gothic Quarter Apartment', '4 stars', 9, '100', 'apartment'),
(10, 'Rome', 'Vatican View Suite', '5 stars', 10, '400', 'hotel');



-- -----------------------------------------------------
-- Table `mydb`.`BookingInfo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`BookingInfo` ;

CREATE TABLE IF NOT EXISTS `mydb`.`BookingInfo` (
  `bookingID` INT NOT NULL,
  `numberOfGuests` INT NULL,
  `startDate` DATE NULL,
  `endDate` DATE NULL,
  `totalCost` DOUBLE NULL,
  `guestID` INT NOT NULL,
  PRIMARY KEY (`bookingID`),
  UNIQUE INDEX `guestID_UNIQUE` (`guestID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Guests`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Guests` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Guests` (
  `guestID` INT NOT NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `postcode` VARCHAR(45) NULL,
  `phoneNumber` VARCHAR(45) NULL,
  `accountID` INT NOT NULL,
  PRIMARY KEY (`guestID`),
  UNIQUE INDEX `accountID_UNIQUE` (`accountID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Accounts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Accounts` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Accounts` (
  `accountID` INT NOT NULL,
  `email` VARCHAR(45) NULL,
  `passsword` VARCHAR(45) NULL,
  PRIMARY KEY (`accountID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Ammenities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Ammenities` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Ammenities` (
  `ammenitiesID` INT NOT NULL,
  `tv` VARCHAR(45) NULL,
  `hotTub` VARCHAR(45) NULL,
  `oven` VARCHAR(45) NULL,
  `microwave` VARCHAR(45) NULL,
  `fridge` VARCHAR(45) NULL,
  `swimmingPool` VARCHAR(45) NULL,
  PRIMARY KEY (`ammenitiesID`))
ENGINE = InnoDB;


