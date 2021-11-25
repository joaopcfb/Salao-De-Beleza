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
import java.util.Calendar;
import java.util.List;
import negocio.Comissao;

/**
 *
 * @author joaos
 */
public class ComissaoDAO implements IComissaoDAO{
    private Connection connection;

    public ComissaoDAO()
    {
      this.connection = new ConFactory().getConnection();

    }
    
    @Override
    public void adiciona(Comissao comissao) {
        String sql = "INSERT INTO Comissao (IdFuncionario, IdAgendamento, DataCriacao, Valor, Calculado) VALUES (?,?,Now(),?,0)";
        try 
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, comissao.getIdFuncionario());
            ps.setInt(2, comissao.getIdAgendamento());
            ps.setFloat(3, comissao.getValor());
            ps.execute();
            ps.close();
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }
    }

    @Override
    public List<Comissao> listarComFiltro(Integer IdFuncionario) {
        String sql = "Select * from Comissao where calculado = 0 and Idfuncionario = " + IdFuncionario;
        List<Comissao> comissoes = new ArrayList<Comissao>() ;
        try 
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Calendar cal = Calendar.getInstance();
                cal.setTime(rs.getDate("DataCriacao"));
                comissoes.add(new Comissao(rs.getInt("Id"), rs.getInt("IdFuncionario"), rs.getInt("IdAgendamento"), cal, rs.getFloat("Valor")));
            }
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }
        return comissoes;
    }

    @Override
    public void SetCalcular(Integer idComissao) {
        
        String sql = "UPDATE Comissao set calculado = 1 where id = " +  idComissao;
        try 
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }
    }
    
}
