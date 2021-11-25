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
public class AgendamentoHistorico {
    private Integer Id;
    private Integer IdAgendamento;
    private Integer IdUsuario;
    private String Descricao;
    private Calendar DataInclusao;

    public AgendamentoHistorico(Integer IdAgendamento, Integer IdUsuario, String Descricao, Calendar DataInclusao) {
        this.IdAgendamento = IdAgendamento;
        this.IdUsuario = IdUsuario;
        this.Descricao = Descricao;
        this.DataInclusao = DataInclusao;
    }

    public AgendamentoHistorico(Integer Id, Integer IdAgendamento, Integer IdUsuario, String Descricao, Calendar DataInclusao) {
        this.Id = Id;
        this.IdAgendamento = IdAgendamento;
        this.IdUsuario = IdUsuario;
        this.Descricao = Descricao;
        this.DataInclusao = DataInclusao;
    }

    public AgendamentoHistorico(Integer IdUsuario, String Descricao) {
        this.IdUsuario = IdUsuario;
        this.Descricao = Descricao;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getIdAgendamento() {
        return IdAgendamento;
    }

    public void setIdAgendamento(Integer IdAgendamento) {
        this.IdAgendamento = IdAgendamento;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Calendar getDataInclusao() {
        return DataInclusao;
    }

    public void setDataInclusao(Calendar DataInclusao) {
        this.DataInclusao = DataInclusao;
    }
    
    
    
}
