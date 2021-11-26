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
public class Cliente {
    private Integer Id;
    private String Nome;
    private String CPF;
    private Calendar DataNascimento;
    private String Telefone;

    public Cliente(String Nome, String CPF, Calendar DataNascimento, String Telefone) {
        this.Nome = Nome;
        this.CPF = CPF;
        this.DataNascimento = DataNascimento;
        this.Telefone = Telefone;
    }

    public Cliente(Integer Id, String Nome, String CPF, String Telefone) {
        this.Id = Id;
        this.Nome = Nome;
        this.CPF = CPF;
        this.Telefone = Telefone;
    }

    public Cliente(Integer Id, String Nome, String CPF, Calendar DataNascimento, String Telefone) {
        this.Id = Id;
        this.Nome = Nome;
        this.CPF = CPF;
        this.DataNascimento = DataNascimento;
        this.Telefone = Telefone;
    }

    public Cliente() {
        
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setDataNascimento(Calendar DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public Integer getId() {
        return Id;
    }

    public String getNome() {
        return Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public Calendar getDataNascimento() {
        return DataNascimento;
    }

    public String getTelefone() {
        return Telefone;
    }

    @Override
    public String toString() {
        return Nome;
    }
   
    
}
