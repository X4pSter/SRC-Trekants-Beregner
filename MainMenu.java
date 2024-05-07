import processing.core.*;

public class MainMenu extends Side{

    private PApplet p;

    private Button  teoriKnap,beregnerKnap;

    MainMenu(PApplet p, Button b1, Button b2, PImage b, float w, float h){
        super(p,b,w,h);
        this.p       = p;
        beregnerKnap = b1;
        teoriKnap    = b2;
    }

    public void mainMenuDisplay(){
        super.displayBackground();
        beregnerKnap.display();
        teoriKnap.display();
    }

    public void handleButtonClicks(){
        beregnerKnap.mouseClickDetection();
        teoriKnap.mouseClickDetection();
    }
}