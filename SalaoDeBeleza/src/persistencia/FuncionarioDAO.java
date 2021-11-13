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
import negocio.Funcionario;
import negocio.FuncionarioFuncao;

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

    @Override
    public List<Funcionario> listarComFiltro(Integer Id, String Nome, String CPF, Integer idFuncao) {
        String sql = "SELECT * FROM FUNCIONARIO";
        
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
        
        if (CPF != null) {
            if (!where) {
                sql += " WHERE"; 
            }
            sql += " CPF = " + "'" + CPF + "'";
        }
        
        if (CPF != null) {
            if (!where) {
                sql += " WHERE"; 
            }
            sql += " idFuncao = " + idFuncao;
        }
        
        List<Funcionario> funcionarios = new ArrayList<Funcionario>() ;
        
        try 
        {
             
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                funcionarios.add(new Funcionario(rs.getInt("Id"), rs.getString("Nome"), rs.getString("CPF"),rs.getInt("IdFuncao")));
            }
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }    
        return funcionarios;
    }

    @Override
    public Funcionario buscarPorID(Integer Id) {
        String sql = "SELECT * FROM FUNCIONARIO"
                + " WHERE id = (?)";
        Funcionario funcionario = new Funcionario() ;
        try 
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                //Alterar construtor para receber data de nascimento e porcentagem comissao padrao
                funcionario = new Funcionario((Integer) rs.getInt("ID"), rs.getString("Nome"),  rs.getString("CPF"), toCalendar(rs.getDate("DataNascimento")), rs.getInt("ComissaoPorcentagemPadrao"),  rs.getInt("IdFuncao"));
            }
            
        }
        catch (SQLException ex) {    
            System.err.println("Houve um erro..." + ex.getMessage());
        }    
        return funcionario; //To change body of generated methods, choose Tools | Templates.
    }
    
    public static Calendar toCalendar(Date date){ 
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal;
}
    
}
