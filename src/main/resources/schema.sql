CREATE TABLE IF NOT EXISTS User (
id               INTEGER NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
version          INTEGER NOT NULL             COMMENT 'Служебное поле hibernate' ,
first_name       VARCHAR(45) NOT NULL         COMMENT 'Имя',
last_name        VARCHAR(45) NOT NULL         COMMENT 'Фамилия',
middle_name      VARCHAR(45) NULL             COMMENT 'Отчество',
position         VARCHAR(45) NOT NULL         COMMENT 'Должность',
phone            VARCHAR(45) NULL             COMMENT 'Телефон',
is_identified    TINYINT     NULL DEFAULT 1   COMMENT 'Идентифицирован',

PRIMARY KEY (id)
);
COMMENT ON TABLE "USER" IS 'Пользователь';

CREATE TABLE IF NOT EXISTS Office (
  id                      INTEGER NOT NULL AUTO_INCREMENT             COMMENT 'Уникальный идентификатор',
  version                 INTEGER NOT NULL                            COMMENT 'Служебное поле hibernate',
  name                    VARCHAR(100) NOT NULL                       COMMENT 'Название',
  address                 VARCHAR(100) NOT NULL                       COMMENT 'Адрес',
  phone                   VARCHAR(45) NULL                            COMMENT 'Телефон',
  is_active               TINYINT NULL DEFAULT 1                      COMMENT 'Активен',
  User_id                 INTEGER NOT NULL                            COMMENT 'Внешний ключ',

CONSTRAINT Office_PK PRIMARY KEY (id)
) ;
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS Organization (
  id                            INTEGER NOT NULL AUTO_INCREMENT             COMMENT 'Уникальный идентификатор',
  version                       INTEGER NOT NULL                            COMMENT 'Служебное поле hibernate',
  name                          VARCHAR(45) NOT NULL                        COMMENT 'Название',
  full_name                     VARCHAR(100) NOT NULL                       COMMENT 'Полное название',
  inn                           VARCHAR(45) NOT NULL                        COMMENT 'ИНН',
  kpp                           VARCHAR(45) NOT NULL                        COMMENT 'КПП',
  address                       VARCHAR(200) NOT NULL                       COMMENT 'Адрес',
  phone                         VARCHAR(45) NULL                            COMMENT 'Телефон',
  is_active                     TINYINT NULL DEFAULT 1                      COMMENT 'Активен',
  Office_id                     INTEGER NOT NULL                            COMMENT 'Внешний ключ',

  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Countries (
  code           INTEGER NOT NULL                            COMMENT 'Уникальный идентификатор',
  version        INTEGER NOT NULL                            COMMENT 'Служебное поле hibernate',
  name           VARCHAR(45) NOT NULL                        COMMENT 'Название государства',
  User_id        INTEGER NOT NULL                            COMMENT 'Внешний ключ',

  CONSTRAINT Countries_PK PRIMARY KEY (code)
    );
COMMENT ON TABLE Countries IS 'Виды стран';

CREATE TABLE IF NOT EXISTS Docs (
  code          INTEGER NOT NULL                               COMMENT 'Уникальный идентификатор',
  version       INTEGER NOT NULL                               COMMENT 'Служебное поле hibernate',
  name          VARCHAR(45) NULL                               COMMENT 'Наименование документа',
  date          DATE NULL                                      COMMENT 'Дата создания документа',
  User_id       INTEGER NOT NULL                               COMMENT 'Внешний ключ',

CONSTRAINT Docs_PK PRIMARY KEY (code)
);
COMMENT ON TABLE Docs IS 'Виды документов';

CREATE TABLE IF NOT EXISTS Organization_Office (
  Organization_id    INTEGER NOT NULL            COMMENT 'уникальный идентификатор организации',
  Office_id          INTEGER NOT NULL            COMMENT 'уникальный идентификатор офиса',

  PRIMARY KEY (Organization_id,Office_id)
);

COMMENT ON TABLE Organization_Office IS 'join-таблица для связи организации и офиса';

CREATE INDEX IX_Organization_Office_Id ON Organization_Office (Organization_id);
ALTER TABLE Organization_Office ADD FOREIGN KEY (Organization_id) REFERENCES Organization(id);

CREATE INDEX IX_Office_Organization_Id ON Organization_Office (Office_id);
ALTER TABLE Organization_Office ADD FOREIGN KEY (Office_id) REFERENCES Office(id);

ALTER TABLE Office ADD CONSTRAINT fk_Office_User1 FOREIGN KEY (User_id) REFERENCES "USER" (id);

ALTER TABLE Organization ADD CONSTRAINT fk_Organization_Office FOREIGN KEY (Office_id) REFERENCES Office (id);

CREATE INDEX fk_Docs_User1_idx ON docs (User_id);

ALTER TABLE Docs ADD CONSTRAINT fk_Docs_User1 FOREIGN KEY (User_id) REFERENCES "USER" (id);

CREATE INDEX fk_Countries_User1_idx ON countries (User_id);

ALTER TABLE Countries ADD CONSTRAINT fk_Countries_User1 FOREIGN KEY (User_id)
  REFERENCES "USER" (id);