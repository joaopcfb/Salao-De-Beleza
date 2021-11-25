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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import negocio.Agendamento;

/**
 *
 * @author joaos
 */
public class AgendamentoDAO implements IAgendamentoDAO{
    private Connection connection;

    public AgendamentoDAO() {
        this.connection = new ConFactory().getConnection();
    }
    
    @Override
    public void adiciona(Agendamento agendamento) {
        String sql = "INSERT INTO AGENDAMENTO (IdCliente, IdFuncionario, Descricao, Data, Hora, Valor, Observacao, PorcentagemComissao) VALUES (?,?,?,?,?,?,?,?)";
        try 
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, agendamento.getIdCliente());
            ps.setInt(2, agendamento.getIdFuncionario());
            ps.setString(3, agendamento.getDescricao());
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(agendamento.getData().getTime());
            ps.setString(4, timeStamp);
            ps.setString(5, agendamento.getHora());
            ps.setFloat(6, agendamento.getValor());
            ps.setString(7, agendamento.getObservacao());
            ps.setInt(8, agendamento.getPorcentagemComissao());
            ps.execute();
            ps.close();
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }
    }

    @Override
    public Agendamento buscarPorID(Integer Id) {
            String sql = "SELECT * FROM AGENDAMENTO WHERE ID = (?)";
            Agendamento agendamento = new Agendamento();
            try 
            {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, Id);
                ResultSet rs = ps.executeQuery();

                Calendar cal = Calendar.getInstance();
                if (rs != null && rs.next()){
                    
                    Date data = rs.getDate("Data");
                    cal.setTime(data);
                    agendamento = new Agendamento(rs.getInt("Id"), rs.getInt("IdCliente"), rs.getInt("IdFuncionario"), cal, rs.getString("Hora"), rs.getString("Descricao"), rs.getFloat("Valor"), rs.getString("Observacao"),  rs.getInt("PorcentagemComissao"), rs.getBoolean("IndCancelado"),rs.getBoolean("IndFinalizado"));    

                }
                
            }
            catch (SQLException ex) {    
                System.err.println("Houve um erro..." + ex.getMessage());
            }
            return agendamento;
    }

    @Override
    public List<Agendamento> listarComFiltro(Integer Id, Calendar DataHora, Integer IdFuncionario) {
       String sql = "SELECT * FROM AGENDAMENTO";
        
        boolean where = false;
        if (Id != null) {
            where = true;
            sql += " WHERE"; 
            sql += " Id = " + Id;
        }
        
        if (DataHora != null) {
            if (!where) {
                sql += " WHERE"; 
                where = true;
            }
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(DataHora.getTime());
            sql += " Data = '" + timeStamp +"'";
        }
        
        if (IdFuncionario != null) {
            if (!where) {
                sql += " WHERE"; 
            }else
            {
                sql += " AND";
            }
            sql += " idFuncionario = " + IdFuncionario ;
        }
        
        
        List<Agendamento> agendamentos = new ArrayList<Agendamento>() ;
        
        try 
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
               
                Calendar cal = Calendar.getInstance();
                cal.setTime(rs.getDate("Data"));
                agendamentos.add(new Agendamento(rs.getInt("Id"), rs.getInt("IdCliente"), rs.getInt("IdFuncionario"), cal, rs.getString("Hora"), rs.getString("Descricao"), rs.getFloat("Valor"), rs.getString("Observacao"),  rs.getInt("PorcentagemComissao"), rs.getBoolean("IndCancelado"),rs.getBoolean("IndFinalizado")));
                        
                       
            }
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }    
        return agendamentos;
    }

    @Override
    public void atualiza(Agendamento agendamento) {
        String sql = "UPDATE AGENDAMENTO set Data  = ?, Hora  = ?, IdCliente  = ?, IdFuncionario = ?, Descricao = ?, Valor = ?, Observacao = ?, PorcentagemComissao = ?, indFinalizado = ?   where id = ?";
         try 
        {
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(10, agendamento.getId());
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(agendamento.getData().getTime());
            ps.setString(1, timeStamp);
            ps.setString(2, agendamento.getHora());
            ps.setInt(3, agendamento.getIdCliente());
            ps.setInt(4, agendamento.getIdFuncionario());
            ps.setString(5, agendamento.getDescricao());
            ps.setFloat(6, agendamento.getValor());
            ps.setString(7, agendamento.getObservacao());
            ps.setInt(8, agendamento.getPorcentagemComissao());
            ps.setBoolean(9, agendamento.isIndFinalizado());
            ps.executeUpdate();

            
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }    
        
    }
    
}
