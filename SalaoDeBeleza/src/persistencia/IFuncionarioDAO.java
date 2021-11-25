/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Funcionario;

/**
 *
 * @author joaos
 */
public interface IFuncionarioDAO {
    public void adiciona(Funcionario funcionario);
    public Funcionario buscarPorID(Integer Id);
    public void atualizaValorAPagar(Float valor, Integer id);
    public List<Funcionario> listarComFiltro(Integer Id, String Nome, String CPF, Integer idFuncao);
}
