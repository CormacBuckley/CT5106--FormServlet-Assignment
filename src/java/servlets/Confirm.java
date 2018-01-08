/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author I342042
 */
@WebServlet(name = "confirm", urlPatterns = {"/confirm"})
public class Confirm extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        
          
        try (PrintWriter out = response.getWriter()) {
            
                      HttpSession session = request.getSession(); 

            
     String userName, password, email, spam;
        userName = (String) session.getAttribute("userName");
        password = (String) session.getAttribute("password");
        email = (String) session.getAttribute("mail");
        spam = (String) session.getAttribute("spam");
            

            out.println("<h1> User credentials accepted</h1>");
            out.println("<p> Username =" + userName + "</p> <br>");
            out.println("<p> Password =" + password + "</p> <br>");
            out.println("<p> E-mail =" + email + "</p> <br>");
            out.println("<p> Mailing List = " + spam + "</p> <br>");
        }
    }

}
