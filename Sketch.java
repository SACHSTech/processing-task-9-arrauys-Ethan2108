import java.util.Random;

import processing.core.PApplet;

public class Sketch extends PApplet {
	
   // global variables 
   Random r = new Random();

   public float circleX;
   public float speed = 5f;
   public float snowSize = 30f;
 
   public int heightScale = (int)height/800;
   public int num = 40;
   public int max = 170*heightScale;
   public int min = 165*heightScale;
 
   public float[] circleY = new float[(int)width/7];
   public float[] snowPile = new float[(int)width/7];
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(500, 500);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(height);
    }
    for (int i = 0; i < snowPile.length; i++) {
      snowPile[i] = r.nextInt((max - min) + 1) + min;
    }
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  background(0);
    speedChange();
    snowFall();
 
  }
  
  // arrows to change speed
  public void speedChange() {
    if (keyPressed) {
      if (keyCode == UP) {
        speed = 1;
      }
      else if (keyCode == DOWN) {
        speed = 10f;
      }
    }
    else {
      speed = 5f;
    }
  }


  // snow fall
  public void snowFall() {
    for (int i = 0; i < circleY.length; i++) {
      circleX = width * i / circleY.length;
      ellipse(circleX, circleY[i], snowSize, snowSize);
      circleY[i]+=speed;
      if (circleY[i] > height) {
        circleY[i] = 0;
        snowPile[i]+=2;
      }
     }
  }


  }