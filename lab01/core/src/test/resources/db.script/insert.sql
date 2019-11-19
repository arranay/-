
insert into Grooup
    (groupName, creationDate, curatorName )
values
    ('PRI-117', '2017-08-27', 'Иванов В.Г.'),
    ('IST-117', '2017-08-27', 'Иванов В.Г.'),
    ('IB-119', '2019-08-29', 'Петров В.Г.')
;

insert into Student
    ( grooupID, lastName, firstName, birthDate,age)
values
    (1, 'Mihailov', 'Mihail', '1999-02-13', 20),
    (2, 'Pavlov', 'Pavel', '1999-04-03', 20),
	(1, 'Marieva', 'Mary', '1999-01-19', 20),
    (3, 'Nickolaev', 'Nick', '2000-03-09', 19),
	(3, 'Dmitriev', 'Dmitriy', '2000-12-09', 19),
	(2, 'Romanov', 'Roman', '1999-03-09', 20)
;
