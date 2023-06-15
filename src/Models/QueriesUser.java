/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Ceduc
 */
public class QueriesUser extends Conexion{
    
    public boolean registrar(ModelUser mu)
    {
        
            PreparedStatement ps = null;
            Connection con = conectar();
            
            String sql = "INSERT INTO usuario(login, password) VALUES(?,?)";
            
            try {
            ps= con.prepareStatement(sql);
            ps.setString(1, mu.getUsuario());
            ps.setString(2, mu.getPassword());
            ps.execute();
            return true;
        } catch (SQLException ex) {
                System.err.println(ex);
                return false;
        }
            finally
            {
                try{
                    con.close();
                }
                catch(SQLException ex){
                    System.err.println(ex);     
                }
            }
    }
    
}
