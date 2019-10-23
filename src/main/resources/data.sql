INSERT INTO Office values (1,1,'ОАО У черта на куличках','Москва,проспект Ленинский','(499)122-54-12',0);

INSERT INTO Office values (2,1,'Рога и копыта','Москва,ул. Сайкина','(495)666-66-66',1);

INSERT INTO Office values (3,1,'ООО Моя оборона','Москва, проспект Ленинский,101','(499)199-0539',0);

INSERT INTO Organization values (1, 1, 'Рога и копыта', 'ООО Рога и копыта', '7711118902', '771001001', 'Москва,ул. Сайкина', '(495)666-66-66', 1);

INSERT INTO Organization values (2, 1, 'У черта на куличках', 'ОАО У черта на куличках', '7756660112', '772001001', 'Москва,проспект Ленинский', '(499)122-54-12', 0);

INSERT INTO Organization values (3, 1, 'Моя оборона', 'ООО Моя оборона', '7743320110', '774001001', 'Москва, ул. Полярная', '(495)363-0000', 1);

INSERT INTO Organization_Office values  (1, 2);

INSERT INTO Organization_Office values  (2, 3);

INSERT INTO "USER" values(1,1,'Иванов','Иван','Иванович','Менеджер','(499)123-45-12',1,3);

INSERT INTO "USER" values(2,1,'Поляков','Владислав','Антонович','Руководитель','(495)666-66-66',1,3);

INSERT INTO "USER" values(3, 1, 'Васильев', 'Иван', 'Матвеевич', 'Свободный художник', '(495)748-2194', 1, 3);

INSERT INTO "USER" values(4, 1, 'Поехавший', 'Иван', 'Сергеевич', 'Менеджер по продажам', '(495)748-2198', 1, 3);

INSERT INTO Docs values(1,1,'Паспорт', '2016-08-17');

INSERT INTO Docs values(2,1,'Заграничный паспорт','2010-11-01');

INSERT INTO Docs values(3,1,'Паспорт', '2014-11-17');

INSERT INTO Docs values(4,1,'Паспорт', '2010-12-10');

INSERT INTO Countries values(1,1,'Российская Федерация');

INSERT INTO Countries values(2,1,'Республика Беларусь');

INSERT INTO Countries values(3,1,'Российская Федерация');

INSERT INTO Countries values(4,1,'Украина');