public enum BrickType {
    NORMAL(1),
    STRONG(5);

    private int strength;

    /**
     * constructor.
     */
    private BrickType(int strength) {
        this.strength = strength;
    }

    /**
     *
     * @return
     */
    public int getStrength() {
        return this.strength;
    }
}
