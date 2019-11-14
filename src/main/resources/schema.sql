CREATE TABLE IF NOT EXISTS Office (
  id                      INTEGER NOT NULL AUTO_INCREMENT             COMMENT 'Уникальный идентификатор',
  version                 INTEGER NOT NULL                            COMMENT 'Служебное поле hibernate',
  name                    VARCHAR(100)  NULL                       COMMENT 'Название',
  address                 VARCHAR(100)  NULL                       COMMENT 'Адрес',
  phone                   VARCHAR(45) NULL                            COMMENT 'Телефон',
  is_active               TINYINT NULL DEFAULT 1                      COMMENT 'Активен',

PRIMARY KEY (id)
) ;
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS User (
id               INTEGER NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
version          INTEGER NOT NULL             COMMENT 'Служебное поле hibernate' ,
first_name       VARCHAR(45)  NULL         COMMENT 'Имя',
last_name        VARCHAR(45)  NULL         COMMENT 'Фамилия',
middle_name      VARCHAR(45) NULL             COMMENT 'Отчество',
position         VARCHAR(45)  NULL         COMMENT 'Должность',
phone            VARCHAR(45) NULL             COMMENT 'Телефон',
is_identified    TINYINT     NULL DEFAULT 1   COMMENT 'Идентифицирован',
office_id        INTEGER     NULL             COMMENT 'Код офиса, внешний ключ',

PRIMARY KEY (id), FOREIGN KEY (office_id) REFERENCES Office(id)
);
COMMENT ON TABLE "USER" IS 'Пользователь';

CREATE TABLE IF NOT EXISTS Organization (
  id                            INTEGER NOT NULL AUTO_INCREMENT             COMMENT 'Уникальный идентификатор',
  version                       INTEGER NOT NULL                            COMMENT 'Служебное поле hibernate',
  name                          VARCHAR(45)  NULL                        COMMENT 'Название',
  full_name                     VARCHAR(100) NULL                       COMMENT 'Полное название',
  inn                           VARCHAR(45)  NULL                        COMMENT 'ИНН',
  kpp                           VARCHAR(45)  NULL                        COMMENT 'КПП',
  address                       VARCHAR(200) NULL                       COMMENT 'Адрес',
  phone                         VARCHAR(45) NULL                            COMMENT 'Телефон',
  is_active                     TINYINT NULL DEFAULT 1                      COMMENT 'Активен',

  PRIMARY KEY (id)
);

COMMENT ON TABLE Organization IS 'Компании';

CREATE TABLE IF NOT EXISTS Organization_Office (
  Organization_id    INTEGER NULL            COMMENT 'уникальный идентификатор организации',
  Office_id          INTEGER NULL            COMMENT 'уникальный идентификатор офиса',

  PRIMARY KEY (Organization_id,Office_id), FOREIGN KEY (Organization_id) REFERENCES Organization(id), FOREIGN KEY(Office_id) REFERENCES Office(id)
);

COMMENT ON TABLE Organization_Office IS 'join-таблица для связи организации и офиса';

CREATE TABLE IF NOT EXISTS Docs (
  code          INTEGER NOT NULL AUTO_INCREMENT                 COMMENT 'Уникальный идентификатор',
  version       INTEGER NOT NULL                               COMMENT 'Служебное поле hibernate',
  name          VARCHAR(45) NULL                               COMMENT 'Наименование документа',
  date          DATE NULL                                      COMMENT 'Дата создания документа',
PRIMARY KEY (code),FOREIGN KEY(code) REFERENCES "USER"(id)
);

COMMENT ON TABLE Docs IS 'Виды документов';

CREATE TABLE IF NOT EXISTS Countries (
  code          INTEGER NOT NULL AUTO_INCREMENT             COMMENT 'Уникальный идентификатор',
  version       INTEGER NOT NULL                            COMMENT 'Служебное поле hibernate',
  name          VARCHAR(45) NULL                            COMMENT 'Название государства',
CONSTRAINT cs_countries PRIMARY KEY (code),FOREIGN KEY(code) REFERENCES "USER"(id)
    );

COMMENT ON TABLE Countries IS 'Виды стран';

CREATE INDEX USER_OFFICE_ID_IDX ON "USER" (OFFICE_ID);