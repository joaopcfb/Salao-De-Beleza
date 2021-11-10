/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.FuncionarioFuncao;

/**
 *
 * @author joaos
 */
public interface IFuncionarioFuncaoDAO {
    public void adiciona(FuncionarioFuncao funcionarioFuncao); 
    public List<FuncionarioFuncao> listarTodos();
}
