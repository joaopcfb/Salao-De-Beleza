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
public class Agendamento {
    private Integer Id;
    private Integer IdCliente;
    private Integer IdFuncionario;
    private Calendar Data;
    private String Hora;
    private String Descricao;
    private float Valor;
    private String Observacao;
    private int PorcentagemComissao;
    private boolean IndCancelado;
    private boolean IndFinalizado;

    public Agendamento(Integer Id, Integer IdCliente, Calendar DataHora, boolean IndCancelado, boolean IndFinalizado) {
        this.Id = Id;
        this.IdCliente = IdCliente;
        this.Data = DataHora;
        this.IndCancelado = IndCancelado;
        this.IndFinalizado = IndFinalizado;
    }

    public Agendamento(Integer Id, Integer IdCliente, Calendar Data, String Hora, String Descricao) {
        this.Id = Id;
        this.IdCliente = IdCliente;
        this.Data = Data;
        this.Hora = Hora;
        this.Descricao = Descricao;
    }

    public Agendamento(Integer IdCliente, Integer IdFuncionario, Calendar Data, String Hora, String Descricao, float Valor, String Observacao, int PorcentagemComissao) {
        this.IdCliente = IdCliente;
        this.IdFuncionario = IdFuncionario;
        this.Data = Data;
        this.Hora = Hora;
        this.Descricao = Descricao;
        this.Valor = Valor;
        this.Observacao = Observacao;
        this.PorcentagemComissao = PorcentagemComissao;
    }

    public Agendamento(Integer Id, Integer IdCliente, Integer IdFuncionario, Calendar Data, String Hora, String Descricao, float Valor, String Observacao, int PorcentagemComissao, boolean IndCancelado, boolean IndFinalizado) {
        this.Id = Id;
        this.IdCliente = IdCliente;
        this.IdFuncionario = IdFuncionario;
        this.Data = Data;
        this.Hora = Hora;
        this.Descricao = Descricao;
        this.Valor = Valor;
        this.Observacao = Observacao;
        this.PorcentagemComissao = PorcentagemComissao;
        this.IndCancelado = IndCancelado;
        this.IndFinalizado = IndFinalizado;
    }

    public Agendamento() {

    }

    public Agendamento(int Id, Integer IdCliente, Integer IdFuncionario, Calendar Data, String Horario, String Descricao, float Valor, String Observacao, int PorcentagemComissao) {
        this.Id = Id;
        this.IdCliente = IdCliente;
        this.Data = Data;
        this.IdFuncionario = IdFuncionario;
        this.Hora = Horario;
        this.Descricao = Descricao;
        this.Valor = Valor;
        this.Observacao = Observacao;
        this.PorcentagemComissao = PorcentagemComissao;
    }

    public Calendar getData() {
        return Data;
    }

    public void setData(Calendar Data) {
        this.Data = Data;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public boolean isIndCancelado() {
        return IndCancelado;
    }

    public void setIndCancelado(boolean IndCancelado) {
        this.IndCancelado = IndCancelado;
    }

    public boolean isIndFinalizado() {
        return IndFinalizado;
    }

    public void setIndFinalizado(boolean IndFinalizado) {
        this.IndFinalizado = IndFinalizado;
    }

    public Integer getIdFuncionario() {
        return IdFuncionario;
    }

    public void setIdFuncionario(Integer IdFuncionario) {
        this.IdFuncionario = IdFuncionario;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    public int getPorcentagemComissao() {
        return PorcentagemComissao;
    }

    public void setPorcentagemComissao(int PorcentagemComissao) {
        this.PorcentagemComissao = PorcentagemComissao;
    }

    

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Integer IdCliente) {
        this.IdCliente = IdCliente;
    }

    
    
}
