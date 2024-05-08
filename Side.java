import processing.core.*;

public class Side{

    private PApplet p;

    private PImage  background;

    private float   windowWidth,windowHeight;

    public Side(PApplet p, PImage bg, float w, float h){
        this.p       = p;
        background   = bg;
        windowWidth  = w;
        windowHeight = h;
    }

    public void displayBackground(){
        p.image(background,0,0,windowWidth,windowHeight);
    }
}