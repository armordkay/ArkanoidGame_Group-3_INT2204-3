public enum PowerUpType {
    None(0),
    ExpandPaddle(1),
    FireBall(2);
    private final int numbertype;

    PowerUpType(int i) {
        this.numbertype = i;
    }

    public int getDayNumber() {
        return this.numbertype;
    }
}
