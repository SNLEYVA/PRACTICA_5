/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.MODELO;

import com.emergendetes.BD.Conexion;
import com.emergentes.CONTROLLER.BlogDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Intel i5
 */
public class BlogDAOimpl extends Conexion implements BlogDAO{
    
   @Override
    public void insert(Blog blog) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps= this.conn.prepareStatement("INSERT INTO posts (fecha,titulo,contenido) values(?,?,?)");
            ps.setString(1, blog.getFecha());
            ps.setString(2, blog.getTitulo());
            ps.setString(3, blog.getContenido());
            ps.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Blog blog) throws Exception {
       try{
           PreparedStatement ps= this.conn.prepareStatement("UPDATE posts set fecha=?, titulo=?, contenido=? where id=?");
           ps.setString(1, blog.getFecha());
           ps.setString(2, blog.getTitulo());
           ps.setString(3, blog.getContenido());
           ps.setInt(4, blog.getId());
           ps.executeUpdate();
       }catch(Exception e){
           throw e;
       }finally{
           this.desconectar();
       }
    }

    @Override
    public void delete(int id) throws Exception {
        try{
            PreparedStatement ps= this.conn.prepareStatement("DELETE FROM posts where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public Blog getById(int id) throws Exception {
        Blog avi=new Blog();
        try{
            this.conectar();
            PreparedStatement ps= this.conn.prepareStatement("SELECT * FROM posts WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                avi.setId(rs.getInt("id"));
                avi.setFecha(rs.getString("fecha"));
                avi.setTitulo(rs.getString("titulo"));
                avi.setContenido(rs.getString("contenido"));
            }
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return avi;
    }

    @Override
    public List<Blog> getAll() throws Exception {
        List<Blog> lista =null;
        try{
            this.conectar();
            PreparedStatement ps= this.conn.prepareStatement("SELECT * FROM posts order by fecha desc");
            ResultSet rs=ps.executeQuery();      
            lista=new ArrayList<Blog>();
            while(rs.next()){
                Blog avi=new Blog();
                avi.setId(rs.getInt("id"));
                avi.setFecha(rs.getString("fecha"));
                avi.setTitulo(rs.getString("titulo"));
                avi.setContenido(rs.getString("contenido"));
                lista.add(avi);
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return lista;
    }    
    
}
