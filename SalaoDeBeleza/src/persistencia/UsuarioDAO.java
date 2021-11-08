/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import negocio.Usuario;

/**
 *
 * @author joaos
 */
public class UsuarioDAO implements IUsuarioDAO{
    private Connection connection;

    public UsuarioDAO() {
        this.connection = new ConFactory().getConnection();
    }
    @Override
    public void adiciona(Usuario login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visualiza(Usuario login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listarTodos() {
//        String sql = "SELECT * FROM USUARIOS";
//        try {
//        PreparedStatement stmt = connection.prepareStatement(sql);
//        return  stmt.f;
//        }
//        catch (SQLException ex){
//            System.err.println("Houve um erro..." + ex.getMessage());
//        }
//        
//        
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isLoginValido(Usuario login) {
        String sql = "SELECT * FROM USUARIO WHERE USUARIO = ? AND SENHA = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,login.getUsuario());
            stmt.setString(2,login.getSenha());
            ResultSet result = stmt.executeQuery();
            System.out.println(result);

            if (result.next()) {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException ex){
            System.err.println("Houve um erro..." + ex.getMessage());
        }
        return false;
    }
    
}
