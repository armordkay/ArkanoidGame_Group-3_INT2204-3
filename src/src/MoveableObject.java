/**
 * An abstract class representing a moveable object in the game.
 * It extends the GameObject class and adds movement capabilities.
 */
public abstract class MoveableObject extends GameObject{
    double dx;
    double dy;
    public MoveableObject() {
        super();
        this.dx = 0;
        this.dy = 0;
    }
    public MoveableObject(double x, double y, double width, double height, double dx, double dy) {
        super(x, y, width, height);
        this.dx = dx;
        this.dy = dy;
    }

    abstract void move();
}
