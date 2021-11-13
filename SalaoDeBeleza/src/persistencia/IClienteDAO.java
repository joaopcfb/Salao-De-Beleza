/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Cliente;

/**
 *
 * @author joaos
 */
public interface IClienteDAO {
    public void adiciona(Cliente cliente);
    public Cliente buscarPorID(Integer Id);
    public List<Cliente> listarComFiltro(Integer Id, String Nome, String CPF, Integer idFuncao);
}
