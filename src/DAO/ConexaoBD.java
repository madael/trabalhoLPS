package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Daniel Lucarelli
 */
public class ConexaoBD {
    private static Connection conn = null;
    
    private ConexaoBD(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Secomp","root","");
        }catch(ClassNotFoundException e){
            System.out.println("Erro no driver de conexão "+e);
        }catch(SQLException ex){
            System.out.println("Não foi possivel conectar "+ ex);
        }
    }
    
    public static Connection conexao(){
        if(conn==null)
            new ConexaoBD();
        return conn;
    }
    
    

    
}
