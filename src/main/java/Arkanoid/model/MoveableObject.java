package Arkanoid.model;

public abstract class MoveableObject extends GameObject {
    protected double velocityX;
    protected double velocityY;
    protected double speed;

    /**
     * constructor.
     * @param x
     * @param y
     * @param width
     * @param height
     * @param speed
     */

    public MoveableObject(double x, double y, double width, double height, double speed) {
        super(x, y, width, height);
    }

    /**
     * move method
     */
    public void move() {
        x += velocityX;
        y += velocityY;
    }

    /**
     * move with fps 60
     * @param deltaTime
     */
    public void move(double deltaTime) {
        x += velocityX * deltaTime * 60;
        y += velocityY * deltaTime * 60;
    }

    /**
     * getters and setters.
     */
    public double getVelocityX() { return velocityX; }
    public void setVelocityX(double velocityX) { this.velocityX = velocityX; }

    public double getVelocityY() { return velocityY; }
    public void setVelocityY(double velocityY) { this.velocityY = velocityY; }

    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }
}
