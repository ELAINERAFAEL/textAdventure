insert into historia (id,titulo) values (null,"La Patrona");

insert into fase (id_historia, id_fase, numero, descricao) values (1,null,1,"
YOLANDA GONZALEZ

Durante uma de suas rotinas habituais no tráfico, Yolanda Gonzalez recebe uma proposta para contrabandear uma carga, o que exige que ela deixe a Colômbia e vá para outro país.
Diante disso oferem a Yolanda:
");

insert into fase (id_historia, id_fase, numero, descricao) values (1,null,2,"
Ops, seu motor fundiu no caminho! Game Over
");

insert into fase (id_historia, id_fase, numero, descricao) values (1,null,3,"
A gasolina não foi o suficiente! Game over
");

insert into fase (id_historia, id_fase, numero, descricao) values (1,null,4,"
É hora de acelerar! continuar..
");

alter table opcoes add constraint foreign key (destino) references fase(id_fase);

insert into opcoes (id_opcoes,id_fase, opcao, destino) values (null,1,"MAREA", 2),(null,1,"MAVERICK",3),(null,1,"MONZA",4); 
 
