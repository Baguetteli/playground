public class Player {

  private int x,y,w,h;
  private int[] c;

  public Player(int x, int y, int w, int h, int[] c){
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.c = c;
  }

  public int getX(){
    return this.x;
  }
  public int getY(){
    return this.y;
  }
  public int getH(){
    return this.h;
  }
  public int getW(){
    return this.w;
  }
  public int getC(int c){
    return this.c[c];
  }
  public void setC(int[] c){
    if(c[0] > 255){
      c[0] = 0;
    }
    this.c = c;
  }
  public void move(int x){
    this.x += x;
  }

  public void checkEdges(int w){
    if(this.x+this.w>w){
      this.x = this.x+this.w;
    } else if(this.x<0){
      this.x = 0;
    }
  }

}