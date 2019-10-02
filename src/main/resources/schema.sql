-- -----------------------------------------------------
-- Table `empty_project`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS User (
id               INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
version          INTEGER NOT NULL             COMMENT 'Служебное поле hibernate' ,
first_name       VARCHAR(45) NOT NULL         COMMENT 'Имя',
last_name        VARCHAR(45) NOT NULL         COMMENT 'Фамилия',
middle_name      VARCHAR(45) NULL             COMMENT 'Отчество',
position         VARCHAR(45) NOT NULL         COMMENT 'Должность',
phone            VARCHAR(45) NULL             COMMENT 'Телефон',
is_identified    TINYINT     NULL DEFAULT 1   COMMENT 'Идентифицирован'
  ) ;
COMMENT ON TABLE User IS 'Пользователь';

-- -----------------------------------------------------
-- Table `empty_project`.`Office`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Office (
  id                      INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
  version                 INTEGER NOT NULL                            COMMENT 'Служебное поле hibernate',
  name                    VARCHAR(100) NOT NULL                       COMMENT 'Название',
  address                 VARCHAR(100) NOT NULL                       COMMENT 'Адрес',
  phone                   VARCHAR(45) NULL                            COMMENT 'Телефон',
  is_active               TINYINT NULL DEFAULT 1                      COMMENT 'Активен',
  User_id                 INTEGER NOT NULL                            COMMENT 'Внешний ключ',

  CONSTRAINT fk_Office_User1
    FOREIGN KEY (User_id)
    REFERENCES User (id)
) ;
COMMENT ON TABLE Office IS 'Офис';

-- -----------------------------------------------------
-- Table `empty_project`.`Organization`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Organization (
  id                            INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
  version                       INTEGER NOT NULL                            COMMENT 'Служебное поле hibernate',
  name                          VARCHAR(45) NOT NULL                        COMMENT 'Название',
  full_name                     VARCHAR(100) NOT NULL                       COMMENT 'Полное название',
  inn                           VARCHAR(45) NOT NULL                        COMMENT 'ИНН',
  kpp                           VARCHAR(45) NOT NULL                        COMMENT 'КПП',
  address                       VARCHAR(200) NOT NULL                       COMMENT 'Адрес',
  phone                         VARCHAR(45) NULL                            COMMENT 'Телефон',
  is_active                     TINYINT NULL DEFAULT 1                      COMMENT 'Активен',
  Office_id                     INTEGER NOT NULL                            COMMENT 'Внешний ключ',

  CONSTRAINT fk_Organization_Office
    FOREIGN KEY (Office_id)
    REFERENCES Office (id)
    );
COMMENT ON TABLE Organization IS 'Компания';

-- -----------------------------------------------------
-- Table `empty_project`.`Docs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Docs (
  code          INTEGER PRIMARY KEY NOT NULL                   COMMENT 'Уникальный идентификатор',
  version       INTEGER NOT NULL                               COMMENT 'Служебное поле hibernate',
  name          VARCHAR(45) NULL                               COMMENT 'Наименование документа',
  date          DATE NULL                                      COMMENT 'Дата создания документа',
  User_id       INTEGER NOT NULL                               COMMENT 'Внешний ключ',

INDEX fk_Docs_User1_idx (User_id ASC),
CONSTRAINT fk_Docs_User1
FOREIGN KEY (User_id)
REFERENCES User (id)
    );
COMMENT ON TABLE Docs IS 'Виды документов';

-- -----------------------------------------------------
-- Table `empty_project`.`Countries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Countries (
  code           INTEGER PRIMARY KEY NOT NULL                COMMENT 'Уникальный идентификатор',
  version        INTEGER NOT NULL                            COMMENT 'Служебное поле hibernate',
  name           VARCHAR(45) NOT NULL                        COMMENT 'Название государства',
  User_id        INTEGER NOT NULL                            COMMENT 'Внешний ключ',

  INDEX fk_Countries_User1_idx (User_id ASC),
  CONSTRAINT fk_Countries_User1
  FOREIGN KEY (User_id)
  REFERENCES User (id)
    );
COMMENT ON TABLE Countries IS 'Виды стран';

CREATE TABLE IF NOT EXISTS Organization_Office (
  Organization_id    INTEGER PRIMARY KEY NOT NULL            COMMENT 'уникальный идентификатор организации',
  Office_id          INTEGER PRIMARY KEY NOT NULL            COMMENT 'уникальный идентификатор офиса'
);
COMMENT ON TABLE Organization_Office IS 'join-таблица для связи организации и офиса';

CREATE INDEX IX_Organization_Office_Id ON Organization_Office (Organization_id);
ALTER TABLE Organization_Office ADD FOREIGN KEY (Organization_id) REFERENCES Organization(id);

CREATE INDEX IX_Office_Organization_Id ON Organization_Office (Office_id);
ALTER TABLE Organization_Office ADD FOREIGN KEY (Office_id) REFERENCES Office(id);