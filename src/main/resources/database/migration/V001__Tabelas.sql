Create Table Mapa (
    idMapa int not null primary key auto_increment,
    descricao varchar (100),
    cidade varchar (100)
);

Create Table Usuarios(
    idUsuarios int not null primary key auto_increment,
    nome varchar (100),
    email varchar (100),
    senha varchar (45),
    cidade varchar (100)
);

Create Table MensagemChat(
    idMsg int not null primary key auto_increment,
    mensagem varchar (140)
);