import processing.core.*;
import java.util.ArrayList;

public class TrekantSide extends Side{

    private PApplet p;

    private ButtonPicture backArrow;

    private PImage trekant;

    private float width,height;

    private ArrayList<Button>        buttons1 = new ArrayList<Button>();
    private ArrayList<ButtonEllipse> buttons2 = new ArrayList<ButtonEllipse>();

    private ButtonRotate sideC;
    
    public TrekantSide(PApplet p, ButtonPicture bp, PImage bg, PImage t, float w, float h, Button b1, Button b2, ButtonRotate br, ButtonEllipse be1, ButtonEllipse be2, ButtonEllipse be3){
        super(p,bg,w,h);
        this.p    = p;
        backArrow = bp;
        trekant   = t;
        width     = w;
        height    = h;
        buttons1.add(b1);
        buttons1.add(b2);
        sideC   = br;
        buttons2.add(be1);
        buttons2.add(be2);
        buttons2.add(be3);
    }

    public void displayTrekantSide(){
        super.displayBackground();
        backArrow.display();
        p.image(trekant,width/2 - trekant.width/2, 300);
        for(int i = 0; i < buttons2.size(); i++){
            ButtonEllipse temp = buttons2.get(i);
            temp.display();
        }
        
        for(int i = 0; i < buttons1.size(); i++){
            Button temp = buttons1.get(i);
            temp.display();
        }
        sideC.display();
    }

    public void handleButtonClicks(){
        backArrow.mouseClickDetection();
        for(int i = 0; i < buttons1.size(); i++){
            Button temp = buttons1.get(i);
            temp.mouseClickDetection();
        }
        
        for(int i = 0; i < buttons2.size(); i++){
            ButtonEllipse temp = buttons2.get(i);
            temp.mouseClickDetection();
        }
        sideC.mouseClickDetection();
    }
}