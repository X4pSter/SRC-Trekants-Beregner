Button test;
ButtonPicture test2;

void setup(){
    size(500,500);
    test  = new Button(this,100,100,50,50,"test","test");
    test2 = new ButtonPicture(this,200,100,25,25,loadImage("returnArrow.png"),"test");
}

void draw(){
    test.display();
    test2.display();
}

void mousePressed(){
    test.mouseClickDetection();
    test2.mouseClickDetection();
}

void test(){
    println("works");
}