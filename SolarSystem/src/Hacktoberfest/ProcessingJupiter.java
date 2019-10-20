package Hacktoberfest;

import processing.core.*;
public class ProcessingJupiter extends PApplet {
    PShape sun;
    
    @Override
    public void settings() {
        size(800, 800, "processing.opengl.PGraphics3D");
    }
    
    @Override
    public void setup() {
        PImage img = loadImage("../images/1k/jupiter.jpg");
        noStroke();
        sphereDetail(1000);
        sun = createShape(SPHERE, 500);
        sun.setTexture(img);
         //frameRate(60);
    }
    float a = 0;
    final float DEG2RAD = PI/180;
    
    @Override
    public void draw() {
        translate(width/2, height/2, -500);
        rotateZ(23.5f * DEG2RAD);
        rotateY(a);
        // sun.rotateY(0.01);
        shape(sun); 
        a += 0.01;
    }  
    public static void main(String[] args){
        PApplet.main("Hacktoberfest.ProcessingJupiter");
    }
}
