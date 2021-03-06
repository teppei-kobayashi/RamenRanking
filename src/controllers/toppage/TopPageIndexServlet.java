package controllers.toppage;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.RankingAvg;
import utils.DBUtil;
import utils.RankingDAO;;
/**
 * Servlet implementation class TopPageIndexServlet
 */
@WebServlet("/index.html")
public class TopPageIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopPageIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        int page;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(Exception e) {
            page = 1;
        }

        RankingDAO dao = new RankingDAO();

        List<RankingAvg> list = dao.getRankingAvgs();

        // 取得したListオブジェクトを順番に取り出し、出力
        System.out.println("これから結果を表示します");
        for(RankingAvg item : list){
                item.getRamen_name();
                item.getPoint();
                System.out.println("ラーメン:" + item.getRamen_name());
                System.out.println("ポイント" + item.getPoint());
        }
        long rankings_count = (long)em.createNamedQuery("getRankingsCount", Long.class)
                .getSingleResult();

        em.close();

        request.setAttribute("rankings", list);
        request.setAttribute("rankings_count", rankings_count);
        request.setAttribute("page", page);


        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/topPage/index.jsp");
        rd.forward(request, response);
    }

}
