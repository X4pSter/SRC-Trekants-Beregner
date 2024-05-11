boolean mainMenuSelected = true,trekantBeregnerSelected = false,trekantTeoriSelected = false;

Button knapTrekantBeregner,knapTrekantTeori;
Button sideA,sideB;

ButtonEllipse vinkelA,vinkelB,vinkelC;

ButtonRotate sideC;

ButtonPicture returnArrow;

MainMenu mainMenu;

TrekantBeregner beregnerSide;

float buttonW = 100,buttonH = 90;
float ellipseHeight = 15, ellipseWidth = 15;

void setup(){
    fullScreen();
    frameRate(60);

    sideA = new Button(this,1156,534 - 206 + ellipseHeight/2,2.5,206 - ellipseHeight," ","nothing",0.001,0.001);
    sideB = new Button(this,766 + 195,529,390 - ellipseWidth,10," ","nothing",10,10);
    sideC = new ButtonRotate(this,766 + ellipseWidth/2,529,441 - ellipseWidth,10," ","nothing",10,10,27.785);

    vinkelA = new ButtonEllipse(this,766,534,ellipseWidth,ellipseHeight," ","nothing",0.01,0.01);
    vinkelB = new ButtonEllipse(this,1156,328,ellipseWidth,ellipseHeight," ","nothing",0.01,0.01);
    vinkelC = new ButtonEllipse(this,1156,534,ellipseWidth,ellipseHeight," ","nothing",0.01,0.01);
    
    knapTrekantBeregner = new Button(this,width/2,300,buttonW,buttonH,"Trekants beregner","selectTrekantBeregner",60,20);
    knapTrekantTeori    = new Button(this,width/2,450,buttonW,buttonH,"Teori om trekanter","selectTrekantTeori",60,20);
    returnArrow         = new ButtonPicture(this,50,50,50,50,loadImage("returnArrow.png"),"selectMainMenu");

    mainMenu     = new MainMenu(this,knapTrekantBeregner,knapTrekantTeori,loadImage("solidBlue.png"),width,height);
    beregnerSide = new TrekantBeregner(this,returnArrow,loadImage("solidBlue.png"),loadImage("retVinkletTrekant.png"),width,height,sideA,sideB,sideC,vinkelA,vinkelB,vinkelC);
}

void draw(){
    if(mainMenuSelected){
        mainMenu.mainMenuDisplay();
    }
    if(trekantBeregnerSelected){
        beregnerSide.display();
    }
}

void mousePressed(){
    if(mainMenuSelected){
        mainMenu.handleButtonClicks();
    }
    if(trekantBeregnerSelected){
        beregnerSide.handleButtonClicks();
    }
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