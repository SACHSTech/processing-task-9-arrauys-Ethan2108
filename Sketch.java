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
	
   boolean snowClicked;
   boolean playerUp;
   boolean playerLeft;
   boolean playerDown;
   boolean playerRight;
   float playerX = 0;
   float playerY = 380;
   float playerWidth = 30;
   float playerHeight = 30;
   int intLives = 3;
   int intGameOver = 0;
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(height);
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
      }
    }
}

  public void drawPlayer(){
    // drawing blue circle and lives
    for (int i = 1; i <= intLives; i++){
      fill(255, 0, 0);
      // lives
      rect ((i + 8) * 30, 15, 30, 30);
    }
      fill(0, 0, 255);
      ellipse(playerX, playerY, playerWidth, playerHeight);

    if(intLives == 0){
      intGameOver = 3;
  }
}

   // moving blue circle
   if (playerUp){
    playerY -= 3;
  }
  if (playerDown){
    playerY += 3;
  }
  if (playerLeft){   
    playerX -= 3;
  }
  if (playerRight){
    playerX += 3;
}

  public void keyPressed() {
    if (key == 'a'){
      playerLeft = true;
    }
    if (key == 's'){
      playerDown = true;
    }
    if (key == 'd'){
      playerRight = true;
    }
    else if (key == 'w'){
      playerUp = true;
    }
  }
}
}