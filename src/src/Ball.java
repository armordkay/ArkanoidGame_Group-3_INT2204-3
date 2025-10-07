/**
 * Ball class represents a ball object in the game.
 * It extends the MoveableObject class to inherit movement properties.
 */
public class Ball extends MoveableObject{
    public Ball(double x, double y, double width, double height, double dx, double dy) {
        super(x, y, width, height, dx, dy);
    }


    @Override
    void move() {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    @Override
    void update() {
        move();
    }

    @Override
    void render() {
    }
}
