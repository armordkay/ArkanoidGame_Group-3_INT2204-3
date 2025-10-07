public enum GameState {
    START(0),
    PAUSE(1),
    PLAYING(2),
    EXIT(3);

    private int gamestate;
    /**
     * constructor
     */
    private GameState(int gamestate) {
        this.gamestate = gamestate;
    }

    /**
     *
     * @return
     */
    public int getGameState() {
        return this.gamestate;
    }
}
