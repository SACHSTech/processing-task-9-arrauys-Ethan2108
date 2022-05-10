import processing.core.PApplet;

public class Sketch extends PApplet {

  float[] circleX = new float[40];
  float[] circleY = new float[40];
  boolean[] ballHideStatus = new boolean[40];
  int intSpeed = 3;
  float playerX = 400;
  float playerY = 400;
  boolean upPress = false;
  boolean downPress = false;
  boolean leftPress = false;
  boolean rightPress = false;
  boolean alive = true;
  int lives = 3;
  boolean mouseClicked = false;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(800, 600);
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

    // check to see if player is still alive
    if (alive == true) {
      background(0);
    
      fill(255);

      // draw snowballs to the screen if ballHideStatus is false
      for (int i = 0; i < circleY.length; i++) {
        if (ballHideStatus[i] == false) {
          ellipse(circleX[i], circleY[i], 40, 40);

          circleY[i] += intSpeed;
        }
    
        // resets snowball after the end of screen
        if (circleY[i] > height - 25) {
          circleY[i] = 0;
        }

        // stops drawing snowballs to screen and remove 1 life if player collides
        if (dist(playerX, playerY, circleX[i], circleY[i]) <= 37.5 && ballHideStatus[i] == false) {
          ballHideStatus[i] = true;
          lives--;
        }
        
        // gets rid of the snowball if clicked by the mouse
        if (dist(mouseX, mouseY, circleX[i], circleY[i]) <= 25 && mouseClicked) {
            ballHideStatus[i] = true;
        }
        
      }

      fill(3, 252, 252);

      // draw player circle
      ellipse(playerX, playerY, 40, 40);
      
      // keyboard controls for player using w, a, s, d
      if (leftPress) {
        playerX += -3;
      }
      if (rightPress) {
        playerX += 3;
      }
      if (upPress) {
        playerY += -3;
      }
      if (downPress) {
        playerY += 3;
      }
  
      fill(252, 3, 3);

      // draw three squares to indicate player intLives
      for (int i = 1; i <= lives; i++) {
        rect(70 * i, 50, 50, 50);
      }

      if (lives == 0) {
        alive = false;
      }
    }

    // screen clears to white when all lives are lost
    else {
      background(255);
    }
  }

  
  // key code functions to move the player around or/and adjust the speed

  public void keyPressed() {
    if (key == 'a')  {
      leftPress = true;
    }
    else if (key == 'd') {
      rightPress = true;
    }
    else if (key == 'w') {
      upPress = true;
    }
    else if (key == 's') {
      downPress = true;
    }

    if (keyCode == UP) {
      intSpeed = 2;
    }
    if (keyCode == DOWN) {
      intSpeed = 5;
    }
  }

  public void keyReleased() {
    if (key == 'a')  {
      leftPress = false;
    }
    else if (key == 'd') {
      rightPress = false;
    }
    else if (key == 'w') {
      upPress = false;
    }
    else if (key == 's') {
      downPress = false;
    }

    if (keyCode == UP) {
      intSpeed = 3;
    }
    
    if (keyCode == DOWN) {
      intSpeed = 3;
    }
  }

  public void mousePressed() {
    mouseClicked = true;
  }

  public void mouseReleased() {
    mouseClicked = false;
  }

}