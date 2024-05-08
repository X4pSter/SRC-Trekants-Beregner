
import processing.core.*;

public class TrekantBeregner extends TrekantSide{

    private PApplet p;
    
    private Button sideA,sideB,sideC,vinkelA,vinkelB,vinkelC;

    TrekantBeregner(PApplet p, ButtonPicture bp, PImage bg, PImage t, float w, float h){
        super(p,bp,bg,t,w,h);
        this.p = p;

    }
}
