/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author joaos
 */
public class ConFactory {
    //String url = "jdbc:mysql:81//localhost/salaodebeleza";
    String url = "jdbc:mysql://localhost:3306/salaodebeleza";
    String user = "root";
    String password = ""; 
    public Connection getConnection()
    {
        try {
            return DriverManager.getConnection(url, user, password);
        }
        catch(SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }
    
}
