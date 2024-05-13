import processing.core.*;

public class TrekantTeori extends TrekantSide{

    private PApplet p;

    private PImage sideA,sideB,sideC,vinkelA,vinkelB;

    public TrekantTeori(PApplet p, ButtonPicture bp, PImage bg, PImage t, float w, float h, Button b1, Button b2, ButtonRotate br, ButtonEllipse be1, ButtonEllipse be2, ButtonEllipse be3, PImage sA, PImage sB, PImage sC, PImage vA, PImage vB){
        super(p,bp,bg,t,w,h,b1,b2,br,be1,be2,be3);
        sideA = sA;
        sideB = sB;
        sideC = sC;
        vinkelA = vA;
        vinkelB = vB;
    }
}