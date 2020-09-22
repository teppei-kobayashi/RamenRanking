package controllers.loginusers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.LoginUser;
import utils.DBUtil;

/**
 * Servlet implementation class LoginusersEditServlet
 */
@WebServlet("/loginusers/edit")
public class LoginusersEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginusersEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

       LoginUser l = em.find(LoginUser.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("loginuser", l);
        request.setAttribute("_token", request.getSession().getId());
        request.getSession().setAttribute("loginuser_id", l.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/loginusers/edit.jsp");
        rd.forward(request, response);
    }

}
