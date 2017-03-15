drop table voos;
create table voos
(
voo integer,
orixe varchar2(15),
destino varchar2(15),
prezo integer
);
insert into voos values (1,'vigo','estambul',150);
insert into voos values (2,'estambul','vigo',200);
insert into voos values (3,'vigo','londres',80);
insert into voos values (4,'londres','vigo',90);
insert into voos values (5,'vigo','lisboa',90);
insert into voos values (6,'lisboa','vigo',100);
insert into voos values (7,'vigo','viena',200);
insert into voos values (8,'viena','vigo',250);
insert into voos values (9,'vigo','tunez',160);
insert into voos values (10,'tunez','vigo',150);
insert into voos values (11,'vigo','paris',200);
insert into voos values (12,'paris','vigo',90);
commit;
