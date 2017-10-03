import processing.core.PApplet;

import java.util.ArrayList;

public class Breakout extends PApplet {

  public static void main(String[] args){ PApplet.main("Breakout"); }
  private final int width = 800;
  private final int height = 460;
  public void settings(){ size(width,height); }
  public void setup(){
    frameRate(120);
    colorMode(HSB);
    background(0,0,0);
    ball = new Ball((width/2-45), (height-150), 15, 180, new int[]{255,255,255});
    bricks = new ArrayList<>();
    player = new Player((width/2-45), (height-16), 90, 15, new int[]{255,255,255});
    int y = 5;
    while(y < ((height/10)*5)){
      // TODO random number of bricks
      int h = (int)random(10,50);
      int howmany = (int)random(6,20);
      int w = width / howmany;
      int space = (width % howmany) / (howmany + 2);,
      int x = space;
      y += 5;
      for(int i=0;i<howmany;i++){
        bricks.add(new Brick(x, y, w, h, new int[]{(int)random(30) ,255,255}));
        x = x + space + ((width - ((howmany + 1) * 5)) / howmany);
      }
      y = y + h;
    }
  }

  private Player player;
  private Ball ball;
  private ArrayList<Brick> bricks;

  private void changeColors(){
    player.setC(new int[]{player.getC(0)+1,255,255});
    // TODO for ball color get bricks normal color and invert it
    ball.setC(new int[]{122+bricks.get(0).getC(0)+1,255,255});
    for(int i=0;i<bricks.toArray().length;i++){
      float random = random(3,5);
      if(frameCount % random >= 0 && frameCount % random <= 0.2){
        bricks.get(i).setC(new int[]{bricks.get(i).getC(0)+1,255,255});
      }
    }
  }
  private void checkKeyPresses(){
    if(keyPressed){
      if(keyCode == 37){
        player.move(-2);
      } else if(keyCode == 39){
        player.move(2);
      }
    }
  }

  public void draw() {
    clear();
    changeColors();
    checkKeyPresses();
    player.checkEdges(width);
    fill(ball.getC(0),ball.getC(1),ball.getC(2));
    ellipse(ball.getX(), ball.getY(), ball.getR(), ball.getR());
    fill(player.getC(0),player.getC(1),player.getC(2));
    rect(player.getX(), player.getY(), player.getW(), player.getH());
    for(int i=0;i<bricks.toArray().length;i++){
      fill(bricks.get(i).getC(0),bricks.get(i).getC(1),bricks.get(i).getC(2));
      rect(bricks.get(i).getX(),bricks.get(i).getY(),bricks.get(i).getW(),bricks.get(i).getH());
    }
  }

}