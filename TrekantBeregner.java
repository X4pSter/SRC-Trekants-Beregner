import processing.core.*;

public class TrekantBeregner extends TrekantSide{

    private PApplet p;

    private TekstFelt tekstFelt;

    private Button assignValue;

    public float sideAL,sideBL,sideCL;
    public float vinkelAS,vinkelBS;

    private int valueSelected;

    TrekantBeregner(PApplet p, ButtonPicture bp, PImage bg, PImage t, float w, float h, Button b1, Button b2, ButtonRotate br, ButtonEllipse be1, ButtonEllipse be2, ButtonEllipse be3, TekstFelt tf, Button aV){
        super(p,bp,bg,t,w,h,b1,b2,br,be1,be2,be3);
        this.p  = p;
        tekstFelt = tf;
        assignValue = aV;
    }

    public void display(){
        super.displayTrekantSide(); 
        p.textSize(25);
        p.textAlign(p.LEFT,p.BOTTOM);
        p.fill(0);
        p.text("Side a længde: " + sideAL,50,200);
        p.text("Side b længde: " + sideBL,50,230);
        p.text("Side c længde: " + sideCL,50,260);
        p.text("Vinkel A størrelse: " + vinkelAS + "°",50,290);
        p.text("Vinkel B størrelse: " + vinkelBS + "°",50,320);
        tekstFelt.display();
        assignValue.display();
    }

    public void handleButtonClicks(){
        super.handleButtonClicks();
        assignValue.mouseClickDetection();
    }

    public void handleKeyClicks(){
        tekstFelt.handleCharacters();
    }
}
