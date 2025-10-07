/**
 * Represents a generic game object with position and dimensions.
 */
public abstract class GameObject {
    private double x;
    private double y;
    private double width;
    private double height;

    /**
     * default constructor
     */
    public GameObject() {
        x = 0;
        y = 0;
        width = 0;
        height = 0;
    }

    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public GameObject(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     *
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }


    /**
     *
     * @return
     */
    public double getY() {
        return y;
    }


    /**
     *
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    public double getWidth() {
        return width;
    }


    /**
     *
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }


    public void setHeight() {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public PowerUps getCurrentPowerUp() {

    }


    public setCurrentPowerUp(PowerUps powerUp) {

    }


    abstract void update();
    abstract void render();
}
