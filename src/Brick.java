public class Brick {

  private int x,y,h,w;
  private int[] c;

  public Brick(int x, int y, int w, int h, int[] c){
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

}