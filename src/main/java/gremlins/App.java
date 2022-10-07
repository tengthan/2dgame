package gremlins;

import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONObject;
import processing.data.JSONArray;

import java.util.ArrayList;

import processing.event.KeyEvent;
import java.util.Random;
import java.io.*;


public class App extends PApplet {

    public static final int WIDTH = 720;
    public static final int HEIGHT = 720;
    public static final int SPRITESIZE = 20;
    public static final int BOTTOMBAR = 60;

    public static final int FPS = 60;

    public static final Random randomGenerator = new Random();

    public String configPath;
    
    public PImage brickwall;
    public PImage stonewall;
    public PImage gremlin; 
    public PImage up,down,left,right;

    public MapDisplay mapdisplay= new MapDisplay(this);
    public Wizard wizard = new Wizard(20,20,mapdisplay.mapPrint);
    Gremlins[] gremlinsArray= new Gremlins[];


    public App() {
        this.configPath = "config.json";
    }
    
    /**
     * Initialise the setting of the window size.
    */
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    /**
     * Load all resources such as images. Initialise the elements such as the player, enemies and map elements.
    */
    public void setup() {
        frameRate(FPS);

        // Load images during setup
        this.stonewall = loadImage(this.getClass().getResource("stonewall.png").getPath().replace("%20", " "));
        this.brickwall = loadImage(this.getClass().getResource("brickwall.png").getPath().replace("%20", " "));
        this.up = loadImage(this.getClass().getResource("wizard2.png").getPath().replace("%20", " "));
        this.down = loadImage(this.getClass().getResource("wizard3.png").getPath().replace("%20", " "));
        this.left = loadImage(this.getClass().getResource("wizard0.png").getPath().replace("%20", " "));
        this.right = loadImage(this.getClass().getResource("wizard1.png").getPath().replace("%20", " "));
        this.gremlin = loadImage(this.getClass().getResource("gremlin.png").getPath().replace("%20", " "));
        //this.slime = loadImage(this.getClass().getResource("slime.png").getPath().replace("%20", " "));
        //this.fireball = loadImage(this.getClass().getResource("fireball.png").getPath().replace("%20", " "));

        JSONObject conf = loadJSONObject(new File(this.configPath));


    }

    /**
     * Receive key pressed signal from the keyboard.
    */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == 37) { //left arrow
            wizard.left();
        } else if (key == 39) { //right arrow
            wizard.right();
        }else if (key == 38) { //right arrow
            wizard.up();
        }else if (key == 40) { //right arrow
            wizard.down();
        } else if (key == 65) { //a
            wizard.left();
        } else if (key == 68) { //d
            wizard.right();
        }
    }
    /**
     * Receive key released signal from the keyboard.
    */
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == 37 || key == 39|| key == 38 || key == 40) {
            wizard.stop();
        } else if (key == 65 || key == 68) {
            wizard.stop();
        }
    }

    /**
     * Draw all elements in the game by current frame. 
	 */
    public void direction(){
        switch(wizard.movement){
            case "up":
                wizard.draw(this,this.up);
                break;
            case "down":
                wizard.draw(this,this.down);
                break;
            case "left":
                wizard.draw(this,this.left);
                break;
            case "right":
                wizard.draw(this,this.right);
                break;
        }

    }
    public void draw() {
        background(200);
        mapdisplay.draw(this, this.brickwall, this.stonewall);
        direction();
    
    }

    public static void main(String[] args) {
        PApplet.main("gremlins.App");
    }
}
