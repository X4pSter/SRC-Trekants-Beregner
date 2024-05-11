import processing.core.*;

public class ButtonRotate{

    private PApplet p;
    
    private float x,y,w,h;
    private float gapToTop,textSize;
    private float vinkel;

    private String titel,action;

    public ButtonRotate(PApplet p, float x, float y, float w, float h, String t, String a, float ts, float gt, float v){
        this.p   = p;
        this.w   = w;
        this.x   = x;
        this.y   = y;
        this.h   = h;
        titel    = t;
        action   = a;
        textSize = ts;
        gapToTop = gt;
        vinkel   = v;
    }

    public void display(){
        float mouseXInverse = p.mouseX - x;
        float mouseYInverse = p.mouseY - y;
        float mouseXRotated = mouseXInverse * p.cos(-vinkel) - mouseYInverse * p.sin(-vinkel) + x;
        float mouseYRotated = mouseXInverse * p.sin(-vinkel) + mouseYInverse * p.cos(-vinkel) + y;
        p.pushMatrix();
        p.translate(x,y);
        p.rotate(p.radians(-vinkel));
        p.textSize(textSize);
        if(w < p.textWidth(titel) + 15){
            w = p.textWidth(titel) + 15;
        }
        if(mouseXRotated < x && mouseXRotated > x - w && mouseYRotated < y + h/2 && mouseYRotated > y - h && !p.mousePressed){
            p.fill(125);
        }   else{
            p.fill(255);
        }
        p.rect(0,0 - h/2,w,h);
        if(mouseXRotated < x && mouseXRotated > x - w && mouseYRotated < y + h/2 && mouseYRotated > y - h && !p.mousePressed){
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

    public void mouseClickDetection() {
        float mouseXInverse = p.mouseX - x;
        float mouseYInverse = p.mouseY - y;
        float mouseXRotated = mouseXInverse * p.cos(-vinkel) - mouseYInverse * p.sin(-vinkel) + x;
        float mouseYRotated = mouseXInverse * p.sin(-vinkel) + mouseYInverse * p.cos(-vinkel) + y;
        if(mouseXRotated < x && mouseXRotated > x - w && mouseYRotated < y + h/2 && mouseYRotated > y - h){
            System.out.println("Button clicked! Action: " + action);
        }
    }


}