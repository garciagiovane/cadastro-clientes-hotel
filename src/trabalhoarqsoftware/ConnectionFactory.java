package trabalhoarqsoftware;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    
    private static String DRIVER = "com.mysql.jdbc.driver";
    private static String URL = "jdbc:mysql://localhost:3306/hotelaria";
    private static String USER = "root";
    private static String PASS = "";
    
    public static Connection getConncetion(){
        
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException | SQLException ex) {
        
            throw new RuntimeException(" Erro na conexão: ");
        
        }
    }
    
    public static void closeConnection(Connection con){
            
            try {
               if(con!=null){
                con.close();
               }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
            
            closeConnection(con, stmt);
        
            try {
   
                if(rs!=null){
                   
                 rs.close();   
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
            
            closeConnection(con);
        
            try {
   
                if(stmt!=null){
                   
                 stmt.close();   
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
}
