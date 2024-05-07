import processing.core.*;

public class TrekantSide{

    private PApplet p;

    private ButtonPicture backArrow;

    private float x1, x2, x3;
    private float y1, y2, y3;
    
    public TrekantSide(PApplet p, ButtonPicture bp, float x1, float x2, float x3, float y1, float y2, float y3){
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
        backArroy.display();
        p.triangle(x1,y1,x2,y2,x3,y3);
    }
}