package Hacktoberfest;

import processing.core.*;

public class ProcessingEarth extends PApplet{
    PShape earth;
    
    @Override
    public void settings() {
        size(800, 800, "processing.opengl.PGraphics3D");
    }
    
    @Override
    public void setup() {
        //size(800,800,P3D);
        PImage img = loadImage("../images/1k/earth.jpg");
        noStroke();
        sphereDetail(1000);
        earth = createShape(SPHERE, 500);
        earth.setTexture(img);
         //frameRate(60);
    }
    float a = 0;
    final float DEG2RAD = PI/180;
    
    @Override
    public void draw() {
        translate(width/2, height/2, -500);
        rotateZ(23.5f * DEG2RAD);
        rotateY(a);
        //earth.rotateY(0.01f);
        shape(earth); 
        a += 0.01;
    }  
    public static void main(String[] args){
        PApplet.main("Hacktoberfest.ProcessingEarth");
    }
}
