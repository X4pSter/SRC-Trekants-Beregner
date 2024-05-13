import processing.core.*;

public class TrekantBeregner extends TrekantSide{

    private PApplet p;

    private TekstFelt tekstFelt;

    private Button assignValue;
    private Button beregnSider;

    public float sideAL,sideBL,sideCL;
    public float vinkelAS,vinkelBS;
    public float vinkelCS = 90;

    private int valueSelected;

    private String[] valgtSide = new String[5];

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
    //tjek calculate til sider for fejl
    public void calculateSideA(){
        if(sideBL > 0 && sideCL > 0 && vinkelAS <= 0 && vinkelBS <= 0){
            sideAL = p.sqrt((sideCL*sideCL) - (sideBL*sideBL));
        } else if(sideBL <= 0 && sideCL > 0 && vinkelAS > 0 && vinkelBS <= 0){
            sideAL = p.sin(p.radians(vinkelAS))*sideCL;
        } else if(sideBL <= 0 && sideCL > 0 && vinkelAS <= 0 && vinkelBS > 0){
            sideAL = p.cos(p.radians(vinkelBS))*sideCL;
        } else if(sideBL > 0 && sideCL <= 0 && vinkelAS > 0 && vinkelBS <= 0){
            sideAL = p.tan(p.radians(vinkelAS))*sideBL;
        } else if(sideBL > 0 && sideCL <= 0 && vinkelAS <= 0 && vinkelBS > 0){
            sideAL = sideBL/p.tan(p.radians(vinkelBS));
        }
    }

    public void calculateSideB(){
        if(sideAL > 0 && sideCL > 0 && vinkelAS <= 0 && vinkelBS <= 0){
            sideBL = p.sqrt((sideCL*sideCL) - (sideAL*sideAL));
        } else if(sideAL <= 0 && sideCL > 0 && vinkelAS > 0 && vinkelBS <= 0){
            sideBL = p.sin(p.radians(vinkelAS))*sideCL;
        } else if(sideAL > 0 && sideCL > 0 && vinkelAS <= 0 && vinkelBS <= 0)
    }

    public void calculateSideC(){
        if(sideAL > 0 && side BL > 0 && vinkelAS <= 0 && vinkelBS <= 0){
            sideCL = p.sqrt((sideAL*sideAL) + (sideBL*sideBL));
        } else if(sideAL > 0 && side BL <= 0 && vinkelAS > 0 && vinkelBS <= 0){
            sideCL = sideAL/p.sin(p.radians(vinkelAS));
        } else if(sideAL <= 0 && side BL > 0 && vinkelAS <= 0 && vinkelBS > 0){
            sideCL = sideBL/p.sin(p.radians(vinkelBS));
        } else if(sideAL > 0 && side BL <= 0 && vinkelAS <= 0 && vinkelBS > 0){
            sideCL = sideAL/p.cos(p.radians(vinkelBS));
        } else if(sideAL <= 0 && side BL > 0 && vinkelAS > 0 && vinkelBS <= 0){
            siceCL = sideBL/p.cos(p.radians(vinkelAS));
        }
    }

    public void calculateVinkelA(){
    
    }

    public void calculateVinkelB(){
    
    }

    void sideSelected(int vS, boolean tBS){
        if(vS > 0){
            String temp = valgtSide[vS - 1];
            if(tBS){
                p.text(temp,850,680);
            } 
        }
    }
}

