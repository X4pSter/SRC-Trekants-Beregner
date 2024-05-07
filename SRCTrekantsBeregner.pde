boolean mainMenuSelected = true,trekantBeregnerSelected = false,trekantTeoriSelected = false;

Button knapTrekantBeregner,knapTrekantTeori;

MainMenu mainMenu;

float buttonW = 100,buttonH = 90;

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
    
}

void selectMainMenu(){
    
}

void selectTrekantBeregner(){
    
}

void selectTrekantTeori(){

}