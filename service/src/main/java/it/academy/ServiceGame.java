package it.academy;

import it.academy.dao.inher.game.GameDAO;
import it.academy.entity.account.user.Language;
import it.academy.entity.game.Game;

import java.util.List;

public class ServiceGame {
    public List<Game> nextPage(long off, long lim) {
        GameDAO gameDAO = new GameDAO();
        gameDAO.getGameOffsetLimit(off, lim);
        return gameDAO.getGames();
    }

    public List<Game> nextPageWithFilter(long off, long lim, String name, int cost, int ageRest, Language language) {
        GameDAO gameDAO = new GameDAO();
        gameDAO.filter(name,cost,ageRest,language);
        gameDAO.getGameOffsetLimit(off, lim);
        return gameDAO.getGames();
    }
}
