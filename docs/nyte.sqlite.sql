-- -----------------------------------------------------
-- Table `tbl_povoado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tbl_povoado` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `nome` VARCHAR(45) NOT NULL);


-- -----------------------------------------------------
-- Table `tbl_especie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tbl_especie` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `especie` VARCHAR(45) NOT NULL)
;


-- -----------------------------------------------------
-- Table `tbl_personagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tbl_personagem` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `id_povoado` INTEGER NOT NULL,
  `altura` FLOAT NOT NULL,
  `peso` FLOAT NOT NULL,
  `idade` INTEGER NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `lvl` INTEGER NOT NULL,
  `tbl_especie_id` INTEGER NOT NULL)
;


-- -----------------------------------------------------
-- Table `tbl_adversidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tbl_adversidade` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `hp` INTEGER NOT NULL,
  `id_personagem` INTEGER NOT NULL);


-- -----------------------------------------------------
-- Table `tbl_dialogo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tbl_dialogo` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `texto` VARCHAR(1000) NOT NULL,
  `id_dialogo_anterior` INTEGER NULL,
  `id_proximo_dialogo` INTEGER NULL,
  `id_adversidade` INTEGER NOT NULL)
;


-- -----------------------------------------------------
-- Table `tbl_jogador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tbl_jogador` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `id_personagem` INTEGER NOT NULL,
  `nome` VARCHAR(45) NOT NULL)
;


-- -----------------------------------------------------
-- Table `tbl_save_game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tbl_save_game` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `id_dialogo_checkpoINTEGER` INTEGER NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `id_jogador` INTEGER NOT NULL)
;


-- -----------------------------------------------------
-- Table `tbl_area_corpo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tbl_area_corpo` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `area_corpo` VARCHAR(45) NOT NULL);


-- -----------------------------------------------------
-- Table `tbl_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tbl_item` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `valor` VARCHAR(45) NOT NULL,
  `id_area_corpo` INTEGER NOT NULL)
;


-- -----------------------------------------------------
-- Table `tbl_item_personagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tbl_item_personagem` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `equipado` INTEGER NOT NULL,
  `id_personagem` INTEGER NOT NULL,
  `id_item` INTEGER NOT NULL,
  `arma_reserva` INTEGER NOT NULL)
;


-- -----------------------------------------------------
-- Table `tbl_atributo_combate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tbl_atributo_combate` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `atributo` VARCHAR(45) NOT NULL)
;


-- -----------------------------------------------------
-- Table `tbl_combate_personagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tbl_combate_personagem` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `id_atributo_combate` INTEGER NOT NULL,
  `valor` INTEGER NOT NULL,
  `id_personagem` INTEGER NOT NULL)
;


-- -----------------------------------------------------
-- Table `tbl_atributo_especializacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tbl_atributo_especializacao` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `atributo` VARCHAR(45) NOT NULL);


-- -----------------------------------------------------
-- Table `tbl_atributo_especializacao_combate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tbl_atributo_especializacao_combate` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `id_personagem` INTEGER NOT NULL,
  `valor_melhoria` INTEGER NOT NULL,
  `id_atributo_combate` INTEGER NOT NULL,
  `id_atributo_especializacao` INTEGER NOT NULL);


-- -----------------------------------------------------
-- Table `tbl_caracteristica_item_combate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tbl_caracteristica_item_combate` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `valor` INTEGER NOT NULL,
  `id_atributo_combate` INTEGER NOT NULL,
  `id_item` INTEGER NOT NULL);


