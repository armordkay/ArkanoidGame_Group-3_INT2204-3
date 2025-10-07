/**
 * Class representing a brick in the game.
 * It extends the GameObject class to inherit position and dimension properties.
 */
import java.util.Random;
public class Brick extends GameObject{
    private int hitPoints;
    private BrickType type;

    /**
     * default constructor.
     *
     */
    public Brick() {
        super();

    }

    /**
     *
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */

    public Brick(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public Brick(double x, double y, double width, double height, BrickType type) {
        super(x, y, width, height);
        this.type = type;
        if (this.type == BrickType.STRONG) {
            Random rand = new Random();
            this.hitPoints = rand.nextInt(3, 6);
        } else {
            this.hitPoints = type.getStrength();
        }
    }
    public int getHitPoints() {
        return this.hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setType(BrickType type) {
        this.type = type;
    }

    public void takeHit() {
        this.hitPoints--;

    }

    public boolean isDestroyed() {
        return hitPoints <= 0;
    }
    @Override
    void update() {

    }

    @Override
    void render() {

    }
}
