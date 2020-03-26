create table usuario (
cpf int not null primary key,
nome varchar(120),
email varchar(100),
senha varchar(8),
cargo_atual varchar(50),
area_atual varchar(50)
);

create table vagas (
  id_vaga  int NOT NULL AUTO_INCREMENT,
  cargo_vaga varchar(50),
  descricao_vaga varchar(200),
  locacao_vaga varchar (20),
  tipo_vaga varchar (14),
  data_vencimento_vaga date,
  status_vaga varchar(15)
);

create table aplicadas (
    id integer primary key AUTO_INCREMENT,
    cpf_usuario integer references usuario (cpf),
    id_vaga integer references vagas (id_vaga),
    data_aplicacao varchar(15)
);