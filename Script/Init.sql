/* Lógico_1: */
CREATE DATABASE IF NOT EXISTS salaodebeleza;
USE salaodebeleza;

CREATE TABLE IF NOT EXISTS Usuario (
    Id int(11) PRIMARY KEY auto_increment,
    Usuario VARCHAR (60),
    Senha VARCHAR (60)
);

CREATE TABLE IF NOT EXISTS Funcionario (
    Id int(11) PRIMARY KEY auto_increment,
    IdFuncao int(11),
    IdUsuario int(11),
    Nome VARCHAR (60),
    CPF varchar(14),
    DataNascimento DATETIME,
    ComissaoPorcentagemPadrao int (3),
    Campo VARCHAR (15)
);

CREATE TABLE IF NOT EXISTS Agendamentos (
    Id int(11) PRIMARY KEY auto_increment,
    IdCliente int(11),
    IdStatus int(11),
    DataHora DATETIME
);

CREATE TABLE IF NOT EXISTS Cliente (
    Id int(11) AUTO_INCREMENT PRIMARY KEY UNIQUE,
    Nome VARCHAR (60),
    CPF varchar(14),
    DataNascimento DATETIME,
    Telefone varchar(15)
);

CREATE TABLE IF NOT EXISTS Servico (
    Id int(11) PRIMARY KEY auto_increment,
    Descricao VARCHAR (60),
    PrecoPadrao FLOAT,
    TempoPrevistoPadrao Float
);

CREATE TABLE IF NOT EXISTS FuncionarioFuncao (
    Id int(11) PRIMARY KEY auto_increment,
    Descricao VARCHAR (60)
);

CREATE TABLE IF NOT EXISTS Status (
    Id int(11) PRIMARY KEY auto_increment,
    Descricao VARCHAR (60)
);

CREATE TABLE IF NOT EXISTS AgendamentoHistorico (
    Id int(11) PRIMARY KEY auto_increment,
    IdAgendamento int(11),
    IdUsuario int(11),
    Descricao VARCHAR (60)
);

CREATE TABLE IF NOT EXISTS AgendamentoServico (
    Id int(11) PRIMARY KEY auto_increment,
    IdAgendamento int(11),
    IdFuncionario int(11),
    IdServico int(11),
    PorcentagemComissao int (3),
    Valor Float,
    TempoPrevisto FLOAT
);

CREATE TABLE IF NOT EXISTS Comissao (
    Id int(11) PRIMARY KEY auto_increment,
    IdFuncionario int(11),
    IdLoteComissao int(11),
    IdAgendamentoServico int(11),
    DataCriacao DATETIME,
    Valor FLOAT
);

CREATE TABLE IF NOT EXISTS LoteComissao (
    Id int(11) PRIMARY KEY auto_increment,
    IdFuncionario int(11),
    IdStatus int(11),
    DataCorte DATETIME,
    ValorLote FLOAT
);

CREATE TABLE IF NOT EXISTS LoteStatus (
    Id int(11) PRIMARY KEY auto_increment,
    Descricao VARCHAR (60)
);
 
ALTER TABLE Funcionario ADD  CONSTRAINT FK_Funcionario_2 
    FOREIGN KEY (IdFuncao)
    REFERENCES FuncionarioFuncao (Id);
 
ALTER TABLE Funcionario ADD CONSTRAINT FK_Funcionario_3
    FOREIGN KEY (IdUsuario)
    REFERENCES Usuario (Id);
 
ALTER TABLE Agendamentos ADD CONSTRAINT FK_Agendamentos_2
    FOREIGN KEY (IdStatus)
    REFERENCES Status (Id);
 
ALTER TABLE Agendamentos ADD CONSTRAINT FK_Agendamentos_3
    FOREIGN KEY (IdCliente)
    REFERENCES Cliente (Id);
 
ALTER TABLE AgendamentoHistorico ADD CONSTRAINT FK_AgendamentoHistorico_2
    FOREIGN KEY (IdAgendamento)
    REFERENCES Agendamentos (Id);
 
ALTER TABLE AgendamentoHistorico ADD CONSTRAINT FK_AgendamentoHistorico_3
    FOREIGN KEY (IdUsuario)
    REFERENCES Usuario (Id);
 
ALTER TABLE AgendamentoServico ADD CONSTRAINT FK_AgendamentoServico_2
    FOREIGN KEY (IdAgendamento)
    REFERENCES Agendamentos (Id);
 
ALTER TABLE AgendamentoServico ADD CONSTRAINT FK_AgendamentoServico_3
    FOREIGN KEY (IdFuncionario)
    REFERENCES Funcionario (Id);
 
ALTER TABLE AgendamentoServico ADD CONSTRAINT FK_AgendamentoServico_4
    FOREIGN KEY (IdServico)
    REFERENCES Servico (Id);
 
ALTER TABLE Comissao ADD CONSTRAINT FK_Comissao_2
    FOREIGN KEY (IdFuncionario)
    REFERENCES Funcionario (Id);
 
ALTER TABLE Comissao ADD CONSTRAINT FK_Comissao_3
    FOREIGN KEY (IdLoteComissao)
    REFERENCES LoteComissao (Id);
 
ALTER TABLE Comissao ADD CONSTRAINT FK_Comissao_4
    FOREIGN KEY (IdAgendamentoServico)
    REFERENCES AgendamentoServico (Id);
 
ALTER TABLE LoteComissao ADD CONSTRAINT FK_LoteComissao_2
    FOREIGN KEY (IdStatus)
    REFERENCES LoteStatus (Id);
 
ALTER TABLE LoteComissao ADD CONSTRAINT FK_LoteComissao_3
    FOREIGN KEY (IdFuncionario)
    REFERENCES Funcionario (Id);