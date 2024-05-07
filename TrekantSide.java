import processing.core.*;

public class TrekantSide extends Side{

    private PApplet p;

    private ButtonPicture backArrow;

    private float x1, x2, x3;
    private float y1, y2, y3;
    
    public TrekantSide(PApplet p, ButtonPicture bp, float x1, float x2, float x3, float y1, float y2, float y3, PImage b, float w, float h){
        super(p,b,w,h);
        this.p    = p;
        backArrow = bp;
        this.x1   = x1;
        this.x2   = x2;
        this.x3   = x3;
        this.y1   = y1;
        this.y2   = y2;
        this.y3   = y3;
    }

    public void displayTrekantSide(){
        super.displayBackground();
        backArrow.display();
        p.fill(255);
        p.println(x1 + ", " + x2 + ", " + x3 + ", " + y1 + ", " + y2 + ", " + y3);
        p.triangle(x1,y1,x2,y2,x3,y3);
    }

    public void handleButtonClicks(){
        backArrow.mouseClickDetection();
    }
}