-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Ammenities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Ammenities` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Ammenities` (
  `ammenitiesID` INT NOT NULL AUTO_INCREMENT,
  `tv` TINYINT NULL,
  `hotTub` TINYINT NULL,
  `oven` TINYINT NULL,
  `microwave` TINYINT NULL,
  `fridge` TINYINT NULL,
  `swimmingPool` TINYINT NULL,
  PRIMARY KEY (`ammenitiesID`),
  UNIQUE INDEX `ammenitiesID_UNIQUE` (`ammenitiesID` ASC) VISIBLE)
ENGINE = InnoDB;


INSERT INTO Ammenities(tv,microwave) VALUES (1,1);
INSERT INTO Ammenities(hotTub,oven) VALUES (1,1);


-- -----------------------------------------------------
-- Table `mydb`.`Properties`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Properties` ;


CREATE TABLE IF NOT EXISTS `mydb`.`Properties` (
  `propertiesID` INT NOT NULL AUTO_INCREMENT,
  `propertyLocation` VARCHAR(45) NULL,
  `propertyName` VARCHAR(45) NULL,
  `capacity` INT NULL,
  `rating` DOUBLE NULL,
  `ammenitiesID` INT NOT NULL,
  `perNightPrice` DOUBLE NULL,
  `propertyType` VARCHAR(45) NULL,
  PRIMARY KEY (`propertiesID`),
  INDEX `fk_ammenities_idx` (`ammenitiesID` ASC) VISIBLE,
  CONSTRAINT `fk_ammenities`
    FOREIGN KEY (`ammenitiesID`)
    REFERENCES `mydb`.`Ammenities` (`ammenitiesID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `Properties` (`propertyLocation`, `propertyName`, `capacity`, `rating`, `ammenitiesID`, `perNightPrice`, `propertyType`) VALUES
('New York City', 'Parkview Suites', 4, 4.5, 1, 250.00, 'hotel'),
('Los Angeles', 'Ocean View Villa', 4, 5, 2, 500.00, 'house'),
('Miami', 'Beachside Condo', '2', 4, 2, 150, 'apartment'),
('Chicago', 'The Windy City Hostel', 8, 3.5, 1, 50, 'hostel'),
('Paris', 'Eiffel Tower View Apartment', 6, 4.5, 2, 300, 'apartment'),
('London', 'Covent Garden Hotel', 2, 4, 1, 200, 'hotel'),
('Tokyo', 'Shinjuku Loft', 2, 4, 2, 150, 'apartment'),
('Sydney', 'Harbour View House', 6, 5, 1, 750, 'house'),
('Barcelona', 'Gothic Quarter Apartment', 3, 4, 1, 100, 'apartment'),
('Rome', 'Vatican View Suite', 3, 5, 1, 400, 'hotel'),
('Paris', 'Belle Vue Apartments', 2, 3, 1, 299.99, 'apartment'),
('Paris', 'Le Jardin Hotel', 4, 4, 2, 259.99, 'hotel');



-- -----------------------------------------------------
-- Table `mydb`.`Guests`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Guests` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Guests` (
  `guestID` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `postcode` VARCHAR(45) NULL,
  `phoneNumber` VARCHAR(45) NULL,
  PRIMARY KEY (`guestID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Bookings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Bookings` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Bookings` (
  `bookingID` INT NOT NULL AUTO_INCREMENT,
  `numberOfGuests` INT NULL,
  `startDate` DATE NULL,
  `endDate` DATE NULL,
  `totalCost` DOUBLE NULL,
  `guestID` INT NOT NULL,
  `propertiesID` INT NOT NULL,
  PRIMARY KEY (`bookingID`),
  INDEX `fk_properties_idx` (`propertiesID` ASC) VISIBLE,
  UNIQUE INDEX `bookingID_UNIQUE` (`bookingID` ASC) VISIBLE,
  CONSTRAINT `fk_properties`
    FOREIGN KEY (`propertiesID`)
    REFERENCES `mydb`.`Properties` (`propertiesID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_guests`
    FOREIGN KEY (`guestID`)
    REFERENCES `mydb`.`Guests` (`guestID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


