package Arkanoid.model;

import Arkanoid.util.Constants;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;

public class Ball extends MoveableObject {
    private final int radius;
    private boolean stuck;
    private Paddle paddle;
    private double smoothX;
    private double smoothY;

    /**
     * Ball constructor with paddle parameter.
     *
     * @param paddle the paddle to which the ball is initially stuck
     */
    public Ball(Paddle paddle) {
        super(
                Constants.WINDOW_WIDTH / 2.0,
                Constants.PADDLE_Y - Constants.BALL_RADIUS,
                Constants.BALL_RADIUS * 2,
                Constants.BALL_RADIUS * 2,
                Constants.BALL_SPEED
        );
        this.radius = Constants.BALL_RADIUS;
        this.stuck = true;
        this.paddle = paddle;
        this.smoothX = x;
        this.smoothY = y;
    }

    /**
     * Update the ball position and check for wall collisions.
     */
    @Override
    public void update() {
        update(1.0 / 60.0); // Default for compatibility
    }

    /**
     * Update the ball position based on delta time and check for wall collisions.
     *
     * @param deltaTime time elapsed from last update
     */
    @Override
    public void update(double deltaTime) {
        if (stuck) {
            // Ball sticks to paddle
            x = paddle.getCenterX() - radius;
            y = paddle.getY() - radius * 2;
            smoothX = x;
            smoothY = y;
        } else {
            // Smooth movement with delta time
            double speedMultiplier = deltaTime * 60.0; // 60 FPS equivalent
            smoothX += velocityX * speedMultiplier;
            smoothY += velocityY * speedMultiplier;
            x = smoothX;
            y = smoothY;

            checkWallCollision();
        }
    }

    /**
     * Render the ball on the canvas with a radial gradient for 3D effect.
     * @param gc the graphics context used to draw the ball on the canvas
     */
    @Override
    public void render(GraphicsContext gc) {
        // Create a radial gradient for a 3D effect
        RadialGradient gradient = new RadialGradient(
                0, 0, 0.3, 0.3, 0.5, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.WHITE),
                new Stop(1, Constants.BALL_COLOR)
        );

        gc.setFill(gradient);
        gc.fillOval(x, y, radius * 2, radius * 2);
    }

    /**
     * Check for collisions with the walls and adjust position and velocity accordingly.
     */
    private void checkWallCollision() {
        // Left and right walls
        if (smoothX <= 0) {
            smoothX = 0;
            velocityX = Math.abs(velocityX);
        }
        if (smoothX + radius * 2 >= Constants.WINDOW_WIDTH) {
            smoothX = Constants.WINDOW_WIDTH - radius * 2;
            velocityX = -Math.abs(velocityX);
        }

        // Top wall
        if (smoothY <= 0) {
            smoothY = 0;
            velocityY = Math.abs(velocityY);
        }

        x = smoothX;
        y = smoothY;
    }

    /**
     * Launch the ball from the paddle at a random upward angle.
     */
    public void launch() {
        if (stuck) {
            stuck = false;
            // Launch at random angle upward
            double angle = Math.toRadians(-60 - Math.random() * 60);
            velocityX = speed * Math.cos(angle);
            velocityY = speed * Math.sin(angle);
        }
    }

    /**
     * Reset the ball to the paddle and set it to stuck state.
     */
    public void reset() {
        stuck = true;
        x = paddle.getCenterX() - radius;
        y = paddle.getY() - radius * 2;
        smoothX = x;
        smoothY = y;
        velocityX = 0;
        velocityY = 0;
    }

    /**
     * Reverse the ball's Y velocity (used for bouncing).
     */
    public void reverseY() {
        velocityY = -velocityY;
    }

    /**
     * Reverse the ball's X velocity (used for bouncing).
     */
    public void reverseX() {
        velocityX = -velocityX;
    }

    /**
     * Adjust the ball's angle based on where it hit the paddle.
     * @param paddleHitPosition position on the paddle where the ball hit (-1 to 1)
     */
    public void adjustAngle(double paddleHitPosition) {
        // paddleHitPosition: -1 (left edge) to 1 (right edge)
        double angle = paddleHitPosition * 60; // Max 60 degrees from vertical
        double currentSpeed = Math.sqrt(velocityX * velocityX + velocityY * velocityY);

        velocityX = currentSpeed * Math.sin(Math.toRadians(angle));
        velocityY = -Math.abs(currentSpeed * Math.cos(Math.toRadians(angle)));
    }

    /**
     * Increase the ball's speed up to a maximum limit.
     */
    public void increaseSpeed() {
        speed = Math.min(speed * 1.2, Constants.BALL_SPEED * 2);
        updateVelocity();
    }

    /**
     * Decrease the ball's speed down to a minimum limit.
     */
    public void decreaseSpeed() {
        speed = Math.max(speed * 0.8, Constants.BALL_SPEED * 0.5);
        updateVelocity();
    }

    /**
     * Update the velocity components based on the current speed.
     */
    private void updateVelocity() {
        double currentSpeed = Math.sqrt(velocityX * velocityX + velocityY * velocityY);
        if (currentSpeed > 0) {
            velocityX = (velocityX / currentSpeed) * speed;
            velocityY = (velocityY / currentSpeed) * speed;
        }
    }

    /**
     * Check if the ball is out of bounds (below the window).
     * @return true if the ball is out of bounds, false otherwise
     */
    public boolean isOutOfBounds() {
        return y > Constants.WINDOW_HEIGHT;
    }

    /**
     * Check if the ball is currently stuck to the paddle.
     * @return true if the ball is stuck, false otherwise
     */
    public boolean isStuck() {
        return stuck;
    }

    /**
     * Get the radius of the ball.
     * @return the radius of the ball
     */
    public int getRadius() {
        return radius;
    }
}