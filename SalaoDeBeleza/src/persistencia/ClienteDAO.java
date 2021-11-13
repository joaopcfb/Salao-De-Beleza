/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import negocio.Cliente;

/**
 *
 * @author joaos
 */
public class ClienteDAO implements IClienteDAO{
    private Connection connection;

    public ClienteDAO() {
        this.connection = new ConFactory().getConnection();
    }

    @Override
    public void adiciona(Cliente cliente) {
        String sql = "INSERT INTO CLIENTE (NOME, CPF, DATANASCIMENTO, TELEFONE) VALUES (?,?,?,?)";
        try 
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            
            ps.setString(2, cliente.getCPF());
            
            if (cliente.getDataNascimento() != null) {
                ps.setDate(3, new Date(cliente.getDataNascimento().getTimeInMillis()));
            }
            else
            {
                ps.setNull(3,(int)java.sql.Types.DATE);
            }
            
            ps.setString(4, cliente.getTelefone());
            ps.execute();
            ps.close();
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }
    }

    @Override
    public Cliente buscarPorID(Integer Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> listarComFiltro(Integer Id, String Nome, String CPF, Integer idFuncao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
