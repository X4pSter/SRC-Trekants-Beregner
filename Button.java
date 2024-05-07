import processing.core.*;

public class Button{

    private PApplet p;
    
    private float  x,y,w,h;

    private float gapToTop,textSize;

    private String titel,action;

    public Button(PApplet p, float x, float y, float w, float h, String t, String a, float ts, float gt){
        this.p   = p;
        this.x   = x;
        this.y   = y;
        this.w   = w;
        this.h   = h;
        titel    = t;
        action   = a;
        textSize = ts;
        gapToTop = gt;
    }

    public void display(){
        p.textSize(textSize);
        if(w < p.textWidth(titel) + 15){
            w = p.textWidth(titel) + 15;
        }
        if(p.mouseX < x + w/2 && p.mouseX > x - w/2 && p.mouseY < y + h && p.mouseY > y && !p.mousePressed){
            p.fill(125);
        }   else{
            p.fill(255);
        }
        p.rect(x - w/2,y,w,h);
        if(p.mouseX < x + w/2 && p.mouseX > x - w/2 && p.mouseY < y + h && p.mouseY > y && !p.mousePressed){
            p.fill(255);
        }   else{
            p.fill(0);
        }
        float W = p.textWidth(titel);
        p.text(titel,x - w/2 + 5,y + gapToTop);
        p.textAlign(p.LEFT,p.TOP);
        p.stroke(0);
    }

    public void mouseClickDetection(){
        if(p.mouseX < x + w/2 && p.mouseX > x - w/2 && p.mouseY < y + h && p.mouseY > y){
            p.method(action);
        }
    }
}