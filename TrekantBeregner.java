import processing.core.*;

public class TrekantBeregner extends TrekantSide{

    private PApplet p;

    private TekstFelt tekstFelt;

    private Button assignValue;
    private Button beregnSider;

    private float sideAL,sideBL,sideCL;
    private float vinkelAS,vinkelBS;
    private float vinkelCS = 90;

    private int sideSelected;

    private String[] valgtSide = new String[5];

    private boolean nan;

    TrekantBeregner(PApplet p, ButtonPicture bp, PImage bg, PImage t, float w, float h, Button b1, Button b2, ButtonRotate br, ButtonEllipse be1, ButtonEllipse be2, ButtonEllipse be3, TekstFelt tf, Button aV, Button bS){
        super(p,bp,bg,t,w,h,b1,b2,br,be1,be2,be3);
        this.p  = p;
        tekstFelt = tf;
        assignValue = aV;
        beregnSider = bS;
        valgtSide[0] = "Side a valgt";
        valgtSide[1] = "Side b valgt";
        valgtSide[2] = "Side c valgt";
        valgtSide[3] = "Vinkel A valgt";
        valgtSide[4] = "Vinkel B valgt";
    }

    public void display(){
        super.displayTrekantSide(); 
        p.textSize(25);
        p.textAlign(p.LEFT,p.BOTTOM);
        p.fill(0);
        p.text("Side a længde: " + sideAL,50,200);
        p.text("Side b længde: " + sideBL,50,230);
        p.text("Side c længde: " + sideCL,50,260);
        p.text("Vinkel A størrelse: " + vinkelAS + "°",50,290);
        p.text("Vinkel B størrelse: " + vinkelBS + "°",50,320);
        p.text("Vinkel C størrelse: " + vinkelCS + "°",50,350);
        tekstFelt.display();
        assignValue.display();
        beregnSider.display();
        if(nan){
            p.fill(0);
            p.text("Ikke en gyldig trekant",850,835);
        }
    }

    public void handleButtonClicks(){
        super.handleButtonClicks();
        assignValue.mouseClickDetection();
        beregnSider.mouseClickDetection();
    }

    public void handleKeyClicks(){
        tekstFelt.handleCharacters();
    }

    public void calculate(){
        sideCL = p.sqrt((sideAL*sideAL) + (sideBL*sideBL));
        vinkelAS = p.degrees(p.atan(sideAL/sideBL));
        vinkelBS = p.degrees(p.atan(sideBL/sideAL));

    }

    public void calculateSideA(){
        if(sideBL > 0 && sideCL > 0){
            sideAL = p.sqrt((sideCL*sideCL) - (sideBL*sideBL));
            p.println(sideAL);
        } else if(sideCL > 0 && vinkelAS > 0){
            sideAL = p.sin(p.radians(vinkelAS))*sideCL;
        } else if(sideCL > 0 && vinkelBS > 0){
            sideAL = p.cos(p.radians(vinkelBS))*sideCL;
        } else if(sideBL > 0 && vinkelAS > 0){
            sideAL = p.tan(p.radians(vinkelAS))*sideBL;
        } else if(sideBL > 0 && vinkelBS > 0){
            sideAL = sideBL/p.tan(p.radians(vinkelBS));
        }
        if(Float.isNaN(sideAL) || sideAL < 0){
            nan = true;
            sideAL = 0;
        } else{
            nan = false;
        }
    }

    public void calculateSideB(){
        if(sideAL > 0 && sideCL > 0){
            sideBL = p.sqrt((sideCL*sideCL) - (sideAL*sideAL));
        } else if(sideCL > 0 && vinkelAS > 0){
            sideBL = p.sin(p.radians(vinkelBS))*sideCL;
        } else if(sideAL > 0 && sideCL > 0){
            sideBL = p.cos(p.radians(vinkelAS))*sideCL;
        } else if(sideAL > 0 && vinkelBS > 0){
            sideBL = p.tan(p.radians(vinkelBS))*sideCL;
        } else if(sideAL > 0 && vinkelAS > 0){
            sideBL = sideAL/p.tan(p.radians(vinkelAS));
        }
        if(Float.isNaN(sideBL) || sideBL < 0){
            nan = true;
            sideBL = 0;
        } else{
            nan = false;
        }
    }

    public void calculateSideC(){
        if(sideAL > 0 && sideBL > 0){
            sideCL = p.sqrt((sideAL*sideAL) + (sideBL*sideBL));
        } else if(sideAL > 0 && vinkelAS > 0){
            sideCL = sideAL/p.sin(p.radians(vinkelAS));
        } else if(sideBL > 0 && vinkelBS > 0){
            sideCL = sideBL/p.sin(p.radians(vinkelBS));
        } else if(sideAL > 0 && vinkelBS > 0){
            sideCL = sideAL/p.cos(p.radians(vinkelBS));
        } else if(sideBL > 0 && vinkelAS > 0){
            sideCL = sideBL/p.cos(p.radians(vinkelAS));
        }
        if(Float.isNaN(sideCL) || sideCL < 0){
            nan = true;
            sideCL = 0;
        } else{
            nan = false;
        }
    }

    public void calculateVinkelA(){
        if(vinkelBS > 0){
            vinkelAS = 180 - (vinkelBS + 90);
        } else if(sideAL > 0 && sideCL > 0){
            vinkelAS = p.degrees(p.asin(sideAL/sideCL));
        } else if(sideBL > 0 && sideCL > 0){
            vinkelAS = p.degrees(p.acos(sideBL/sideCL));
        } else if(sideAL > 0 && sideBL > 0){
            vinkelAS = p.degrees(p.atan(sideAL/sideBL));
        }
        if(Float.isNaN(vinkelAS) || vinkelAS < 0){
            nan = true;
            vinkelAS = 0;
        } else{
            nan = false;
        }
    }

    public void calculateVinkelB(){
        if(vinkelAS > 0){
            vinkelBS = 180 - (vinkelAS - 90);
        } else if(sideBL > 0 && sideCL > 0){
            vinkelBS = p.degrees(p.asin(sideBL/sideCL));
        } else if(sideAL > 0 && sideCL > 0){
            vinkelBS = p.degrees(p.acos(sideAL/sideCL));
        } else if(sideAL > 0 && sideBL > 0){
            vinkelBS = p.degrees(p.atan(sideBL/sideAL));
        }
        if(Float.isNaN(vinkelBS) || vinkelBS < 0){
            nan = true;
            vinkelAS = 0;
        } else{
            nan = false;
        }
    }

    public void sideSelected(int vS, int mS){
        if(vS > 0){
            String temp = valgtSide[vS - 1];
            if(mS == 2){
                p.fill(0);
                p.text(temp,850,665);
            } 
        }
    }

    public void setSideAL(float n){
        sideAL = n;
    }

    public float getSideAL(){
        return(sideAL);
    }

    public void setSideBL(float n){
        sideBL = n;
    }

    public float getSideBL(){
        return(sideBL);
    }

    public void setSideCL(float n){
        sideCL = n;
    }

    public float getSideCL(){
        return(sideCL);
    }

    public void setVinkelAS(float n){
        vinkelAS = n;
    }

    public float getVinkelAS(){
        return(vinkelAS);
    }

    public void setVinkelBS(float n){
        vinkelBS = n;
    }

    public float getVinkelBS(){
        return(vinkelBS);
    }
}

