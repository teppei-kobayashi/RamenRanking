package controllers.ramen;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.LoginUser;
import models.Ramen;
import models.Ranking;
import models.validators.RankingValidator;
import utils.DBUtil;
/**
 * Servlet implementation class RamensUpdate2Servlet
 */
@WebServlet("/ramens/update2")
public class RamensUpdate2Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RamensUpdate2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Ranking l = em.find(Ranking.class, (Integer)(request.getSession().getAttribute("ranking_id")));

            l.setPoint((Integer.valueOf(request.getParameter("point"))));
            l.setLoginUser((LoginUser)request.getSession().getAttribute("login_status"));
            Ramen r = em.find(Ramen.class, (Integer)(request.getSession().getAttribute("ramen_id")));
            l.setRamenId(r);

            List<String> errors = RankingValidator.validate(l);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("ranking", l);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/ramens/edit2.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "更新が完了しました。");

                request.getSession().removeAttribute("ramen_id");

                response.sendRedirect(request.getContextPath() + "/ramens/index");
            }
        }
    }

}
