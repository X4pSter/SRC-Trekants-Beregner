import processing.core.*;
import java.util.ArrayList;

public class TekstFelt{

    private PApplet p;

    private String tekst = "";

    private float x,y;
    private float w,h,oW;
    private float textSize;
    private float gapToTop;

    private ArrayList<String> characters;

    public TekstFelt(PApplet p, float x, float y, float w, float h, float ts, float g, ArrayList<String> c){
        this.p     = p;
        this.x     = x;
        this.y     = y;
        this.w     = w;
        this.h     = h;
        characters = c;
        textSize   = ts;
        gapToTop   = g;
        oW         = w;
    }

    public void handleCharacters(){
        for(int i = 0; i < characters.size(); i++){
            String temp = p.str(p.key);
            if(temp.equals(characters.get(i))){
                tekst = tekst + p.str(p.key);
                p.println(tekst);
            }
        }
        if(p.key == p.BACKSPACE){
            if(tekst.length() > 1){
                tekst = tekst.substring(0,tekst.length() - 1);
                p.println(tekst);
            } else{
                tekst = "";
                p.println(tekst);
            }
            if(p.textWidth(tekst) + 15 > oW){
                w = p.textWidth(tekst) + 15;
            } else{
                w = oW;
            }
        }
    }

    public void display(){
        p.textSize(textSize);
        if(w < p.textWidth(tekst) + 15){
            w = p.textWidth(tekst) + 15;
        }
        p.rectMode(p.CORNER);
        p.fill(255);
        p.rect(x,y,w,h);
        float W = p.textWidth(tekst);
        p.fill(0);
        p.textAlign(p.LEFT,p.TOP);
        p.text(tekst,x + 5,y + gapToTop);
        p.stroke(0);
    }

    public void setTekst(String t){
        tekst = t;
    }

    public String getTekst(){
        return(tekst);
    }
}