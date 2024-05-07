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
        if(p.mouseX < x + w && p.mouseX > x && p.mouseY < y + h && p.mouseY > y && !p.mousePressed){
            p.fill(125);
        }   else{
            p.fill(255);
        }
        p.rect(x,y,w,h);
        if(p.mouseX < x + w && p.mouseX > x && p.mouseY < y + h && p.mouseY > y && !p.mousePressed){
            p.fill(255);
        }   else{
            p.fill(0);
        }
        p.textSize(15);
        float w = p.textWidth(titel);
        p.text(titel,x + w/2,y + h/2 + 5);
        p.stroke(0);
    }

    public void mouseClickDetection(){
        if(p.mouseX < x + w && p.mouseX > x && p.mouseY < y + h && p.mouseY > y){
            p.method(action);
        }
    }
}