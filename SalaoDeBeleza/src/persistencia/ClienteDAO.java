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
        String sql = "SELECT * FROM Cliente"
                + " WHERE id = (?)";
        Cliente cliente = new Cliente() ;
        try 
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                cliente = new Cliente((Integer) rs.getInt("ID"), rs.getString("Nome"),  rs.getString("CPF"), toCalendar(rs.getDate("DataNascimento")), rs.getString("Telefone"));
            }
            
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }    
        return cliente;         
    }

    @Override
    public List<Cliente> listarComFiltro(Integer Id, String Nome, String CPF, String Telefone) {
        String sql = "SELECT * FROM Cliente";
        
        boolean where = false;
        if (Id != null) {
            where = true;
            sql += " WHERE"; 
            sql += " Id = " + Id;
        }
        
        if (Nome != null) {
            if (!where) {
                sql += " WHERE"; 
            }
            sql += " Nome LIKE " + "'%" + Nome + "%'";
        }
        //ACERTAR FILTRO DE CPF
        if (CPF != null) {
            if (!where) {
                sql += " WHERE"; 
            }
            sql += " CPF = " + "'" + CPF + "'";
        }
        
        if (Telefone != null) {
            if (!where) {
                sql += " WHERE"; 
            }
            sql += " Telefone LIKE  " + Telefone;
        }
        
        List<Cliente> clientes = new ArrayList<Cliente>() ;
        
        try 
        {
             
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                clientes.add(new Cliente(rs.getInt("Id"), rs.getString("Nome"), rs.getString("CPF"),rs.getString("Telefone")));
            }
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }    
        return clientes;
    }
    
    private  static Calendar toCalendar(Date data){ 
        if (data == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        return cal;
    }

    @Override
    public List<Cliente> listarTodos() {
         String sql = "SELECT * FROM Cliente";
         
        List<Cliente> clientes = new ArrayList<Cliente>() ;
        try 
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                clientes.add(new Cliente((Integer) rs.getInt("ID"), rs.getString("Nome"),  rs.getString("CPF"), toCalendar(rs.getDate("DataNascimento")), rs.getString("Telefone")));
            }
            
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }    
        return clientes;  
    }
}
