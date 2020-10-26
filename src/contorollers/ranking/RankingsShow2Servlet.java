package contorollers.ranking;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.LoginUser;
import models.Ramen;
import models.Ranking;
import utils.DBUtil;

/**
 * Servlet implementation class RankingsShow2Servlet
 */
@WebServlet("/rankings/show2")
public class RankingsShow2Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RankingsShow2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        LoginUser login_status = (LoginUser)request.getSession().getAttribute("login_status");
        Ramen r = em.find(Ramen.class, Integer.parseInt(request.getParameter("id")));
        Ranking l = new Ranking();

        try{
            l = em.createNamedQuery("getRankingsRamen", Ranking.class)
                .setParameter("login_status", login_status)
                .setParameter("ramen_id", r)
                .getSingleResult();
        } catch(NoResultException ex) {}

        em.close();

        request.setAttribute("ramen", r);
        request.setAttribute("ranking", l);
        request.setAttribute("_token", request.getSession().getId());
        request.getSession().setAttribute("ramen_id", r.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/rankings/show2.jsp");
        rd.forward(request, response);
    }
}
