package controllers.loginusers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.LoginUser;

/**
 * Servlet implementation class LoginUsersNewServlet
 */
@WebServlet("/loginusers/new")
public class LoginUsersNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsersNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("loginuser", new LoginUser());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/loginusers/new.jsp");
        rd.forward(request, response);
    }

}
