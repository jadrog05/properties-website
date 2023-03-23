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


