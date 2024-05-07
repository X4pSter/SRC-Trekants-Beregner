Button test;

void setup(){
    size(500,500);
    test = new Button(this,100,100,50,50,"test","test");
}

void draw(){
    test.display();
}

void mousePressed(){
    test.mouseClickDetection();
}

void test(){
    println("works");
}