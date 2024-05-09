import processing.core.*;

public class ButtonRotate{

    private PApplet p;
    
    private float x,y,w,h;
    private float gapToTop,textSize;
    private float vinkel;

    private String titel,action;

    public ButtonRotate(PApplet p, float x, float y, float w, float h, String t, String a, float ts, float gt, float v){
        this.p   = p;
        this.x   = x;
        this.y   = y;
        this.w   = w;
        this.h   = h;
        titel    = t;
        action   = a;
        textSize = ts;
        gapToTop = gt;
        vinkel   = v;
    }

    public void display(){
        p.pushMatrix();
        p.translate(x,y);
        p.rotate(p.radians(-vinkel));
        p.textSize(textSize);
        if(w < p.textWidth(titel) + 15){
            w = p.textWidth(titel) + 15;
        }
        if(p.mouseX < x + w/2 && p.mouseX > x - w/2 && p.mouseY < y + h && p.mouseY > y && !p.mousePressed){
            p.fill(125);
        }   else{
            p.fill(255);
        }
        p.rect(0,0,w,h);
        if(p.mouseX < x + w/2 && p.mouseX > x - w/2 && p.mouseY < y + h && p.mouseY > y && !p.mousePressed){
            p.fill(255);
        }   else{
            p.fill(0);
        }
        float W = p.textWidth(titel);
        p.text(titel,x - w/2 + 5,y + gapToTop);
        p.textAlign(p.LEFT,p.TOP);
        p.stroke(0);
        p.popMatrix();
    }

    public void mouseClickDetection(){
        p.pushMatrix();
        p.translate(x,y);
        p.rotate(p.radians(-vinkel));
        // Apply inverse transformation to mouse coordinates
        float mouseXInverse = p.mouseX - x;
        float mouseYInverse = p.mouseY - y;
        // Apply inverse rotation
        float mouseXInverseRotated = mouseXInverse * p.cos(p.radians(-vinkel)) + mouseYInverse * p.sin(p.radians(-vinkel));
        float mouseYInverseRotated = -mouseXInverse * p.sin(p.radians(-vinkel)) + mouseYInverse * p.cos(p.radians(-vinkel));
        // Check for mouse click
        if(mouseXInverseRotated < w/2 && mouseXInverseRotated > -w/2 && mouseYInverseRotated < h && mouseYInverseRotated > 0 && p.mousePressed){
           p.method(action);
        }
        p.popMatrix();
    }

}