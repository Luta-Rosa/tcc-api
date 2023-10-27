CREATE TABLE cidade (
    id_cidade BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(140),
    UF VARCHAR(140)
);

CREATE TABLE mapa (
    id_mapa BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100),
    id_cidade BIGINT NOT NULL,
    FOREIGN KEY (id_cidade) REFERENCES cidade(id_cidade)
);

CREATE TABLE usuarios (
    id_usuarios BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100),
    senha VARCHAR(45),
    id_cidade BIGINT NOT NULL,
    FOREIGN KEY (id_cidade) REFERENCES cidade(id_cidade)
);

CREATE TABLE mensagemChat (
    id_msg BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    mensagem VARCHAR(140) NOT NULL
);

INSERT INTO cidade (nome, UF) VALUES ('LP', 'SP');
INSERT INTO mapa (descricao, id_cidade) VALUES ('hospital', 1);
INSERT INTO usuarios (nome, email, senha, id_cidade) VALUES ('Ana', 'ana@ana.com', 'ana', 1);
