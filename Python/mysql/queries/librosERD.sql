-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema libros
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema libros
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `libros` DEFAULT CHARACTER SET utf8 ;
USE `libros` ;

-- -----------------------------------------------------
-- Table `libros`.`authors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libros`.`authors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `libros`.`books`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libros`.`books` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `num_of_pages` INT NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `libros`.`favorites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libros`.`favorites` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `author_id` INT NOT NULL,
  `book_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_favorites_authors_idx` (`author_id` ASC) VISIBLE,
  INDEX `fk_favorites_books1_idx` (`book_id` ASC) VISIBLE,
  CONSTRAINT `fk_favorites_authors`
    FOREIGN KEY (`author_id`)
    REFERENCES `libros`.`authors` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_favorites_books1`
    FOREIGN KEY (`book_id`)
    REFERENCES `libros`.`books` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
