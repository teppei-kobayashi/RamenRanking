package contorollers.ranking;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Ranking;
import utils.DBUtil;

/**
 * Servlet implementation class RankingsEdit2Servlet
 */
@WebServlet("/rankings/edit2")
public class RankingsEdit2Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RankingsEdit2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Ranking l = em.find(Ranking.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("ramen", l.getRamenId());
        request.setAttribute("ranking", l);
        request.setAttribute("_token", request.getSession().getId());
        request.getSession().setAttribute("ranking_id", l.getId());


        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/rankings/edit2.jsp");
        rd.forward(request, response);
    }

}
