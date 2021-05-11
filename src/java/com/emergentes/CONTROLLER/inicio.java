/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.CONTROLLER;

import com.emergentes.MODELO.Blog;
import com.emergentes.MODELO.BlogDAOimpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Intel i5
 */
@WebServlet(name = "inicio", urlPatterns = {"/inicio"})
public class inicio extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            BlogDAO dao=new BlogDAOimpl();
            int id;
            Blog avi=new Blog();
            String action=(request.getParameter("action")!= null) ? request.getParameter("action") : "view";
            
            switch(action){
                case"add":
                    request.setAttribute("posts", avi);
                    request.getRequestDispatcher("fmrblog.jsp").forward(request, response);
                    break;
                case "edit":
                    id=Integer.parseInt(request.getParameter("id"));
                    avi=dao.getById(id);
                    System.out.println(avi);
                    request.setAttribute("posts", avi);
                    request.getRequestDispatcher("fmrblog.jsp").forward(request, response);
                    break;
                case"delete":
                    id=Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/inicio");
                    break;
                case"view":
                    List<Blog> lista = dao.getAll();
                    request.setAttribute("posts", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                default:
                    break;
            }
        }catch(Exception ex){
            System.out.println("Error "+ex.getMessage());

    }

}

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        int id=Integer.parseInt(request.getParameter("id"));
        String fecha=request.getParameter("fecha");

        
        String titulo=request.getParameter("titulo");
        String contenido=request.getParameter("contenido");

        Blog avi=new Blog();
        
        avi.setId(id);
        avi.setFecha(fecha);
        avi.setTitulo(titulo);
        avi.setContenido(contenido);
        
        if(id == 0){
            try{
                BlogDAO dao=new BlogDAOimpl();
                dao.insert(avi);
                response.sendRedirect(request.getContextPath()+"/inicio");
                
            }catch(Exception ex){
                System.out.println("Error "+ex.getMessage());
            }
        }else{
            try{
                BlogDAO dao=new BlogDAOimpl();
                dao.update(avi);
                response.sendRedirect(request.getContextPath()+"/inicio");               
            }catch(Exception ex){
                System.out.println("Error "+ex.getMessage());
            }
        }
    }
}
