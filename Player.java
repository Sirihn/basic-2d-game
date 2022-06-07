import java.awt.event.KeyEvent;

public class Player extends GameObject {

    // filename of the image used to represent the player
    private static String filename = "images/player2.png";
    // keep track of the player's score
    private int score;

    public Player() {
        super(filename, 0, 0);
        score = 0;
    }

    public void keyPressed(KeyEvent e) {
        // every keyboard get has a certain code. get the value of that code from the
        // keyboard event so that we can compare it to KeyEvent constants
        int key = e.getKeyCode();

        // depending on which arrow key was pressed, we're going to move the player by
        // one whole tile for this input
        if (key == KeyEvent.VK_W) {
            getPos().translate(0, -1);
        }
        if (key == KeyEvent.VK_D) {
            getPos().translate(1, 0);
        }
        if (key == KeyEvent.VK_S) {
            getPos().translate(0, 1);
        }
        if (key == KeyEvent.VK_A) {
            getPos().translate(-1, 0);
        }
    }

    public void tick() {
        // this gets called once every tick, before the repainting process happens.
        // so we can do anything needed in here to update the state of the player.

        // prevent the player from moving off the edge of the board sideways
        // player wraps to other side
        if (getPos().x < 0) {
            getPos().x = Board.COLUMNS - 1;
        } else if (getPos().x >= Board.COLUMNS) {
            getPos().x = 0;
        }
        // prevent the player from moving off the edge of the board vertically
        if (getPos().y < 0) {
            getPos().y = Board.ROWS - 1;
        } else if (getPos().y >= Board.ROWS) {
            getPos().y = 0;
        }
    }

    public String getScore() {
        return String.valueOf(score);
    }

    public void addScore(int amount) {
        score += amount;
    }

}
