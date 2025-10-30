package Arkanoid.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Brick extends GameObject {
    private BrickType type;
    private int hitsRemaining;
    private Color color;
    private boolean destroyed;

    /**
     * Brick constructor with 6 params.
     * @param x the x position
     * @param y the y position
     * @param width the width of brick
     * @param height the height of brick
     * @param type brick type
     * @param color brick color
     */
    public Brick(double x, double y, double width, double height, BrickType type, Color color) {
        super(x, y, width, height);
        this.type = type;
        this.color = color;
        this.destroyed = false;
    }

    /**
     * Update the brick status.
     */
    @Override
    public void update() {
        // bricks dont move
    }

    /**
     * Update the brick status.
     * @param deltaTime time elapsed from last update
     */
    @Override
    public void update(double deltaTime) {
        // bricks dont move
    }

    /**
     * Render the brick on the canvas.
     * @param gc the graphics context used to draw the brick on the canvas
     */
    @Override
    public void render(GraphicsContext gc) {
        
    }

    /**
     * Method for the brick to take hit.
     * @return true if the brick is destroyed, false otherwise
     */
    public boolean hit() {
        // the get hit implement
        if (type.UNBREAKABLE == type) {
            return false;
        }

        
    }

    /**
     * Getter of the destroyed status of the brick.
     * @return destroyed status of the brick
     */
    public boolean isDestroyed() {
        return destroyed;
    }

    /**
     * Getter of brick type.
     * @return brick type
     */
    public BrickType getType() {
        return type;
    }

    /**
     * Get the score after destroy a brick.
     * @return score the score rewarded for the brick
     */
    public int getScore() {

        
    }
}
