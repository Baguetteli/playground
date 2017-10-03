public class Ball {

  private int x,y,r,a;
  private int[] c;

  public Ball(int x, int y, int r, int a, int[] c){
    this.x = x;
    this.y = y;
    this.r = r;
    this.a = a;
    this.c = c;
  }

  public int getX(){
    return this.x;
  }
  public int getY(){
    return this.y;
  }
  public int getR(){
    return this.r;
  }
  public int getA(){
    return this.a;
  }
  public int getC(int c){
    return this.c[c];
  }
  public void setA(int a){
    this.a = a;
  }
  public void setC(int[] c){
    if(c[0] > 255){
      c[0] = 255-c[0];
    }
    this.c = c;
  }

}