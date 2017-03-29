package pl.jcrusader.rebusydladzieci.game;

/**
 * Created by bogumil on 3/28/17.
 * <p>
 * This service is indented to store User progress locally in Preferences.
 */
public interface LocalDataService {

    /**
     * Gets highest riddle number which was solved by user.
     *
     * @return number of highest solved riddle or {@link GameConstants#MIN_LEVEL} if no such number is stored
     */
    Integer getHighestSolvedRiddleNumber();

    /**
     * Increments highest riddle number which was solved by user (gets previous one and adds 1).
     */
    void incrementHighestSolvedRiddleNumber();

    /**
     * Resets highest riddle number solved by user (sets value to {@link GameConstants#MIN_LEVEL}).
     */
    void resetHighestSolvedRiddleNumber();
}
