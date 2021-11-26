/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Calendar;

/**
 *
 * @author joaos
 */
public class Funcionario {
    private Integer Id;
    private int IdFuncao;
    private Integer IdUsuario;
    private String Nome;
    private String CPF;
    private Calendar DataNascimento;
    private int ComissaoPorcentagemPadrao;
    Float ValorComissaoAPagar;

    

    public Funcionario(String Nome, String CPF, Calendar DataNascimento, int ComissaoPorcentagemPadrao, int IdFuncao, Integer IdUsuario) {
        this.Nome = Nome;
        this.CPF = CPF;
        this.DataNascimento = DataNascimento;
        this.ComissaoPorcentagemPadrao = ComissaoPorcentagemPadrao;
        this.IdFuncao = IdFuncao;
        this.IdUsuario = IdUsuario;
    }
    public Funcionario(Integer Id, String Nome, String CPF, int IdFuncao) {
        this.Id = Id;
        this.Nome = Nome;
        this.CPF = CPF;
        this.DataNascimento = DataNascimento;
        this.ComissaoPorcentagemPadrao = ComissaoPorcentagemPadrao;
        this.IdFuncao = IdFuncao;
        this.IdUsuario = IdUsuario;
    }
    
    public Funcionario(Integer Id, String Nome, String CPF, Calendar DataNascimento, int ComissaoPorcentagemPadrao, int IdFuncao, Float ValorComissaoAPagar) {
        this.Id = Id;
        this.Nome = Nome;
        this.CPF = CPF;
        this.DataNascimento = DataNascimento;
        this.ComissaoPorcentagemPadrao = ComissaoPorcentagemPadrao;
        this.IdFuncao = IdFuncao;
        this.IdUsuario = IdUsuario;
        this.ValorComissaoAPagar = ValorComissaoAPagar;
    }

    public Float getValorComissaoAPagar() {
        return ValorComissaoAPagar;
    }

    public void setValorComissaoAPagar(Float ValorComissaoAPagar) {
        this.ValorComissaoAPagar = ValorComissaoAPagar;
    }
    
    public Funcionario() {
         //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }
    


    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Calendar getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Calendar DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public int getComissaoPorcentagemPadrao() {
        return ComissaoPorcentagemPadrao;
    }

    public void setComissaoPorcentagemPadrao(int ComissaoPorcentagemPadrao) {
        this.ComissaoPorcentagemPadrao = ComissaoPorcentagemPadrao;
    }

    public int getIdFuncao() {
        return IdFuncao;
    }

    public void setIdFuncao(int IdFuncao) {
        this.IdFuncao = IdFuncao;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }
    
    @Override
    public String toString() {
        return Nome;
    }
    
    
}
