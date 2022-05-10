import processing.core.PApplet;

public class Sketch extends PApplet {

  float[] circleY = new float[30];
  float[] circleX = new float[30];
  boolean[] ballHideStatus = new boolean[30];

  int intSnowballSpeed = 5;

  float playerX = 350;
  float playerY = 350;

  boolean playerStatus = true;
  boolean left;
  boolean right;
  boolean up;
  boolean down;
  int intLives = 3;

  boolean mouseClicked = false;

	 /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
      size(700, 700);
    }
  
    /** 
     * Called once at the beginning of execution.  Add initial set up
     * values here i.e background, stroke, fill etc.
     */
    public void setup() {
      for (int i = 0; i < circleY.length; i++) {
        circleY[i] = random(height);
        circleX[i] = random(width);
        ballHideStatus[i] = false;
      }
    }
    
  
    /**
     * Called repeatedly, anything drawn to the screen goes here
     */
    public void draw() {
      if (playerStatus == true) {
        background(0);
      
        fill(255);
  
        // draw snowballs to the screen if ballHideStatus is false
        for (int i = 0; i < circleY.length; i++) {
          if (ballHideStatus[i] == false) {
            ellipse(circleX[i], circleY[i], 50, 50);
  
            circleY[i] += intSnowballSpeed;
          }
      
          // resets snowball once it reaches end of screen
          if (circleY[i] > height - 25) {
            circleY[i] = 0;
          }
  
          // if player circle collides with snowball, stop drawing snowball to screen and remove 1 life
          if (dist(playerX, playerY, circleX[i], circleY[i]) <= 37.5 && ballHideStatus[i] == false) {
            ballHideStatus[i] = true;
            intLives--;
          }
          
          // if snowball is clicked, stop drawing snowball to screen
          if (dist(mouseX, mouseY, circleX[i], circleY[i]) <= 25 && mouseClicked) {
              ballHideStatus[i] = true;
          }
          
        }
    }
  }
}