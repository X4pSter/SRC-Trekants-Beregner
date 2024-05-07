import processing.core.*;

public class Button{

    private PApplet p;
    
    private float  x,y,w,h;

    private String titel,action;

    public Button(PApplet p, float x, float y, float w, float h, String t, String a){
        this.p = p;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        titel  = t;
        action = a;
    }

    public void display(){
        p.fill(255);
        p.rect(x,y,w,h);
        p.fill(0);
        p.textSize(15);
        float w = p.textwidth(titel);
        p.text(titel,x + w/2,y + h/2 + 5);
        p.stroke(0);
    }

    public void mouseClickDetection(){
        if(p.mousex < x + w && p.mousex > x && p.mousey < y + h && p.mousey > y){
            p.method(action);
        }
    }
}