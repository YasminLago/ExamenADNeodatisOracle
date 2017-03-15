drop table pasaxeiros;
create table pasaxeiros
(
dni varchar2(5),
nome varchar2(15),
telf varchar2(10),
cidade varchar2(10),
nreservas integer
);

   
insert into pasaxeiros values ('361a','luis','9861a','vigo',0);
insert into pasaxeiros values ('362b','ana','9861b','lugo',0);
insert into pasaxeiros values ('363c','pedro','9861c','lugo',0);
insert into pasaxeiros values ('364d','ana','9861d','vigo' ,0);

commit;
