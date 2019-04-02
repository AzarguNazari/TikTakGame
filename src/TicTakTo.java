/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictakto;

import java.util.Scanner;

/**
 *
 * @author Hazar Gul Nazari
 * 
 */
public class TicTakTo {

    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);
        
        System.out.println("-------------------- START GAME  ------------------------");
        
        System.out.print("Enter Number of Rows: ");
        int rows = input.nextInt();
        
        TicTak t = new TicTak(rows);
        
        int player = 1;
        while(true){
        
            t.display();
            System.out.println("It's " + ((player == 1)? "First Player (X)": "Second Player (0)") + " turn");
            
            // Here is used the while loop to check if the user enter the invalid row and column then
            // The user should enter again through this loop
            while(true){
                
                System.out.print("Fill row column Ex(X Y): ");
                int row = input.nextInt();
                int column = input.nextInt();
                
                //Checking happens here to know whether the user enter the right row and column or not
                if(!t.check(row, column)){
                   
                    // if the user enter the right row and column then check whether
                    // it is the first player turn or the second's turn and
                    // According to the player fill the specific cell
                   if(player == 1) t.fill(row, column, 'X');
                   else t.fill(row, column, '0');
                   break;
                }
                
                System.out.println("Error! please enter the correct one");
            }
            
            // To change the turn to another player
            if(player == 1) player = 2;
            else player = 1;
         
            // To check whether anyone is winner or the board is full
            if(t.hasWinner() > -1 || t.isFull()){
                break;
            }
            
        }
        
        t.display();
        
        int winner = t.hasWinner();
        
        System.out.println("\n---------------- Finish Game  ----------------");
        switch (winner) {
            case 1:
                System.out.println("\tFirst Player(X) is winner");
                break;
            case 2:
                System.out.println("Second Player(0) is winner");
                break;
            default:
                System.out.println("None of them are winner");
                break;
        }
        System.out.println("------------------------------------------------");
        
        
    }
    
}
