import processing.core.*;

public class TrekantTeori extends TrekantSide{

    private PApplet p;

    private PImage[] pictures = new PImage[5];

    public TrekantTeori(PApplet p, ButtonPicture bp, PImage bg, PImage t, float w, float h, Button b1, Button b2, ButtonRotate br, ButtonEllipse be1, ButtonEllipse be2, ButtonEllipse be3, PImage sA, PImage sB, PImage sC, PImage vA, PImage vB){
        super(p,bp,bg,t,w,h,b1,b2,br,be1,be2,be3);
        this.p = p;
        pictures[0] = sA;
        pictures[1] = sB;
        pictures[2] = sC;
        pictures[3] = vA;
        pictures[4] = vB;
    }

    public void display(int sideSelected){
        super.displayTrekantSide();
        int pictureNumber = sideSelected - 1;
        if(pictureNumber >= 0){
            PImage temp = pictures[pictureNumber];
            p.image(temp,850,600,280,360);
        }
    }
}