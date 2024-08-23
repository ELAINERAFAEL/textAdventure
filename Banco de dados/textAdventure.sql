create database textAdventure;

 create table historia (
  id int(11) not null auto_increment,
  titulo varchar(100) not null,
  primary key (id)
);

create table fase (
	id_historia int not null,
	id_fase int not null auto_increment,
	numero int not null,
	descricao varchar(600) not null,
	primary key (id_fase),
	foreign key (id_historia) references historia(id)
);

create table opcoes (
	id_opcoes int not null auto_increment,
	id_fase int not null,
	opcao varchar(350) not null,
	destino int not null,
	primary key (id_opcoes),
	foreign key (id_fase) references fase (id_fase)
);
