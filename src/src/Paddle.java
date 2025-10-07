/**
 * Paddle class represents the paddle in a game, extending the MoveableObject class.
 * It inherits properties and methods from MoveableObject to allow movement and interaction.
 */
public class Paddle extends MoveableObject{
    PowerUps currentPowerUp;
    public Paddle () {
        super();
        this.currentPowerUp = null;
    }

    public Paddle (double x, double y, double width, double height, double dx) {
        super(x, y, width, height, dx, 0);
        this.currentPowerUp = null;
    }

    public PowerUps getCurrentPowerUp() {
        return currentPowerUp;
    }

    public void setCurrentPowerUp(PowerUps currentPowerUp) {
        this.currentPowerUp = currentPowerUp;
    }




    @Override
    void move() {

    }

    @Override
    void update() {

    }

    @Override
    void render() {

    }
}
