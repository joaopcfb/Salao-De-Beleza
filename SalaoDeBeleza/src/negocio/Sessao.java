/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author joaos
 */
public class Sessao {
    private static Integer IdUsuario;
    
    private Sessao() {}

    public static Integer getIdUsuario() {
        return IdUsuario;
    }

    public static void setIdUsuario(Integer IdUsuario) {
        Sessao.IdUsuario = IdUsuario;
    }

    
    
}
