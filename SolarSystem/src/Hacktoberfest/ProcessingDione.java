package Hacktoberfest;

import processing.core.*;

public class ProcessingDione extends PApplet{
    PShape dione;
    
    @Override
    public void settings() {
        size(800, 800, "processing.opengl.PGraphics3D");
    }
    
    @Override
    public void setup() {
        PImage img = loadImage("../images/1k/dione.jpg");
        noStroke();
        sphereDetail(1000);
        dione = createShape(SPHERE, 500);
        dione.setTexture(img);
         //frameRate(60);
    }
    float a = 0;
    final float DEG2RAD = PI/180;
    
    @Override
    public void draw() {
        translate(width/2, height/2, -500);
        rotateZ(23.5f * DEG2RAD);
        rotateY(a);
        //  dione.rotateY(0.01);
        shape(dione); 
        a += 0.01;
    }  
    public static void main(String[] args){
        PApplet.main("Hacktoberfest.ProcessingDione");
    }
}
