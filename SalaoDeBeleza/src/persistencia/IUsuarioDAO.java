/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Usuario;

/**
 *
 * @author joaos
 */
public interface IUsuarioDAO {
    public void adiciona(Usuario login);
    public boolean isLoginValido(Usuario login);
    public void visualiza(Usuario login);
    public List<Usuario> listarTodos();
}
