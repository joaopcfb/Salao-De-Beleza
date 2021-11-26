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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import negocio.Agendamento;
import negocio.AgendamentoHistorico;

/**
 *
 * @author joaos
 */
public class AgendamentoHistoricoDAO implements IAgendamentoHistoricoDAO{
    private Connection connection;

    public AgendamentoHistoricoDAO() {
        this.connection = new ConFactory().getConnection();
    }
    
    @Override
    public void adiciona(AgendamentoHistorico agendamentoHistorico) {
         String sql = "INSERT INTO AgendamentoHistorico (IdAgendamento, IdUsuario, Descricao, Data) VALUES (?,?,?, Now())";
        try 
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, agendamentoHistorico.getIdAgendamento());
            ps.setInt(2, agendamentoHistorico.getIdUsuario());
            ps.setString(3, agendamentoHistorico.getDescricao());
            ps.execute();
            ps.close();
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }
    }

    @Override
    public List<AgendamentoHistorico> listarComFiltro(Integer IdAtendimento) {
        String sql = "SELECT * FROM AGENDAMENTO where idAtendimento = ? order by DataInclusao";
        
        
        List<AgendamentoHistorico> agendamentoHistoricos = new ArrayList<AgendamentoHistorico>() ;
        
        try 
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, IdAtendimento);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
               
                Calendar cal = Calendar.getInstance();
                cal.setTime(rs.getDate("DataInclusao"));
                agendamentoHistoricos.add(new AgendamentoHistorico(rs.getInt("Id"), rs.getInt("IdAgendamento"), rs.getInt("IdUsuario"), rs.getString("Descricao"), cal));
                        
                       
            }
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }    
        return agendamentoHistoricos;

    }
    
}
