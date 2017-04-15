-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema nyte
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema nyte
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nyte` DEFAULT CHARACTER SET utf8 ;
USE `nyte` ;

-- -----------------------------------------------------
-- Table `nyte`.`tbl_povoado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nyte`.`tbl_povoado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nyte`.`tbl_especie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nyte`.`tbl_especie` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `especie` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nyte`.`tbl_personagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nyte`.`tbl_personagem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_povoado` INT NOT NULL,
  `altura` FLOAT NOT NULL,
  `peso` FLOAT NOT NULL,
  `idade` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `lvl` INT NOT NULL,
  `tbl_especie_id` INT NOT NULL,
  PRIMARY KEY (`id`, `id_povoado`, `tbl_especie_id`),
  INDEX `fk_tbl_personagem_tbl_povoado1_idx` (`id_povoado` ASC),
  INDEX `fk_tbl_personagem_tbl_especie1_idx` (`tbl_especie_id` ASC),
  CONSTRAINT `fk_tbl_personagem_tbl_povoado1`
    FOREIGN KEY (`id_povoado`)
    REFERENCES `nyte`.`tbl_povoado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_personagem_tbl_especie1`
    FOREIGN KEY (`tbl_especie_id`)
    REFERENCES `nyte`.`tbl_especie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nyte`.`tbl_adversidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nyte`.`tbl_adversidade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `hp` INT NOT NULL,
  `id_personagem` INT NOT NULL,
  PRIMARY KEY (`id`, `id_personagem`),
  INDEX `fk_tbl_adversidade_tbl_personagem1_idx` (`id_personagem` ASC),
  CONSTRAINT `fk_tbl_adversidade_tbl_personagem1`
    FOREIGN KEY (`id_personagem`)
    REFERENCES `nyte`.`tbl_personagem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'rouba: o que rouba quando ganha\nposses: o que dá quando morre';


-- -----------------------------------------------------
-- Table `nyte`.`tbl_dialogo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nyte`.`tbl_dialogo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `texto` VARCHAR(1000) NOT NULL,
  `id_dialogo_anterior` INT NULL,
  `id_proximo_dialogo` INT NULL,
  `id_adversidade` INT NOT NULL,
  PRIMARY KEY (`id`, `id_adversidade`),
  INDEX `fk_tbl_dialogo_tbl_adversidade1_idx` (`id_adversidade` ASC),
  CONSTRAINT `fk_tbl_dialogo_tbl_adversidade1`
    FOREIGN KEY (`id_adversidade`)
    REFERENCES `nyte`.`tbl_adversidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nyte`.`tbl_jogador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nyte`.`tbl_jogador` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_personagem` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `id_personagem`),
  INDEX `fk_tbl_jogador_tbl_personagem1_idx` (`id_personagem` ASC),
  CONSTRAINT `fk_tbl_jogador_tbl_personagem1`
    FOREIGN KEY (`id_personagem`)
    REFERENCES `nyte`.`tbl_personagem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nyte`.`tbl_save_game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nyte`.`tbl_save_game` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_dialogo_checkpoint` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `id_jogador` INT NOT NULL,
  PRIMARY KEY (`id`, `id_dialogo_checkpoint`, `id_jogador`),
  INDEX `fk_tbl_save_game_tbl_dialogo1_idx` (`id_dialogo_checkpoint` ASC),
  INDEX `fk_tbl_save_game_tbl_jogador1_idx` (`id_jogador` ASC),
  CONSTRAINT `fk_tbl_save_game_tbl_dialogo1`
    FOREIGN KEY (`id_dialogo_checkpoint`)
    REFERENCES `nyte`.`tbl_dialogo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_save_game_tbl_jogador1`
    FOREIGN KEY (`id_jogador`)
    REFERENCES `nyte`.`tbl_jogador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nyte`.`tbl_area_corpo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nyte`.`tbl_area_corpo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `area_corpo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'área do corpo onde o item será equipado';


-- -----------------------------------------------------
-- Table `nyte`.`tbl_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nyte`.`tbl_item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `equipado` TINYINT NOT NULL,
  `id_personagem` INT NOT NULL,
  `custo` FLOAT NOT NULL,
  `id_area_corpo` INT NOT NULL,
  PRIMARY KEY (`id`, `id_personagem`, `id_area_corpo`),
  INDEX `fk_tbl_item_tbl_personagem1_idx` (`id_personagem` ASC),
  INDEX `fk_tbl_item_tbl_area_corpo1_idx` (`id_area_corpo` ASC),
  CONSTRAINT `fk_tbl_item_tbl_personagem1`
    FOREIGN KEY (`id_personagem`)
    REFERENCES `nyte`.`tbl_personagem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_item_tbl_area_corpo1`
    FOREIGN KEY (`id_area_corpo`)
    REFERENCES `nyte`.`tbl_area_corpo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nyte`.`tbl_tipo_combate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nyte`.`tbl_tipo_combate` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nyte`.`tbl_atributo_combate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nyte`.`tbl_atributo_combate` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `atributo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nyte`.`tbl_combate_personagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nyte`.`tbl_combate_personagem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_tipo_combate` INT NOT NULL,
  `id_atributo_combate` INT NOT NULL,
  `valor` INT NOT NULL,
  `id_personagem` INT NOT NULL,
  PRIMARY KEY (`id`, `id_tipo_combate`, `id_atributo_combate`, `id_personagem`),
  INDEX `fk_tbl_combate_tbl_tipo_combate1_idx` (`id_tipo_combate` ASC),
  INDEX `fk_tbl_combate_tbl_atributo_combate1_idx` (`id_atributo_combate` ASC),
  INDEX `fk_tbl_combate_personagem_tbl_personagem1_idx` (`id_personagem` ASC),
  CONSTRAINT `fk_tbl_combate_tbl_tipo_combate1`
    FOREIGN KEY (`id_tipo_combate`)
    REFERENCES `nyte`.`tbl_tipo_combate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_combate_tbl_atributo_combate1`
    FOREIGN KEY (`id_atributo_combate`)
    REFERENCES `nyte`.`tbl_atributo_combate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_combate_personagem_tbl_personagem1`
    FOREIGN KEY (`id_personagem`)
    REFERENCES `nyte`.`tbl_personagem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nyte`.`tbl_atributo_especializacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nyte`.`tbl_atributo_especializacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `atributo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'atributos de especialização. agilidade, conhecimento, blefe...';


-- -----------------------------------------------------
-- Table `nyte`.`tbl_atributo_especializacao_combate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nyte`.`tbl_atributo_especializacao_combate` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_personagem` INT NOT NULL,
  `valor_melhoria` INT NOT NULL,
  `id_atributo_combate` INT NOT NULL,
  `id_atributo_especializacao` INT NOT NULL,
  PRIMARY KEY (`id`, `id_personagem`, `id_atributo_combate`, `id_atributo_especializacao`),
  INDEX `fk_tbl_atributos_especializacoes_tbl_personagem1_idx` (`id_personagem` ASC),
  INDEX `fk_tbl_atributos_especializacoes_tbl_combate_personagem1_idx` (`id_atributo_combate` ASC),
  INDEX `fk_tbl_atributos_especializacoes_tbl_atributo_especializaca_idx` (`id_atributo_especializacao` ASC),
  CONSTRAINT `fk_tbl_atributos_especializacoes_tbl_personagem1`
    FOREIGN KEY (`id_personagem`)
    REFERENCES `nyte`.`tbl_personagem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_atributos_especializacoes_tbl_combate_personagem1`
    FOREIGN KEY (`id_atributo_combate`)
    REFERENCES `nyte`.`tbl_combate_personagem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_atributos_especializacoes_tbl_atributo_especializacao1`
    FOREIGN KEY (`id_atributo_especializacao`)
    REFERENCES `nyte`.`tbl_atributo_especializacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'valor de increase/decrease que especializações/atributos dão ao valor de combate de acordo com o resultado do dado';


-- -----------------------------------------------------
-- Table `nyte`.`tbl_caracteristica_item_combate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nyte`.`tbl_caracteristica_item_combate` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_item` INT NOT NULL,
  `valor` INT NOT NULL,
  `id_atributo_combate` INT NOT NULL,
  PRIMARY KEY (`id`, `id_item`, `id_atributo_combate`),
  INDEX `fk_tbl_caracteristica_combate_tbl_item1_idx` (`id_item` ASC),
  INDEX `fk_tbl_caracteristica_combate_tbl_combate_personagem1_idx` (`id_atributo_combate` ASC),
  CONSTRAINT `fk_tbl_caracteristica_combate_tbl_item1`
    FOREIGN KEY (`id_item`)
    REFERENCES `nyte`.`tbl_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_caracteristica_combate_tbl_combate_personagem1`
    FOREIGN KEY (`id_atributo_combate`)
    REFERENCES `nyte`.`tbl_combate_personagem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'caracteristica de combate de tal item\nex.: ataque +5, defesa -2...\ncoluna valor é o increase/decrease do atributo de combate';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

