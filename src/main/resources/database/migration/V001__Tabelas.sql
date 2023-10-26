Create Table Cidade(
    idCidade int not null primary key auto_increment,
    nome varchar (140),
    UF varchar (140)
);

insert into cidade(nome, UF) values ("LP","SP");

Create Table Mapa (
    idMapa int not null primary key auto_increment,
    descricao varchar (100),
    cidade_id int,
    foreign key (cidade_id) references Cidade(idCidade)
);

insert into mapa(descricao, cidade_id) values ("hospital", 1);  -- 1 é o ID da cidade LP

Create Table Usuarios(
    idUsuarios int not null primary key auto_increment,
    nome varchar (100),
    email varchar (100),
    senha varchar (45),
    cidade_id int,
    foreign key (cidade_id) references Cidade(idCidade)
);

insert into usuarios(nome, email, senha, cidade_id) values ("Ana", "ana@ana.com", "ana", 1);  -- 1 é o ID da cidade LP
