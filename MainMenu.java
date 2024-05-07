import processing.core.*;

public class MainMenu{

    private PApplet p;

    private PImage  background;

    private Button  teoriKnap,beregnerKnap;

    private float   windowWidth,windowHeight;

    MainMenu(PApplet p, Button b1, Button b2, PImage b, float w, float h){
        this.p       = p;
        beregnerKnap = b1;
        teoriKnap    = b2;
        background   = b;
        windowWidth  = w;
        windowHeight = h;
    }

    public void mainMenuDisplay(){
        p.image(background,0,0,windowWidth,windowHeight);
        beregnerKnap.display();
        teoriKnap.display();
    }

    public void handleButtonClicks(){
        beregnerKnap.mouseClickDetection();
        teoriKnap.mouseClickDetection();
    }
}