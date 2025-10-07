/**
 * PowerUps class represents power-up items in the game.
 * It extends the GameObject class to inherit common properties and behaviors.
 */
public class PowerUps extends GameObject{
    private double duration;
    private PowerUpType type;

    public PowerUps() {
        super();
        this.duration = 0;
        this.type = PowerUpType.NONE;
    }
    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param duration
     * @param type
     */
    public PowerUps(double x, double y, double width, double height, double duration, PowerUpType type) {
        super(x, y, width, height);
        this.duration = duration;
        this.type = type;
    }

    @Override
    void update() {

    }

    @Override
    void render() {

    }
}
