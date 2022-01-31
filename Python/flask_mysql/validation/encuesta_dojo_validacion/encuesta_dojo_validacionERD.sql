-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema encuesta_dojo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema encuesta_dojo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `encuesta_dojo` DEFAULT CHARACTER SET utf8 ;
USE `encuesta_dojo` ;

-- -----------------------------------------------------
-- Table `encuesta_dojo`.`ninjas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `encuesta_dojo`.`ninjas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `dojo location` VARCHAR(45) NULL,
  `favorite language` VARCHAR(45) NULL,
  `comment` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
