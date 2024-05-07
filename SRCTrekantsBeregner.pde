boolean mainMenuSelected = true,trekantBeregnerSelected = false,trekantTeoriSelected = false;

Button knapTrekantBeregner,knapTrekantTeori;

ButtonPicture returnArrow;

MainMenu mainMenu;

TrekantSide beregnerSide;

float buttonW = 100,buttonH = 90;
float trekantY1 = 450, trekantY2 = 300, trekantY3 = 450;

void setup(){
    fullScreen();
    
    knapTrekantBeregner = new Button(this,width/2,300,buttonW,buttonH,"Trekants beregner","selectTrekantBeregner",60,20);
    knapTrekantTeori    = new Button(this,width/2,450,buttonW,buttonH,"Teori om trekanter","selectTrekantTeori",60,20);
    returnArrow         = new ButtonPicture(this,50,50,50,50,loadImage("returnArrow.png"),"selectMainMenu");

    mainMenu     = new MainMenu(this,knapTrekantBeregner,knapTrekantTeori,loadImage("solidBlue.png"),width,height);
    beregnerSide = new TrekantSide(this,returnArrow,width/2 - 150,width/2 - 150,width/2 + 150,trekantY1,trekantY2,trekantY3,loadImage("solidBlue.png"),width,height);
}

void draw(){
    if(mainMenuSelected){
        mainMenu.mainMenuDisplay();
    }
    if(trekantBeregnerSelected){
        beregnerSide.displayTrekantSide();
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