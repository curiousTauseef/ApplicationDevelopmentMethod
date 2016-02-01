/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AdvancedCoffeeMachine;
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
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
@WebServlet(name = "AdvancedCoffeeMachineController", urlPatterns = {"/AdvancedCoffeeMachineController"})
public class AdvancedCoffeeMachineController extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        AdvancedCoffeeMachine m = null;
     
        if (session == null) {
            session = request.getSession();
            m = new AdvancedCoffeeMachine(1000, 1000, 1000);
            session.setAttribute("machine", m);
            session.setAttribute("message", "\"message\":\"\"");
            System.out.println(m);
        } else {
            m = (AdvancedCoffeeMachine) session.getAttribute("machine");
            System.out.println(m);
        };
        // Get the printwriter object from response to write the required json object to the output
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String json = null;
        // if there's function
        if (request.getParameter("func") != null) {
            switch (request.getParameter("func")) {
                case "turnOnOff":
                    session.setAttribute("message", m.powerOnOff());
                    break;
                case "getRegularCoffee":
                    session.setAttribute("message", m.makeRegularCoffee());
                    break;
                case "getEspressoCoffee":
                    session.setAttribute("message", m.makeEspressoCoffee());
                    break;
                case "getCappuccino":
                    session.setAttribute("message", m.makeCapuccinoCoffee());
                    break;
            };
            session.setAttribute("machine", m);
        }
        json = "{" + session.getAttribute("message") + "," + (AdvancedCoffeeMachine) session.getAttribute("machine") + "}";
        System.out.println(json);
        out.println(json);
        out.flush();
        out.close();
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
HttpSession session = request.getSession(false);
        AdvancedCoffeeMachine m = null;
        if (session == null) {
            session = request.getSession();
            m = new AdvancedCoffeeMachine(1000, 1000, 1000);
            session.setAttribute("machine", m);
            session.setAttribute("message", "\"message\":\"\"");
        } else {
            m = (AdvancedCoffeeMachine) session.getAttribute("machine");
        };
        // Get the printwriter object from response to write the required json object to the output
        response.setContentType("application/json");
        // if there's function
        if (request.getParameter("func") != null) {
            switch (request.getParameter("func")) {
                case "addWater":
                    session.setAttribute("message", m.fillWaterTank(Integer.parseInt(request.getParameter("amount"))));
                    break;
                case "addCoffeeBeans":
                    session.setAttribute("message", m.fillBeansTank(Integer.parseInt(request.getParameter("amount"))));
                    break;
                case "addMilk":
                    session.setAttribute("message", m.fillMilkTank(Integer.parseInt(request.getParameter("amount"))));
            };
            session.setAttribute("machine", m);
        }
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
