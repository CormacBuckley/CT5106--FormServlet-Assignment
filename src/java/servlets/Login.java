/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

//        String user = request.getParameter("username");
//        String pass = request.getParameter("password");
//        String mail = request.getParameter("mail");
//
//        if (userCheck(user, pass)) {
//            
//            HttpSession session = request.getSession();
//            session.setAttribute("userName", request.getParameter("username"));
//            session.setAttribute("password", request.getParameter("password"));
//            session.setAttribute("mail", request.getParameter("mail"));
//            
//                if(request.getParameter("spam") == null){
//                    session.setAttribute("spam", "Not Subscribed");
//                }
//                else{
//                   session.setAttribute("spam", "Subscribed");
//                }
//
//         
//        } else {
//
//            try (PrintWriter out = response.getWriter()) {
//                RequestDispatcher rd = request.getRequestDispatcher("login.html");
//                rd.forward(request, response);
//            }
//        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String user = request.getParameter("username");
             String pass = request.getParameter("password");
                String mail = request.getParameter("mail");
        
         if (userCheck(user, pass)) {
            
            HttpSession session = request.getSession();
            session.setAttribute("userName", request.getParameter("username"));
            session.setAttribute("password", request.getParameter("password"));
            session.setAttribute("mail", request.getParameter("mail"));
            
                if(request.getParameter("spam") == null){
                    session.setAttribute("spam", "Not Subscribed");
                }
                else{
                   session.setAttribute("spam", "Subscribed");
                }
//                 RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
//             requestDispatcher.forward(request, response);
try (PrintWriter out = response.getWriter()) {
    
    RequestDispatcher rd = request.getRequestDispatcher("confirm");
                rd.forward(request, response);
//   
}
         
        } else {

            try (PrintWriter out = response.getWriter()) {
                RequestDispatcher rd = request.getRequestDispatcher("login.html");
                rd.forward(request, response);
            }
        }
        
       

// You can call the RequestDispatcher using either its include()
// or forward() method:
        


} 

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    protected boolean userCheck(String user, String pass) {
        if (user.equals("Robert") && pass.equals("Paulson")) {
            return true;
        } else {
            return false;
        }
    }
}
