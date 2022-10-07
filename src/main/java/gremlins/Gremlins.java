package gremlins;

import processing.core.PImage;

public class Gremlins{
    private int x;
    private int y;

    boolean checkColision = false;

    public String movement = "up";
    
    public static final int HEIGHT = 20;
    public int width = 20;

    public Gremlins() {
    }

    public void draw(App app , PImage image,int x,int y) {
        app.image(image,x,y,width, HEIGHT);
        System.out.println("dz");
        System.out.println(x);
        System.out.println(y);
    }

}
