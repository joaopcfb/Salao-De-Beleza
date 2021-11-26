/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.AgendamentoHistorico;

/**
 *
 * @author joaos
 */
public interface IAgendamentoHistoricoDAO {
    public void adiciona(AgendamentoHistorico agendamentoHistorico);
    public List<AgendamentoHistorico> listarComFiltro(Integer IdAtendimento);
}
