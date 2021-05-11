
package com.emergentes.DAO;

import com.emergendetes.BD.Conexion;
import com.emergentes.MODELO.UsuarioNet;
import java.sql.ResultSet;


public class LoginDAO {
    int rspta=0;
    String sql="";
    ResultSet rs=null;
    Conexion cn=new Conexion();
    public int validarLogin(UsuarioNet un) throws Exception{
        sql="SELECT COUNT(id) AS cantidad FROM usuarios where usuario='"+un.getUsuario()+"' and password='"+un.getPassword()+"'";
        rs=cn.ejecutarConsulta(sql);

        while(rs.next()){
            rspta=rs.getInt("cantidad");
        }
        return rspta;
    }
}
