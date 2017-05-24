INSERT INTO Users(username,password,role,enabled,clearanceLevel)VALUES
("Mitrius","$2a$08$NcpvZnhD/T1yWgMHy73KReixIeHfANd5iGKljKrISqEpHv2Jeovri","USER",1,0),
("Wicked","$2a$05$22Gj4dhx1Dr.PHRyY8lY7exN4gMOb6Mq9wLBAJY1lsMsaa3.wG29e","USER",1,2);

INSERT INTO Customers(name,surname)VALUES
("Ambroży","Kleks"),
("Gustaw","Kowalski"),
("Anna","Nowak"),
("Bogusław","Lindowski");

INSERT INTO Videos(title,price,status)VALUES
("Król Lew",9.99,"Dostępny"),
("Jak rozpętałem drugą wojnę światową",12.99,"Dostępny"),
("Seksmisja",12.99,"Wypożyczony"),
("Pianista",14.99,"Dostępny"),
("Chłopaki nie płaczą",10.99,"Wypożyczony");

INSERT INTO Employees(name,surname,position)VALUES
("Stefan","Matejko","Kierownik"),
("Władysława","Skrzynecka","Obsługa"),
("Wiesław","Dąbrowski","Obsługa");

INSERT INTO TableClassLevels(tableName,classLevel)VALUES
("Users",0),
("Customers",1),
("Videos",1),
("Employees",1),
("TableClassLevels",0),
("Rentals",1),
("ShopTransactions",1);

INSERT INTO ShopTransactions(employee,customer)VALUES
(3,2),
(2,1),
(2,3);

INSERT INTO Rentals(video,transaction,cost,tilldate,rentaldate)VALUES
(1,1,9.99,'2011-02-02','2011-01-02'),
(3,1,12.99,'2011-02-02','2011-01-02'),
(2,2,12.99,'2011-03-02','2011-04-02'),
(3,2,12.99,'2011-03-02','2011-04-02'),
(5,3,10.99,'2011-03-02','2011-04-02');



if retarded id use: ALTER TABLE tablename AUTO_INCREMENT = 1
