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
import negocio.Funcionario;

/**
 *
 * @author joaos
 */
public class FuncionarioDAO implements IFuncionarioDAO {
    private Connection connection;

    public FuncionarioDAO() {
        this.connection = new ConFactory().getConnection();
    }
    

    @Override
    public void adiciona(Funcionario funcionario) {
        String sql = "INSERT INTO FUNCIONARIO"
                + "(NOME, CPF, DATANASCIMENTO, COMISSAOPORCENTAGEMPADRAO,IDFUNCAO, IDUSUARIO)"
                + "VALUES (?,?,?,?,?,?)";
        try 
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCPF());
            stmt.setDate(3, new Date(funcionario.getDataNascimento().getTimeInMillis()));
            stmt.setInt(4, funcionario.getComissaoPorcentagemPadrao());
            stmt.setInt(5, funcionario.getIdFuncao());
            stmt.setObject(6, null);
            
            
            stmt.execute();
            stmt.close();
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }    
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
