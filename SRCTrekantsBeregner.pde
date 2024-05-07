boolean mainMenuSelected = true,trekantBeregnerSelected = false,trekantTeoriSelected = false;

Button knapTrekantBeregner,knapTrekantTeori;

MainMenu mainMenu;

float buttonW = 100,buttonH = 90;
float trekantX1 = width/2 - 150, trekantX2 = width/2 - 150, trekantX3 = width/2 + 150;
float trekantY1 = 450, trekantY2 = 300, trekantY3 = 450;

void setup(){
    fullScreen();
    
    knapTrekantBeregner = new Button(this,width/2,300,buttonW,buttonH,"Trekants beregner","selectTrekantBeregner",60,20);
    knapTrekantTeori    = new Button(this,width/2,450,buttonW,buttonH,"Teori om trekanter","selectTrekantTeori",60,20);

    mainMenu = new MainMenu(this,knapTrekantBeregner,knapTrekantTeori,loadImage("solidBlue.png"),width,height);
}

void draw(){
    if(mainMenuSelected){
        mainMenu.mainMenuDisplay();
    }
}

void mousePressed(){
    mainMenu.handleButtonClicks();
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