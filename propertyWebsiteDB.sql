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
('Barcelona', 'Modernist Apartment', 4, 4.5, 1, 200.00, 'apartment'),
('Paris', 'Champs-Élysées Studio', 2, 3.5, 2, 150.00, 'apartment'),
('Rome', 'Trastevere Townhouse', 6, 4, 1, 400.00, 'house'),
('Berlin', 'Brandenburg Gate Apartment', 3, 4, 1, 250.00, 'apartment'),
('Amsterdam', 'Canal View House', 8, 4.5, 1, 600.00, 'house'),
('Vienna', 'Belvedere Palace Suite', 2, 5, 2, 300.00, 'hotel'),
('Florence', 'Duomo View Apartment', 4, 4, 1, 225.00, 'apartment'),
('Dublin', 'Temple Bar Loft', 2, 4, 2, 175.00, 'apartment'),
('Athens', 'Acropolis View Hotel', 2, 4.5, 1, 175.00, 'hotel'),
('Madrid', 'Gran Vía Apartment', 4, 4, 2, 200.00, 'apartment'),
('Venice', 'Canal-Side Penthouse', 2, 4, 1, 300.00, 'apartment'),
('Paris', 'Montmartre Studio', 2, 3, 2, 100.00, 'apartment'),
('Barcelona', 'Gothic Quarter Penthouse', 4, 4, 1, 350.00, 'apartment'),
('Rome', 'Villa Borghese House', 6, 4.5, 1, 500.00, 'house'),
('Berlin', 'Kreuzberg Loft', 2, 4, 2, 125.00, 'apartment'),
('Amsterdam', 'Jordaan Apartment', 3, 4, 1, 175.00, 'apartment'),
('Vienna', 'Schönbrunn Palace Suite', 2, 5, 2, 350.00, 'hotel'),
('Florence', 'Oltrarno Studio', 2, 3.5, 1, 125.00, 'apartment'),
('Dublin', 'Georgian Townhouse', 6, 4.5, 1, 400.00, 'house'),
('Athens', 'Plaka Guesthouse', 2, 4, 1, 150.00, 'hotel'),
('Madrid', 'Retiro Park Apartment', 3, 4.5, 1, 250.00, 'apartment'),
('Barcelona', 'Eixample Apartment', 4, 4, 1, 150, 'apartment'),
('Rome', 'Trastevere Studio', 2, 3.5, 2, 80, 'apartment'),
('Amsterdam', 'Canal View House', 6, 4, 1, 300, 'house'),
('London', 'South Bank Hotel', 2, 4.5, 2, 220, 'hotel'),
('Berlin', 'Prenzlauer Berg Loft', 2, 4, 1, 120, 'apartment'),
('Vienna', 'City Center Apartment', 3, 4.5, 1, 180, 'apartment'),
('Paris', 'Montmartre View Apartment', 4, 4, 2, 250, 'apartment'),
('Barcelona', 'Sagrada Familia Hotel', 2, 3, 1, 90, 'hotel'),
('Florence', 'Duomo View Apartment', 3, 4.5, 2, 220, 'apartment'),
('Rome', 'Colosseum View Hotel', 2, 5, 1, 300, 'hotel'),
('Vienna', 'Belvedere Garden Apartment', 2, 4, 1, 110, 'apartment'),
('Madrid', 'Retiro Park Apartment', 6, 3.5, 2, 160, 'apartment'),
('Budapest', 'Danube River View Apartment', 4, 4, 1, 200, 'apartment'),
('Paris', 'Latin Quarter Hotel', 2, 3.5, 1, 130, 'hotel'),
('Barcelona', 'Gothic Quarter House', 6, 4, 2, 350, 'house'),
('London', 'Hyde Park View Apartment', 4, 4.5, 2, 280, 'apartment'),
('Vienna', 'Stephansplatz Hotel', 2, 4, 1, 180, 'hotel'),
('Rome', 'Navona Square Apartment', 2, 4, 2, 150, 'apartment'),
('Amsterdam', 'Jordaan Houseboat', 2, 4.5, 1, 200, 'house'),
('Paris', 'Marais Apartment', 4, 4, 1, 220, 'apartment'),
('Berlin', 'Friedrichshain Loft', 2, 3.5, 2, 100, 'apartment'),
('Barcelona', 'Barceloneta Beach House', 6, 5, 1, 400, 'house'),
('Budapest', 'Castle District Apartment', 2, 4, 2, 100, 'apartment'),
('Rome', 'Villa Borghese View Hotel', 4, 4.5, 1, 300, 'hotel'),
('Paris', 'Champs-Élysées Apartment', 2, 4, 2, 200, 'apartment'),
('Barcelona', 'Modernist Apartment', 4, 4.5, 2, 180, 'apartment'),
('Rome', 'Trevi Fountain Suite', 3, 5, 1, 350, 'hotel'),
('Berlin', 'Brandenburg Gate Apartment', 6, 4, 2, 220, 'apartment'),
('Barcelona', 'Gaudi House', 5, 4.5, 2, 320, 'house'),
('Amsterdam', 'Canal View Loft', 2, 4, 1, 150, 'apartment'),
('Vienna', 'Imperial Palace Suite', 3, 5, 1, 400, 'hotel'),
('Venice', 'Grand Canal Apartment', 4, 4, 2, 300, 'apartment'),
('Dublin', 'Temple Bar Studio', 2, 3.5, 1, 120, 'apartment'),
('Lisbon', 'Alfama House', 6, 4, 2, 180, 'house'),
('Paris', 'Montmartre View Apartment', 2, 4, 1, 250, 'apartment'),
('Paris', 'Champs-Elysees Apartment', 4, 4.5, 2, 350, 'apartment'),
('Madrid', 'Puerta del Sol Studio', 2, 4, 1, 100, 'apartment'),
('Barcelona', 'Casa Batllo Penthouse', 6, 5, 2, 500, 'apartment'),
('Budapest', 'Danube View Apartment', 4, 4, 1, 200, 'apartment'),
('Rome', 'Colosseum Suite', 3, 4.5, 1, 300, 'hotel'),
('Vienna', 'Schonbrunn Palace Apartment', 2, 3.5, 1, 180, 'apartment'),
('Amsterdam', 'Red Light District Loft', 2, 3, 1, 120, 'apartment'),
('Barcelona', 'La Sagrada Familia Villa', 8, 5, 2, 700, 'house'),
('Dublin', 'Georgian House', 6, 4, 2, 250, 'house'),
('Berlin', 'Kreuzberg Loft', 2, 4, 1, 150, 'apartment'),
('Paris', 'Eiffel Tower Suite', 2, 5, 1, 500, 'hotel'),
('Venice', 'Rialto Bridge Apartment', 4, 4, 2, 280, 'apartment'),
('Rome', 'Villa Borghese House', 6, 4.5, 2, 450, 'house'),
('Lisbon', 'Bairro Alto Apartment', 3, 4, 1, 120, 'apartment'),
('Madrid', 'Retiro Park Villa', 10, 5, 2, 1200, 'house'),
('Barcelona', 'Gothic Quarter Loft', 2, 4, 1, 100, 'apartment'),
('Vienna', 'Belvedere Palace Suite', 3, 4.5, 1, 280, 'hotel'),
('Budapest', 'Buda Castle Apartment', 5, 4, 2, 320, 'apartment'),
('Amsterdam', 'Jordaan Houseboat', 2, 4, 2, 200, 'house'),
('Paris', 'Opera Garnier Apartment', 6, 4.5, 1, 400, 'apartment');




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


