
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema hosp3
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hosp3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hosp3` DEFAULT CHARACTER SET utf8 ;
USE `hosp3` ;

-- -----------------------------------------------------
-- Table `hosp3`.`quarto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp3`.`quarto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `valor` FLOAT NULL,
  `quantidade_pessoas` INT NULL,
  `tipo` VARCHAR(45) NULL,
  `numero` VARCHAR(45) NULL,
  `disponivel` TINYINT(1) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hosp3`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp3`.`endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rua` VARCHAR(45) NULL,
  `numero` VARCHAR(3) NULL,
  `cep` VARCHAR(9) NULL,
  `bairro` VARCHAR(45) NULL,
  `pais` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `complemento` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hosp3`.`hospede`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp3`.`hospede` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(80) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `endereco_id` INT NULL,
  `telefone` VARCHAR(15) NULL,
  `palavra_passe` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_hospede_1_idx` (`endereco_id` ASC),
  CONSTRAINT `fk_hospede_1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `hosp3`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hosp3`.`consumo_extra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp3`.`consumo_extra` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NULL,
  `hospedagem_id` INT NULL,
  `valor` FLOAT NULL,
  PRIMARY KEY (`id`),
   INDEX `fk_consumo_extra_1_idx` (`hospedagem_id` ASC),
  CONSTRAINT `fk_consumo_extra_1`
    FOREIGN KEY (`hospedagem_id`)
    REFERENCES `hosp3`.`hospedagem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hosp3`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp3`.`funcionario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(80) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `endereco_id` INT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(15) NULL,
  `codigo` VARCHAR(10) NULL,
  `cargo` VARCHAR(45) NULL,
  `palavra_passe` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_funcionario_1_idx` (`endereco_id` ASC),
  CONSTRAINT `fk_funcionario_1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `hosp3`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hosp3`.`hospedagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp3`.`hospedagem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `hospede_id` INT NOT NULL,
  `quarto_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_table1_1_idx` (`hospede_id` ASC),
  INDEX `fk_table1_2_idx` (`quarto_id` ASC),
  CONSTRAINT `fk_table1_1`
    FOREIGN KEY (`hospede_id`)
    REFERENCES `hosp3`.`hospede` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_2`
    FOREIGN KEY (`quarto_id`)
    REFERENCES `hosp3`.`quarto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hosp3`.`registro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hosp3`.`registro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `flag_ativo` TINYINT(1) NULL,
  `pagamento` VARCHAR(45) NULL,
  `funcionario_id` INT NULL,
  `hospedagem_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_registro_4_idx` (`funcionario_id` ASC),
  INDEX `fk_registro_2_idx` (`hospedagem_id` ASC),
  CONSTRAINT `fk_registro_4`
    FOREIGN KEY (`funcionario_id`)
    REFERENCES `hosp3`.`funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_registro_2`
    FOREIGN KEY (`hospedagem_id`)
    REFERENCES `hosp3`.`hospedagem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
