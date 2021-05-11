
package com.emergendetes.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    static String url="jdbc:mysql://localhost:3307/bd_blog";
    static String usuario="root";
    static String password="";
    protected Connection conn=null;
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url,usuario,password);
            if(conn!=null){
                System.out.println("Conexion OK: "+ conn);
            }
        }catch(SQLException ex){
            System.out.println("Error de SQL: "+ ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar(){
        System.out.println("Cerrar la BD: "+ conn);
        try{
            conn.close();
        }catch (SQLException ex){
            System.out.println("Error de SQL: "+ ex.getMessage());
        }
    }      

    public ResultSet prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet ejecutarConsulta(String sql) throws Exception{
    Statement st=null;
    st=conectar().createStatement();
    ResultSet rs=st.executeQuery(sql);
    return rs;
    }
}
