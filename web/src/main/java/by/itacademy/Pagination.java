package by.itacademy;

import it.academy.ServiceGame;
import it.academy.entity.account.user.Language;
import it.academy.entity.game.Game;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/pagination")
public class Pagination extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long nextPage = 1;
        if(!(req.getParameter("nextPage")==null||req.getParameter("nextPage").isEmpty())) {
            nextPage = Long.parseLong(req.getParameter("nextPage"));
        }
        long numberOfRows = 5;
        if(!(req.getParameter("numberOfRows")==null || req.getParameter("numberOfRows").isEmpty()))
            numberOfRows = Long.parseLong(req.getParameter("numberOfRows"));

        ServiceGame serviceGame = new ServiceGame();

        String name = "%"+req.getParameter("name")+"%";

        int cost = 0;
        if(!(req.getParameter("cost")==null||req.getParameter("cost").isEmpty())) {
            cost = Integer.parseInt(req.getParameter("cost"));
        }
        int ageRestrictions = 0;
        if(!(req.getParameter("ageRestrictions")==null||req.getParameter("ageRestrictions").isEmpty())) {
            ageRestrictions = Integer.parseInt(req.getParameter("ageRestrictions"));
        }

         Language language = null;
        if (!(req.getParameter("language")==null || req.getParameter("language").isEmpty())) {
            language = Language.valueOf(req.getParameter("language"));
        }
        //else language = Language.valueOf(req.getParameter("language"));


        List<Game> games = serviceGame.nextPageWithFilter(nextPage * numberOfRows - numberOfRows, numberOfRows, name, cost, ageRestrictions, language);


        req.setAttribute("name", name.replaceAll("%", ""));
        req.setAttribute("language", language);
        req.setAttribute("age", ageRestrictions);
        req.setAttribute("cost", cost);
        req.setAttribute("currentNumberOfRows", numberOfRows);
        req.setAttribute("currentPage", nextPage);
        req.setAttribute("allGames", games);


        req.getRequestDispatcher("WEB-INF/jsp/firstPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
