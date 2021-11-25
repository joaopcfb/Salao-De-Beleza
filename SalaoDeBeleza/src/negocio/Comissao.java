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
public class Comissao {
    private Integer Id;
    private Integer IdFuncionario;
    private Integer IdAgendamento;
    private Calendar DataCriacao;
    private Float Valor;
    private boolean Calculado;

    public Comissao(Integer IdFuncionario, Integer IdAgendamento, Float Valor) {
        this.IdFuncionario = IdFuncionario;
        this.IdAgendamento = IdAgendamento;
        this.Valor = Valor;
    }

    public Comissao(Integer Id, Integer IdFuncionario, Integer IdAgendamento, Calendar DataCriacao, Float Valor) {
        this.Id = Id;
        this.IdFuncionario = IdFuncionario;
        this.IdAgendamento = IdAgendamento;
        this.DataCriacao = DataCriacao;
        this.Valor = Valor;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getIdFuncionario() {
        return IdFuncionario;
    }

    public void setIdFuncionario(Integer IdFuncionario) {
        this.IdFuncionario = IdFuncionario;
    }

    public Integer getIdAgendamento() {
        return IdAgendamento;
    }

    public void setIdAgendamento(Integer IdAgendamento) {
        this.IdAgendamento = IdAgendamento;
    }

    public Calendar getDataCriacao() {
        return DataCriacao;
    }

    public void setDataCriacao(Calendar DataCriacao) {
        this.DataCriacao = DataCriacao;
    }

    public Float getValor() {
        return Valor;
    }

    public void setValor(Float Valor) {
        this.Valor = Valor;
    }

    public boolean isCalculado() {
        return Calculado;
    }

    public void setCalculado(boolean Calculado) {
        this.Calculado = Calculado;
    }
    
    
    
    
}
