/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author franm
 */
@WebServlet(name = "MathServlet", urlPatterns = {"/mathservlet.html"})
public class MathServlet extends HttpServlet {

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
         int x = 10;
        int y = 2;
        int res;
        String op = null;
        String error = null;
        try{
            String p1 = request.getParameter("x");
            String p2 = request.getParameter("y");
            op = request.getParameter("op");
            x = Integer.parseInt(p1);
            y = Integer.parseInt(p2);
        }catch(Exception ex){
            error = ex.getMessage();
        }
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MathServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Operacoes Aritmetricas</h1>");
            out.println("<h4><a href='index.html'>Voltar</a></h4>");
            out.println("<hr/>");
            out.println("<form>");
            out.println("<input type='number' name='x' value='"+x+"'/>");
            out.println("<select name='op')>");
            out.println("<option>+</option>");
            out.println("<option>-</option>");
            out.println("<option>*</option>");
            out.println("<option>/</option>");
            out.println("</select>");
            out.println("<input type='number1' name='y' value='"+y+"'/>");
            out.println("<input type='submit' value='Gerar'/>");
            out.println("<hr/>");
            out.println("</form>");
            if(error!=null){
                out.println("<div style='color:red'>Erro na tentativa de leitura dos parâmetros: "+error+"</div>");
            }else{
                out.println("<div>");
                switch(op){
                    case "+": 
                        res = x+y;
                        out.println(x+" + "+y+" = "+res);
                        break;
                    case "-":
                        res = x-y;
                        out.println(x+" - "+y+" = "+res);
                        break;
                    case "*":
                        res = x*y;
                        out.println(x+" * "+y+" = "+res);
                        break;
                    case "/": 
                        res = x/y;
                        out.println(x+" / "+y+" = "+res);
                        break;
                    default:
                        out.println("Invalido");
                }
                out.println("</div>");
            }
            out.println("</body>");
            out.println("</html>");
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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

}
