/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.FuncionarioFuncao;

/**
 *
 * @author joaos
 */
public class FuncionarioFuncaoDAO implements IFuncionarioFuncaoDAO {
    private Connection connection;

    public FuncionarioFuncaoDAO() {
        this.connection = new ConFactory().getConnection();
    }
    
    @Override
    public List<FuncionarioFuncao> listarTodos() {
        String sql = "SELECT * FROM FUNCIONARIOFUNCAO";
        List<FuncionarioFuncao> funcionarioFuncoes = new ArrayList<FuncionarioFuncao>() ;
        try 
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                funcionarioFuncoes.add(new FuncionarioFuncao(rs.getInt("ID"), rs.getString("DESCRICAO")));
            }
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }    
        return funcionarioFuncoes;
    
    }

    @Override
    public void adiciona(FuncionarioFuncao funcionarioFuncao) {
        String sql = "INSERT INTO FUNCIONARIOFUNCAO (DESCRICAO) VALUES (?)";
        try 
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, funcionarioFuncao.getDescricao());
            ps.execute();
            ps.close();
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }    
        
    }

    @Override
    public FuncionarioFuncao buscarPorID(Integer Id) {
        String sql = "SELECT * FROM FUNCIONARIOFUNCAO"
                + " WHERE id = (?)";
        FuncionarioFuncao funcionarioFuncao = new FuncionarioFuncao() ;
        try 
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                funcionarioFuncao = new FuncionarioFuncao(rs.getInt("ID"), rs.getString("DESCRICAO"));
            }
            
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }    
        return funcionarioFuncao;
    }
    
    
}
