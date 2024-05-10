boolean mainMenuSelected = true,trekantBeregnerSelected = false,trekantTeoriSelected = false;

Button knapTrekantBeregner,knapTrekantTeori;
Button sideA,sideB;

ButtonEllipse vinkelA,vinkelB,vinkelC;

ButtonRotate sideC;

ButtonPicture returnArrow;

MainMenu mainMenu;

TrekantBeregner beregnerSide;

float buttonW = 100,buttonH = 90;

void setup(){
    fullScreen();
    frameRate(60);

    sideA = new Button(this,766,534,390,10," ","nothing",10,10);
    sideB = new Button(this,1156,534,5,206," ","nothing",0.1,0.1);
    sideC = new ButtonRotate(this,766,534,441,10," ","nothing",10,10,27.785);

    vinkelA = new ButtonEllipse(this,766,534,10,15," ","nothing",0.01,0.01);
    vinkelB = new ButtonEllipse(this,1156,328,10,15," ","nothing",0.01,0.01);
    vinkelC = new ButtonEllipse(this,1156,534,10,15," ","nothing",0.01,0.01);
    
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