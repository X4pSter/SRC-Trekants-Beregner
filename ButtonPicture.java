import processing.core.*;

public class ButtonPicture{

    private PApplet p;
    
    private float  x,y,w,h;

    private String action;

    private PImage image;

    public ButtonPicture(PApplet p, float x, float y, float w, float h, PImage i, String a){
        this.p = p;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        image  = i;
        action = a;
    }

    public void display(){
        if(p.mouseX < x + w && p.mouseX > x && p.mouseY < y + h && p.mouseY > y && !p.mousePressed){
            p.fill(125);
        }   else{
            p.fill(255);
        }
        p.rect(x,y,w,h);
        p.image(image,x,y,w,h);
        p.stroke(0);
    }

    public void mouseClickDetection(){
        if(p.mouseX < x + w && p.mouseX > x && p.mouseY < y + h && p.mouseY > y){
            p.method(action);
        }
    }
}