package gremlins;

import processing.core.PImage;

public class Wizard{
    private int x;
    private int y;

    private int xVel = 0;
    private int yVel = 0;
    private int up;
    private int down;
    private int speed = 2;

    boolean checkColision = false;

    public String movement = "up";
    
    public static final int HEIGHT = 20;
    public int width = 20;

    public Wizard(int x,int y, String mapPrint[][]) {
        this.x = x;
        this.y = y;
        collision(mapPrint);
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    // public void pressed(){
    //     if (this.checkColision == false){
    //         switch(this.movement){
    //             case "up":
    //                 this.yVel = -speed;
    //             case "down":
    //                 this.yVel = speed; 
    //             case "right":
    //                 this.xVel = speed;
    //             case "left":
    //                 this.xVel = -speed;
    //         }

    //     }
    // }
    public void left() {
        this.movement = "left";
        this.xVel = -speed;
    }

    public void right() {
        this.movement = "right";
        this.xVel = speed;
    }

    public void up(){
        this.movement = "up";
        this.yVel = -speed;
    }

    public void down(){
        this.movement = "down";
        this.yVel = speed; 
    }

    public void stop() {
        this.xVel = 0;
        this.yVel = 0;
    }

    public void collision(String mapPrint[][]){
        switch(this.movement){
            case "up":
            this.up = (this.y- 20)/20;
            if (mapPrint[this.x/20][this.up] == "X" || mapPrint[this.x/20][this.up] == "B"){
                this.checkColision= true;
                this.stop();
            }
            break;
            case "down":
            this.down = (this.y- speed +20)/20;
            if (mapPrint[this.x/20][this.down] == "X" || mapPrint[this.x/20][this.down] == "B"){
                this.checkColision=true;
                this.stop();
            }
            break;
        }
    }

    public void draw(App app , PImage image) {
        app.image(image,this.x,this.y,width, HEIGHT);
        System.out.println("dz");
        x += xVel;
        y += yVel;
        System.out.println(x);
        System.out.println(y);
    }

}
