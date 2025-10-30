package Arkanoid.model;

import Arkanoid.util.Constants;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PowerUps extends MoveableObject {
    private PowerUpType type;
    private boolean collected;

    /**
     * constructors.
     * @param x
     * @param y
     * @param type
     */

    public PowerUps(double x, double y, PowerUpType type) {
        super(x, y, Constants.POWERUP_SIZE, Constants.POWERUP_SIZE, Constants.POWERUP_FALL_SPEED);
        this.type = type;
        this.velocityY = speed;
        this.collected = false;
    }

    /**
     * move method.
     */
    @Override
    public void update() {
        move();
    }

    /**
     * move method.
     * @param deltaTime
     */

    @Override
    public void update(double deltaTime) {
        move(deltaTime);
    }

    /**
     * render object (its a small ball thats fall down)
     * @param gc
     */

    @Override
    public void render(GraphicsContext gc) {
        if (collected) return;

        // Set color based on type
        gc.setFill(getColor());
        gc.fillOval(x, y, width, height);

        // Add border
        gc.setStroke(Color.WHITE);
        gc.setLineWidth(2);
        gc.strokeOval(x, y, width, height);

        // Draw icon/letter
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font("Arial", 12));
        String letter = getIconLetter();
        gc.fillText(letter, x + width / 2 - 4, y + height / 2 + 4);
    }

    /**
     * color of a powerup ball
     *
     * @return
     */

    private Color getColor() {
        // color of every ball
        switch (type) {
            case EXPAND_PADDLE:
                return Constants.POWERUP_EXPAND_COLOR; // expand paddle ball
            case SHRINK_PADDLE:
                return Constants.POWERUP_SHRINK_COLOR; // shrink paddle ball
            case SPEED_UP_BALL:
                return Constants.POWERUP_SPEED_UP_COLOR; // speed up ball ball
            case SPEED_DOWN_BALL:
                return Constants.POWERUP_SPEED_DOWN_COLOR; //
            case EXTRA_LIFE: // extra life ball
                return Constants.POWERUP_EXTRA_LIFE_COLOR;
            case MULTI_BALL: // multi ball ball.
                return Constants.POWERUP_MULTI_BALL_COLOR;
            default:
                return Color.WHITE; // not a ball
        }
    }

    private String getIconLetter() { // select icon of every ball
        switch (type) {
            case EXPAND_PADDLE:
                return "E";
            case SHRINK_PADDLE:
                return "S";
            case SPEED_UP_BALL:
                return "+";
            case SPEED_DOWN_BALL:
                return "-";
            case EXTRA_LIFE:
                return "L";
            case MULTI_BALL:
                return "M";
            default:
                return "?";
        }
    }

    /**
     * when a ball is outside of the frame
     * @return
     */
    public boolean isOutOfBounds() {
        return y > Constants.WINDOW_HEIGHT;
    }

    /**
     *  set collected.
     */
    public void collect() {
        collected = true;
    }

    /**
     * check if collected.
     * @return
     */

    public boolean isCollected() {
        return collected;
    }

    /**
     * getters.
     * @return
     */

    public PowerUpType getType() {
        return type;
    }
}