package pl.jcrusader.rebusydladzieci.game;

/**
 * Created by bogumil on 3/28/17.
 */

public interface LocalDataService {
    Integer getCurrentRiddleNumber();

    void incrementCurrentRiddleNumber();

    void resetRiddleNumber();
}
