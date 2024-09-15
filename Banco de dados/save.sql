create table save(
id_save int not null auto_increment, 
id_fase int not null,
jogador varchar (100),
primary key (id_save), 
foreign key (id_fase) references fase (id_fase)
);

