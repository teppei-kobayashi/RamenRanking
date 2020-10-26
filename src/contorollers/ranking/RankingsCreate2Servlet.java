package contorollers.ranking;

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
 * Servlet implementation class RankingsCreate2Servlet
 */
@WebServlet("/rankings/create2")
public class RankingsCreate2Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RankingsCreate2Servlet() {
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

            Ranking l = new Ranking();
            Ramen r = em.find(Ramen.class, (Integer)(request.getSession().getAttribute("ramen_id")));

            l.setLoginUser((LoginUser)request.getSession().getAttribute("login_status"));
            l.setRamenId(r);
            l.setPoint(Integer.valueOf(request.getParameter("point")));
            l.setPoint_flag(1);


            List<String> errors = RankingValidator.validate(l);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("ranking", l);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/rankings/new2.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.persist(l);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "登録が完了しました。");

                response.sendRedirect(request.getContextPath() + "/rankings/index2");
            }
        }
    }

}
