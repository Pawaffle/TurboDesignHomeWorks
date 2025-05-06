package w9_t22_pixelComrade;

public class Model {
  protected int size;
  protected int[][] matrix;
  protected int positionX;
  protected int positionY;

  public Model(int size) {
    this.size = size;
    matrix = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        matrix[i][j] = 0;
      }
    }
  }

  // displays the map on the screen as a matrix of characters
  public void display(){
    System.out.println("int[][] pixelArt = {");
    for (int i = 0; i < size; i++) {
      System.out.print("    {");
      for (int j = 0; j < size; j++) {
        System.out.print(matrix[i][j] + (j < size-1 ? ", " : ""));
      }
      System.out.println("}" + (i < size-1 ? "," : ""));
    }
    System.out.println("};");
  };

  public void toggle(){
    matrix[positionX][positionY] = (matrix[positionX][positionY] == 0) ? 1 : 0;
  }

  public void moveUp(){
    positionX = Math.max(0, Math.min(size-1, positionX - 1));
  }

  public void moveDown(){
    positionX = Math.max(0, Math.min(size-1, positionX + 1));
  }

  public void moveLeft(){
    positionY = Math.max(0, Math.min(size-1, positionY - 1));
  }

  public void moveRight(){
    positionY = Math.max(0, Math.min(size-1, positionY + 1));
  }
}
