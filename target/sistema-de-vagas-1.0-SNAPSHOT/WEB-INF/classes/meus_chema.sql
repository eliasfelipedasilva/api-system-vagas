create table usuario (
cpf int not null primary key,
nome varchar(120),
email varchar(100),
senha varchar(8),
cargo_atual varchar(50),
area_atual varchar(50),
vaga_aplicada integer(8)
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

