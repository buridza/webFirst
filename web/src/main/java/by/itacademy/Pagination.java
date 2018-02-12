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
import java.util.List;

@WebServlet("/pagination")
public class Pagination extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long nextPage = Long.parseLong(req.getParameter("nextPage"));
        long numberOfRows = Long.parseLong(req.getParameter("numberOfRows"));
        ServiceGame game = new ServiceGame();
        List<Game> games = game.nextPage(nextPage * numberOfRows - numberOfRows, numberOfRows);
        req.setAttribute("currentPage", nextPage);
        req.setAttribute("allGames", games);
        req.setAttribute("language", Language.values());
        req.getRequestDispatcher("WEB-INF/jsp/firstPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
