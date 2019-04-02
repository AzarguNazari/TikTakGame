/*
 * Tac Tic Tok Game is implemented on a this class
	@author Hazar Gul Nazari
 */
package tictakto;

public class TicTak {

    // This character array is used to store the marks
    private char[][] marks;
    
    
    // Constructor
    public TicTak(int size){
       marks = new char[size][size];
    }
    
    
    // To display the cells of Tic Tac Tok
    public void display(){
        for (char[] mark : marks) {
            System.out.println(line());
            for (int y = 0; y < mark.length; y++) {
                System.out.print("|");
                System.out.print(" " + mark[y] + " ");
            }
            System.out.println("|");
        }
        System.out.println(line());
    }
    
    
    // To help the display the line divistion in dispaying cells
    public String line(){
        String line = "";
        for (char[] mark : marks) {
            line += "----";
        }
        return line;
    }
    
    
    // To check whether the entered row or column is valied or not
    public boolean check(int row, int column){
       return row > marks.length || column > marks.length || marks[row - 1][column - 1] == 'X' || marks[row - 1][column - 1] == '0';
    }
    
    // To fill the specific cell
    public void fill(int x, int y, char value){
        marks[x - 1][y - 1] = value;
    }
    
    
    // To define the winner of game
    public int hasWinner(){
        
        // Check the all the rows wether anyone of them are winner or not
        for (int x = 0; x < marks.length; x++) {
            int zeros = 0;
            int ones = 0;
            for (int y = 0; y < marks[x].length; y++) {
                if (marks[x][y] == 'X') {
                    ones++;
                }else if (marks[x][y] == '0') {
                    zeros++;
                }
            }
            if(ones == marks.length) return 1;
            if(zeros == marks.length) return 2;
            
            zeros = 0;
            ones = 0;
            
            // To check all the columns whether any one of them are winner or not
            for(int y = 0; y < marks.length; y++){
                if(marks[y][x] == 'X') ones++;
                else if(marks[y][x] == '0') zeros++;
            }
            if(ones == marks.length) return 1;
            if(zeros == marks.length) return 2;
        }
        
        int ones = 0; int zeros = 0;
        
        // To check the right diagonal that is anyof of player winner
        for(int x = 0; x < marks.length; x++){
            if(marks[x][x] == 'X') ones++;
            else if(marks[x][x] == '0') zeros++;
        }
        if(ones == marks.length)  return 1;
        if(zeros == marks.length) return 2;
        
        ones = 0; zeros = 0;
        
        //To check the right diagonal that is anyone of player winner 
        for(int x = 0; x < marks.length; x++){
            if(marks[x][marks.length - x - 1] == 'X') ones++;
            else if(marks[x][marks.length - x - 1] == '0') zeros++;
        }
        
        if(ones == marks.length)  return 1;
        if(zeros == marks.length) return 2;
        return -1;
    }
    
    
    //To check whether the cells are full or not
    public boolean isFull(){
        for (char[] mark : marks) {
            for (int y = 0; y < marks.length; y++) {
                if (mark[y] == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }
}
