boolean mainMenuSelected = true,trekantBeregnerSelected = false,trekantTeoriSelected = false;

Button knapTrekantBeregner,knapTrekantTeori;
Button sideA,sideB;
Button assignValue;
Button beregnsider;

ButtonEllipse vinkelA,vinkelB,vinkelC;

ButtonRotate sideC;

ButtonPicture returnArrow;

MainMenu mainMenu;

TrekantBeregner beregnerSide;

float buttonW = 100,buttonH = 90;
float ellipseHeight = 15, ellipseWidth = 15;

TekstFelt tekstFelt;

ArrayList<String> numbers = new ArrayList<String>();

int valueSelected;

String[] valgtSide = new String[5];

void setup(){
    fullScreen();
    frameRate(60);

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
    
    knapTrekantBeregner = new Button(this,width/2,300,buttonW,buttonH,"Trekants beregner","selectTrekantBeregner",60,20);
    knapTrekantTeori    = new Button(this,width/2,450,buttonW,buttonH,"Teori om trekanter","selectTrekantTeori",60,20);
    returnArrow         = new ButtonPicture(this,50,50,50,50,loadImage("returnArrow.png"),"selectMainMenu");

    tekstFelt = new TekstFelt(this,850,600,50,50,43,10,numbers);
    assignValue = new Button(this,923,730,50,50,"Assign value","assignValues",25,10);

    mainMenu     = new MainMenu(this,knapTrekantBeregner,knapTrekantTeori,loadImage("solidBlue.png"),width,height);
    beregnerSide = new TrekantBeregner(this,returnArrow,loadImage("solidBlue.png"),loadImage("retVinkletTrekant.png"),width,height,sideA,sideB,sideC,vinkelA,vinkelB,vinkelC,tekstFelt,assignValue);

    valgtSide[0] = "Side a valgt";
    valgtSide[1] = "Side b valgt";
    valgtSide[2] = "Side c valgt";
    valgtSide[3] = "Vinkel A valgt";
    valgtSide[4] = "Vinkel B valgt";
}

void draw(){
    if(mainMenuSelected){
        mainMenu.mainMenuDisplay();
    }
    if(trekantBeregnerSelected){
        beregnerSide.display();
    }
    sideSelected(valueSelected);
}

void mousePressed(){
    if(mainMenuSelected){
        mainMenu.handleButtonClicks();
    }
    if(trekantBeregnerSelected){
        beregnerSide.handleButtonClicks();
    }
}

void keyPressed(){
    beregnerSide.handleKeyClicks();
}

void selectMainMenu(){
    mainMenuSelected        = true;
    trekantBeregnerSelected = false;
    trekantTeoriSelected    = false;
}

void selectTrekantBeregner(){
    mainMenuSelected        = false;
    trekantBeregnerSelected = true;
    trekantTeoriSelected    = false;
}

void selectTrekantTeori(){
    mainMenuSelected        = false;
    trekantBeregnerSelected = false;
    trekantTeoriSelected    = true;
}

void nothing(){
    println("nothing");
}

void assignValues(){
    String temp = "";
    if(!temp.equals(tekstFelt.tekst)){
        if(valueSelected == 1){
            beregnerSide.sideAL = float(tekstFelt.tekst);
        }
        if(valueSelected == 2){
            beregnerSide.sideBL = float(tekstFelt.tekst);
        }
        if(valueSelected == 3){
            beregnerSide.sideCL = float(tekstFelt.tekst);
        }
        if(valueSelected == 4){
            beregnerSide.vinkelAS = float(tekstFelt.tekst);
        }
        if(valueSelected == 5){
            beregnerSide.vinkelBS = float(tekstFelt.tekst);
        }
    }
}

void selectSideA(){
    valueSelected = 1;
}

void selectSideB(){
    valueSelected = 2;
}

void selectSideC(){
    valueSelected = 3;
}

void selectVinkelA(){
    valueSelected = 4;
}

void selectVinkelB(){
    valueSelected = 5;
}

void sideSelected(int vS){
    if(vS > 0){
        String temp = valgtSide[vS - 1];
        if(trekantBeregnerSelected){
            text(temp,850,680);
        } 
    }
}