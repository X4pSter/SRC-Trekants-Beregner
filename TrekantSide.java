import processing.core.*;

public class TrekantSide extends Side{

    private PApplet p;

    private ButtonPicture backArrow;

    private PImage trekant;

    private float width,height;
    
    public TrekantSide(PApplet p, ButtonPicture bp, PImage bg, PImage t, float w, float h){
        super(p,bg,w,h);
        this.p    = p;
        backArrow = bp;
        trekant   = t;
        width     = w;
        height    = h;
    }

    public void displayTrekantSide(){
        super.displayBackground();
        backArrow.display();
        p.image(trekant,width/2 - trekant.width/2, 300);
    }

    public void handleButtonClicks(){
        backArrow.mouseClickDetection();
    }
}