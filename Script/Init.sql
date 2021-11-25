/* Lógico_1: */
CREATE DATABASE IF NOT EXISTS salaodebeleza;
USE salaodebeleza;

/* Lógico_1: */

CREATE TABLE Usuario (
    Id int(11) PRIMARY KEY,
    Usuario VARCHAR (60),
    Senha VARCHAR (60),
    TipoUsuario Varchar(30)
);

CREATE TABLE Funcionario (
    Id int(11) PRIMARY KEY,
    IdFuncao int(11),
    IdUsuario int(11),
    Nome VARCHAR (60),
    CPF varchar(14),
    DataNascimento DATETIME,
    ComissaoPorcentagemPadrao int (3),
    DataInclusao DATETIME,
    ValorComissaoAPagar FLOAT
);

CREATE TABLE Agendamento (
    Id int(11) PRIMARY KEY,
    IdCliente int(11),
    IdFuncionario int(11),
    Descricao varchar(60),
    DataHora DATETIME,
    Valor float,
    Observacao text,
    PorcentagemComissao int(3),
    IndCancelado bit,
    IndFinalizado bit
);

CREATE TABLE Cliente (
    Id int(11) AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR (60),
    CPF varchar(14),
    DataNascimento DATETIME,
    Telefone varchar(15)
);

CREATE TABLE FuncionarioFuncao (
    Id int(11) PRIMARY KEY,
    Descricao VARCHAR (60)
);

CREATE TABLE AgendamentoHistorico (
    Id int(11) PRIMARY KEY,
    IdAgendamento int(11),
    IdUsuario int(11),
    Descricao VARCHAR (60),
    DataInclusao DATETIME
);

CREATE TABLE Comissao (
    Id int(11) PRIMARY KEY,
    IdFuncionario int(11),
    IdAgendamento int(11),
    DataCriacao DATETIME,
    Valor FLOAT,
    Calculado bit
);
 
ALTER TABLE Funcionario ADD CONSTRAINT FK_Funcionario_2
    FOREIGN KEY (IdFuncao)
    REFERENCES FuncionarioFuncao (Id);
 
ALTER TABLE Funcionario ADD CONSTRAINT FK_Funcionario_3
    FOREIGN KEY (IdUsuario)
    REFERENCES Usuario (Id);
 
ALTER TABLE Agendamento ADD CONSTRAINT FK_Agendamento_2
    FOREIGN KEY (IdCliente)
    REFERENCES Cliente (Id);
 
ALTER TABLE Agendamento ADD CONSTRAINT FK_Agendamento_3
    FOREIGN KEY (IdFuncionario)
    REFERENCES Funcionario (Id);
 
ALTER TABLE AgendamentoHistorico ADD CONSTRAINT FK_AgendamentoHistorico_2
    FOREIGN KEY (IdAgendamento)
    REFERENCES Agendamento (Id);
 
ALTER TABLE AgendamentoHistorico ADD CONSTRAINT FK_AgendamentoHistorico_3
    FOREIGN KEY (IdUsuario)
    REFERENCES Usuario (Id);
 
ALTER TABLE Comissao ADD CONSTRAINT FK_Comissao_2
    FOREIGN KEY (IdFuncionario)
    REFERENCES Funcionario (Id);
 
ALTER TABLE Comissao ADD CONSTRAINT FK_Comissao_3
    FOREIGN KEY (IdAgendamento)
    REFERENCES Agendamento (Id);
    
    
    insert into usuario (usuario, senha) values ("admin", "admin");