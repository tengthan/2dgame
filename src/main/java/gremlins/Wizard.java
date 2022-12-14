package gremlins;

import static java.lang.System.out;

import java.util.Vector;

import processing.core.PImage;

public class Wizard {
    private int speed = 2;
    private int map_width, map_height;
    private Vector2 location = new Vector2(20, 20);
    public Vector2 direction = Vector2.ZERO;
    final int image_size = 20;
    private int checkMargin = 19;
    boolean checkColision = false;

    public static final int HEIGHT = 20;
    public int width = 20;
    private String[][] mapPrint = new String[][] {};

    public Wizard(int x, int y, String mapPrint[][]) {
        this.mapPrint = mapPrint;
        this.map_height = mapPrint.length;
        this.map_width = mapPrint[0].length;
    }

    public void left() {
        this.direction = Vector2.LEFT;
    }

    public void right() {
        this.direction = Vector2.RIGHT;
    }

    public void up() {
        this.direction = Vector2.UP;
    }

    public void down() {
        this.direction = Vector2.DOWN;
    }

    public boolean canPass(Vector2[] checkPoints) {
        for (Vector2 v : checkPoints) {
            Vector2 new_loc = v.getAdded(this.direction);
            int x = (int) (new_loc.x / 20);
            int y = (int) (new_loc.y / 20);
            if ((mapPrint[y][x] == "X" || mapPrint[y][x] == "B")) {
                return false;
            }
            
        }
        return true;
    }

    public void draw(App app, PImage image) {
        Vector2[] checkPoints = new Vector2[2];
        if (direction == Vector2.RIGHT) {
            checkPoints[0] = location.getAdded(direction.getMultiplied(checkMargin));
            checkPoints[1] = checkPoints[0].getAdded(Vector2.DOWN.getMultiplied(checkMargin));
        } else if (direction == Vector2.LEFT) {
            checkPoints[0] = location;
            checkPoints[1] = checkPoints[0].getAdded(Vector2.DOWN.getMultiplied(checkMargin));
        } else if (direction == Vector2.UP) {
            checkPoints[0] = location;
            checkPoints[1] = checkPoints[0].getAdded(Vector2.RIGHT.getMultiplied(checkMargin));
        } else if (direction == Vector2.DOWN) {
            checkPoints[0] = location.getAdded(direction.getMultiplied(checkMargin));
            checkPoints[1] = checkPoints[0].getAdded(Vector2.RIGHT.getMultiplied(checkMargin));
        }
        if (checkPoints[0] != null && checkPoints[1] != null)
            if (canPass(checkPoints)) {
                location = location.getAdded(direction.getMultiplied(speed));
            }

        app.image(image, (int) location.x, (int) location.y, width, HEIGHT);
    }

}
