package contorollers.ranking;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Ramen;
import models.Ranking;
import utils.DBUtil;

/**
 * Servlet implementation class RankingsNewServlet
 */
@WebServlet("/rankings/new")
public class RankingsNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RankingsNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        request.setAttribute("_token", request.getSession().getId());

        Ranking l = new Ranking();
        Ramen r = em.find(Ramen.class, Integer.parseInt(request.getParameter("id")));
        em.close();

        request.setAttribute("ranking", l);
        request.setAttribute("ramen", r);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/rankings/new.jsp");
        rd.forward(request, response);
    }

}
