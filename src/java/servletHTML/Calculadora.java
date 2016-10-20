/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletHTML;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;

public class Calculadora extends HttpServlet {

    int Numero1;
    int Numero2;
    String opc;
    float Resultado;

    public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
        Numero1 = Integer.parseInt(peticion.getParameter("Numero1"));
        Numero2 = Integer.parseInt(peticion.getParameter("Numero2"));
        opc = peticion.getParameter("opc");

        switch (opc) {
            case "+":
                Resultado = Numero1 + Numero2;
                break;
            case "-":
                Resultado = Numero1 - Numero2;
                break;
            case "*":
                Resultado = Numero1 * Numero2;
                break;
            case "/":
                Resultado = (float) Numero1 / Numero2;
                break;

        }

        PrintWriter out = new PrintWriter(respuesta.getOutputStream());
        out.println("<html>");
        out.println("<head><title>Resultado</title>"
                + "<link href=\"css.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "</head>");
        out.println("<body>"
                + "<h1> Tu resultado es: " + Numero1 + " " + opc + " " + Numero2 + " = " + Resultado + "</h1>\n"
                + "");
        out.close();
    }
}
