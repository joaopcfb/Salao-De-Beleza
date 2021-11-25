/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Calendar;
import java.util.List;
import negocio.Agendamento;

/**
 *
 * @author joaos
 */
public interface IAgendamentoDAO {
    public void adiciona(Agendamento agendamento);
    public Agendamento buscarPorID(Integer Id);
    public void atualiza(Agendamento agendamento);
    public List<Agendamento> listarComFiltro(Integer Id, Calendar DataHora, Integer IdFuncionario);
}
