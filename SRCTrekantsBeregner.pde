Button knapTrekantBeregner,knapTrekantTeori;
Button sideA,sideB;
Button assignValue;
Button beregnSider;

ButtonEllipse vinkelA,vinkelB,vinkelC;

ButtonRotate sideC;

ButtonPicture returnArrow;

MainMenu mainMenu;

TrekantBeregner beregnerSide;

TrekantTeori teoriSide;

float buttonW = 100,buttonH = 90;
float ellipseHeight = 15, ellipseWidth = 15;

TekstFelt tekstFelt;

ArrayList<String> numbers = new ArrayList<String>();

int sideSelected, menuSelected;

void setup(){
    fullScreen();
    frameRate(60);

    menuSelected = 1;

    for(int i = 0; i <= 9; i++){
        numbers.add(str(i));
    }

    numbers.add(".");

    sideA = new Button(this,1156,534 - 206 + ellipseHeight/2,2.5,206 - ellipseHeight," ","selectSideA",0.001,0.001);
    sideB = new Button(this,766 + 195,529,390 - ellipseWidth,10," ","selectSideB",10,10);
    sideC = new ButtonRotate(this,766 + ellipseWidth/2,529,441 - ellipseWidth,10," ","selectSideC",10,10,27.785);

    vinkelA = new ButtonEllipse(this,766,534,ellipseWidth,ellipseHeight," ","selectVinkelA",0.01,0.01);
    vinkelB = new ButtonEllipse(this,1156,328,ellipseWidth,ellipseHeight," ","selectVinkelB",0.01,0.01);
    vinkelC = new ButtonEllipse(this,1156,534,ellipseWidth,ellipseHeight," ","nothing",0.01,0.01);
    
    knapTrekantBeregner = new Button(this,width/2,400,buttonW,buttonH,"Trekants beregner","selectTrekantBeregner",60,20);
    knapTrekantTeori    = new Button(this,width/2,550,buttonW,buttonH,"Teori om trekanter","selectTrekantTeori",60,20);
    returnArrow         = new ButtonPicture(this,50,50,50,50,loadImage("returnArrow.png"),"selectMainMenu");

    tekstFelt = new TekstFelt(this,850,600,50,50,43,10,numbers);
    assignValue = new Button(this,923,700,50,50,"Assign value","assignValues",25,10);
    beregnSider = new Button(this,896,770,50,50,"Beregn","calculate",25,10);

    mainMenu     = new MainMenu(this,knapTrekantBeregner,knapTrekantTeori,loadImage("background2.png"),width,height);
    beregnerSide = new TrekantBeregner(this,returnArrow,loadImage("background2.png"),loadImage("retVinkletTrekant.png"),width,height,sideA,sideB,sideC,vinkelA,vinkelB,vinkelC,tekstFelt,assignValue,beregnSider);
    teoriSide    = new TrekantTeori(this,returnArrow,loadImage("background2.png"),loadImage("retVinkletTrekant.png"),width,height,sideA,sideB,sideC,vinkelA,vinkelB,vinkelC,loadImage("Side_a.png"),loadImage("Side_b.png"),loadImage("Side_c.png"),loadImage("Vinkel_A.png"),loadImage("Vinkel_B.png"));
}

void draw(){
    if(menuSelected == 1){
        mainMenu.mainMenuDisplay();
        String titel = "Alt om retvinklede trekanter";
        float size = textWidth(titel);
        fill(0);
        text(titel,width/2 - size/2,200);
    }
    if(menuSelected == 2){
        beregnerSide.display();
    }
    if(menuSelected == 3){
        teoriSide.display(sideSelected);
    }
    sideSelected(sideSelected);
    textSize(70);
}

void mousePressed(){
    if(menuSelected == 1){
        mainMenu.handleButtonClicks();
    }
    if(menuSelected == 2){
        beregnerSide.handleButtonClicks();
    }
    if(menuSelected == 3){
        teoriSide.handleButtonClicks();
    }
}

void keyPressed(){
    beregnerSide.handleKeyClicks();
}

void selectMainMenu(){
    menuSelected = 1;
}

void selectTrekantBeregner(){
    menuSelected = 2;
}

void selectTrekantTeori(){
    menuSelected = 3;
}

void nothing(){
    
}

void assignValues(){
    String temp = "";
    if(!temp.equals(tekstFelt.tekst)){
        if(sideSelected == 1){
            beregnerSide.setSideAL(float(tekstFelt.getTekst()));
            tekstFelt.setTekst("0");
        }
        if(sideSelected == 2){
            beregnerSide.setSideBL(float(tekstFelt.getTekst()));
            tekstFelt.setTekst("0");
        }
        if(sideSelected == 3){
            beregnerSide.setSideCL(float(tekstFelt.getTekst()));
            tekstFelt.setTekst("0");
        }
        if(sideSelected == 4){
            beregnerSide.setVinkelAS(float(tekstFelt.getTekst()));
            tekstFelt.setTekst("0");
        }
        if(sideSelected == 5){
            beregnerSide.setVinkelBS(float(tekstFelt.getTekst()));
            tekstFelt.setTekst("0");
        }
    }
}

void selectSideA(){
    sideSelected = 1;
}

void selectSideB(){
    sideSelected = 2;
}

void selectSideC(){
    sideSelected = 3;
}

void selectVinkelA(){
    sideSelected = 4;
}

void selectVinkelB(){
    sideSelected = 5;
}

void sideSelected(int vS){
    beregnerSide.sideSelected(vS,menuSelected);
}

void calculate(){
    if(sideSelected == 1){
        beregnerSide.calculateSideA();
    }
    if(sideSelected == 2){
        beregnerSide.calculateSideB();
    }
    if(sideSelected == 3){
        beregnerSide.calculateSideC();
    }
    if(sideSelected == 4){
        beregnerSide.calculateVinkelA();
    }
    if(sideSelected == 5){
        beregnerSide.calculateVinkelB();
    }
}