package it.academy;

import it.academy.dao.inher.game.GameDAO;
import it.academy.entity.game.Game;

import java.util.List;

public class ServiceGame {
    public List<Game> nextPage(long off, long lim) {

        return new GameDAO().getGameOffsetLimit(off, lim);
    }
}
