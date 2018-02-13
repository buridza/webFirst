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

        String name = req.getParameter("name");
        int cost = Integer.parseInt(req.getParameter("cost"));
        int ageRestrictions = Integer.parseInt(req.getParameter("ageRestrictions"));
        Language language;
        if (req.getParameter("language").isEmpty())
            language = null;
        else language = Language.valueOf(req.getParameter("language"));


        List<Game> games = game.nextPageWithFilter(nextPage * numberOfRows - numberOfRows, numberOfRows, name, cost, ageRestrictions, language);

        /*
        * <br>Название игры: <input name="name" type="text"/>
    <br>Язык игры: <input list="language" name="language" value="${requestScope.language}" aria-dropeffect="popup"/>
    <datalist id="language">
        <option>RUSSIAN</option>
        <option>ENGLISH </option>
        <option>GERMAN</option>
        <option>FRENCH</option>
    </datalist>
    <br>Возрастное ограничение: <input type="number" min="0" max="21" value="${requestScope.age}" step="1" name="ageRestrictions">
    <br>Стоимость: <input type="number" min="0" value="${requestScope.cost}" name="cost" step = "1">
    <br>
    Количество записей:    <input name="numberOfRows"  type="number" min="5" max="50" step="5" value="${requestScope.currentNumberOfRows}">
    <c:if test="${requestScope.currentPage > 1}">
        <button type="submit" name = "nextPage"  value="${currentPage-1}">${requestScope.get("currentPage")-1}</button>
    </c:if>*/
        req.setAttribute("name", name);
        req.setAttribute("language", language);
        req.setAttribute("age", ageRestrictions);
        req.setAttribute("cost", cost);
        req.setAttribute("currentNumberOfRows", numberOfRows);
        req.setAttribute("currentPage", nextPage);
        req.setAttribute("allGames", games);
        //req.setAttribute("language", Language.values());


        req.getRequestDispatcher("WEB-INF/jsp/firstPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
