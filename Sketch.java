import processing.core.PApplet;

public class Sketch extends PApplet {
	
  int intCellWidth = 20; 
  int intCellHeight = 20;
  int intRowCount = 10;
  int intColumnCount = 10;
  int intMargin = 5;
  int intScreenWidth = (intCellWidth + intMargin) * intColumnCount + intMargin;
  int intScreenHeight = (intCellHeight + intMargin) * intRowCount + intMargin;

  int[][] intGrid = new int[10][10]; 
  int cellCount = 0;

  int intMouseX;
  int intMouseY;
  
  public void settings() {
    size(intScreenWidth, intScreenHeight);
  }

  public void setup() {
    background(0);
  }

  public void draw() {
    for (int column  = 0; column < intColumnCount; column++) {
      for (int row = 0; row < intRowCount; row++) {
        if (intGrid[row][column] == 1){
          fill(0, 255, 51);
        }
        else {
          fill(255);
        }
        rect(intMargin + intMargin * column + intCellWidth * column, intMargin + intMargin * row + intCellHeight * row, intCellWidth, intCellHeight);
      }
    }
  }

  public void mousePressed(){
    int intGridRow = (int)(mouseY / (intMargin + intCellHeight));
    int intGridColumn = (int)(mouseX / (intMargin + intCellWidth));

    
    if (intGrid[intGridRow][intGridColumn] == 0) {
      intGrid[intGridRow][intGridColumn] = 1;
    }
    else if (intGrid[intGridRow][intGridColumn] == 1){
      intGrid[intGridRow][intGridColumn] = 0;    
    }
    if (intGridRow < intRowCount - 1 && intGrid[intGridRow + 1][intGridColumn] == 0) {
      intGrid[intGridRow + 1][intGridColumn] = 1;
    }
    else if (intGridRow < intRowCount - 1 && intGrid[intGridRow + 1][intGridColumn] == 1) {
      intGrid[intGridRow + 1][intGridColumn] = 0;
    }
    if (intGridRow > 0 && intGrid[intGridRow - 1][intGridColumn] == 0) {
      intGrid[intGridRow - 1][intGridColumn] = 1;
    }
    else if (intGridRow > 0 && intGrid[intGridRow - 1][intGridColumn] == 1) {
      intGrid[intGridRow - 1][intGridColumn] = 0;
    }
    if (intGridColumn < intColumnCount - 1 && intGrid[intGridRow][intGridColumn + 1] == 0) {
      intGrid[intGridRow][intGridColumn + 1] = 1;
    }
    else if (intGridColumn < intColumnCount - 1 && intGrid[intGridRow][intGridColumn + 1] == 1) {
      intGrid[intGridRow][intGridColumn + 1] = 0;
    }
    if (intGridColumn > 0 && intGrid[intGridRow][intGridColumn - 1] == 0) {
      intGrid[intGridRow][intGridColumn - 1] = 1;
    }
    else if (intGridColumn > 0 && intGrid[intGridRow][intGridColumn - 1] == 1) {
      intGrid[intGridRow][intGridColumn - 1] = 0;
    } 
    cellCount = 0;

    // calculation
    for (int row = 0; row < intRowCount; row++) {
      for (int column = 0; column < intColumnCount; column++) {
        if (intGrid[row][column] == 1){
          cellCount ++;
        }
      }
    }

    System.out.println("Total of " + cellCount + " cells are selected.");

    for (int row = 0; row < intRowCount; row++){

      int cellRowCount = 0;
      int intContBlocks = 0;
      int intMax = 0;

      for (int column = 0; column < intColumnCount; column++) {
        if (intGrid[row][column] == 1) {
          intContBlocks ++;
          cellRowCount ++;

          if (intContBlocks > intMax) {
            intMax = intContBlocks;
          }
        }
        
        else if (intGrid[row][column] == 0){
          intContBlocks = 0;
        }
      }

      if (intMax > 2) {
        System.out.println("There are " + intMax + " continous blocks selected on row " + row + "." );
      }
      // prints number of selected cells in a row
      System.out.println("Row " + row + " has " + intRowCount + " cells selected.");
    }

    for (int column = 0; column < intColumnCount; column++) {
      int intColumnCount = 0;
      for (int row = 0; row < intRowCount; row++) {
        if (intGrid[row][column] == 1) {
          intColumnCount ++;
        }
      }
      // prints number of selected cells in a column
      System.out.println("Column " + column + " has " + intColumnCount + " cells selected.");
    }
  }
  }