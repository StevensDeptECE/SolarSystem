package Hacktoberfest;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;
import processing.core.*;

public class ProcessingPlanet extends PApplet {
    ArrayList<PShape> planets = new ArrayList<>();
    float a = 0;
    
    @Override
    public void settings() {
        size(1800, 800, "processing.opengl.PGraphics3D");
    }
    
    public void createBodies() throws IOException {
        Stream<Path> w = Files.walk(Paths.get("../images/1k/"));
        List<String> result = w.map(x -> x.toString())
                              .filter(f -> f.endsWith(".jpg"))
                              .collect(Collectors.toList());
        Iterator<String> it = result.iterator();
        while(it.hasNext()){
            String s = it.next();
            if (s.contains("_"))
                it.remove();
        }
        System.out.println(result.toString());
        float size = 200;
        for (String bodyName: result) {
            try {
                planets.add(createBody(bodyName, size));
            } catch(Exception e) {
                System.out.println("Error:" + e + " body=" + bodyName);
            }
        }        
    }
    
    public PShape createBody(String name, float size) throws IOException{
        PImage img = loadImage(name);
        PShape body = createShape(SPHERE, size);
        body.setTexture(img);
        return body;
    }
    
    @Override
    public void setup() {
        noStroke();
        sphereDetail(50);
        //go in a loop reading in array of planets      
        try{
            createBodies();
        } catch (IOException e){
            e.printStackTrace();
        }
    }  
    @Override
    public void draw() {
        background(0);
        translate(width/2, height/2, -500);
        float x = -800;
        for (PShape body : planets) {
            pushMatrix();
            translate(x,0,0);
            rotateZ(23.5f * PI/180);
            rotateY(a);
            //translate(x,0,0);
            shape(body);
            popMatrix();
            x += 400;
        }       
        a += 0.01;
    }
    
    public static void main(String[] args){
        PApplet.main("Hacktoberfest.ProcessingPlanet");
    }
}