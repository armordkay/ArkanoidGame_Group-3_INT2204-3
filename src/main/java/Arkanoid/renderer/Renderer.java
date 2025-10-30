package Arkanoid.renderer;

import Arkanoid.manager.GameManager;
import Arkanoid.manager.ScoreManager;
import Arkanoid.model.*;
import Arkanoid.util.Constants;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Renderer {
    private GraphicsContext gc;

    /**
     * constructor.
     * @param gc
     */
    public Renderer(GraphicsContext gc) {
        this.gc = gc;
    }

    /**
     * contain all render screen logic.
     * @param gameManager
     */
    public void render(GameManager gameManager) {

        // Clear screen
        gc.setFill(Constants.BACKGROUND_COLOR);
        gc.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        GameState state = gameManager.getCurrentState();

        switch (state) {
            case MENU:
                renderMenu();
                break;
            case PLAYING:
            case PAUSED:
                renderGame(gameManager);
                if (state == GameState.PAUSED) {
                    renderPauseOverlay();
                }
                break;
            case GAME_OVER:
                renderGame(gameManager);
                renderGameOver(gameManager.getScoreManager());
                break;
            case LEVEL_COMPLETE:
                renderGame(gameManager);
                renderLevelComplete(gameManager.getScoreManager());
                break;
        }
    }

    /**
     * game screen.
     * @param gameManager
     */

    private void renderGame(GameManager gameManager) {
        // Render bricks
        for (Brick brick : gameManager.getBricks()) {
            brick.render(gc);
        }

        // Render power-ups
        for (PowerUps powerUp : gameManager.getPowerUps()) {
            powerUp.render(gc);
        }

        // Render paddle
        gameManager.getPaddle().render(gc);

        // Render balls
        for (Ball ball : gameManager.getBalls()) {
            ball.render(gc);
        }

        // Render UI
        renderUI(gameManager.getScoreManager());
    }

    private void renderUI(ScoreManager scoreManager) {
        gc.setFill(Constants.UI_TEXT_COLOR);
        gc.setFont(Font.font("Arial", Constants.UI_FONT_SIZE));

        // Score
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText("Score: " + scoreManager.getScore(), 10, 25);

        // High Score
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("High Score: " + scoreManager.getHighScore(), Constants.WINDOW_WIDTH / 2.0, 25);

        // Lives and Level
        gc.setTextAlign(TextAlignment.RIGHT);
        gc.fillText("Lives: " + scoreManager.getLives() + "  Level: " + scoreManager.getLevel(),
                Constants.WINDOW_WIDTH - 10, 25);
    }

    /**
     * Renders the main menu screen with game title, controls, and power-up descriptions.
     */

    private void renderMenu() {
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font("Arial", 60));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("ARKANOID", Constants.WINDOW_WIDTH / 2.0, 200);

        gc.setFont(Font.font("Arial", 24));
        gc.fillText("Press SPACE to Start", Constants.WINDOW_WIDTH / 2.0, 300);
        gc.fillText("Use LEFT/RIGHT arrows to move", Constants.WINDOW_WIDTH / 2.0, 350);
        gc.fillText("Press P to Pause", Constants.WINDOW_WIDTH / 2.0, 400);

        // Draw power-up legend
        gc.setFont(Font.font("Arial", 16));
        gc.fillText("Power-ups:", Constants.WINDOW_WIDTH / 2.0, 470);

        int y = 495;
        String[] powerUpInfo = {
                "E - Expand Paddle",
                "S - Shrink Paddle",
                "+ - Speed Up Ball",
                "- - Slow Down Ball",
                "L - Extra Life",
                "M - Multi Ball"
        };

        for (String info : powerUpInfo) {
            gc.fillText(info, Constants.WINDOW_WIDTH / 2.0, y);
            y += 20;
        }
    }

    /**
     * Renders a semi-transparent overlay with the "PAUSED" message.
     */

    private void renderPauseOverlay() {
        gc.setFill(Color.rgb(0, 0, 0, 0.7));
        gc.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        gc.setFill(Color.WHITE);
        gc.setFont(Font.font("Arial", 48));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("PAUSED", Constants.WINDOW_WIDTH / 2.0, Constants.WINDOW_HEIGHT / 2.0);

        gc.setFont(Font.font("Arial", 20));
        gc.fillText("Press P to Resume", Constants.WINDOW_WIDTH / 2.0, Constants.WINDOW_HEIGHT / 2.0 + 50);
    }

    /**
     * lose screen.
     * @param scoreManager
     */

    private void renderGameOver(ScoreManager scoreManager) {
        gc.setFill(Color.rgb(0, 0, 0, 0.8));
        gc.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        gc.setFill(Color.RED);
        gc.setFont(Font.font("Arial", 60));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("GAME OVER", Constants.WINDOW_WIDTH / 2.0, 250);

        gc.setFill(Color.WHITE);
        gc.setFont(Font.font("Arial", 30));
        gc.fillText("Final Score: " + scoreManager.getScore(), Constants.WINDOW_WIDTH / 2.0, 320);
        gc.fillText("High Score: " + scoreManager.getHighScore(), Constants.WINDOW_WIDTH / 2.0, 360);

        gc.setFont(Font.font("Arial", 20));
        gc.fillText("Press SPACE to Try Again", Constants.WINDOW_WIDTH / 2.0, 420);
        gc.fillText("Press ESC for Menu", Constants.WINDOW_WIDTH / 2.0, 450);
    }

    /**
     * win screen.
     * @param scoreManager
     */

    private void renderLevelComplete(ScoreManager scoreManager) {
        gc.setFill(Color.rgb(0, 0, 0, 0.8));
        gc.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        gc.setFill(Color.GOLD);
        gc.setFont(Font.font("Arial", 60));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("LEVEL COMPLETE!", Constants.WINDOW_WIDTH / 2.0, 250);

        gc.setFill(Color.WHITE);
        gc.setFont(Font.font("Arial", 30));
        gc.fillText("Score: " + scoreManager.getScore(), Constants.WINDOW_WIDTH / 2.0, 320);

        gc.setFont(Font.font("Arial", 20));
        gc.fillText("Press SPACE for Next Level", Constants.WINDOW_WIDTH / 2.0, 380);
    }
}