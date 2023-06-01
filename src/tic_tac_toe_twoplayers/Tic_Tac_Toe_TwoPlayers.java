/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tic_tac_toe_twoplayers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Osaf Ahmed
 */
public class Tic_Tac_Toe_TwoPlayers {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Integer> PlayerOnePostion = new ArrayList<>();
    static ArrayList<Integer> PlayerTwoPostion = new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here
        char[][] GameBoard = {{' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}
        };

        GameBoardPrint(GameBoard);
        while (true) {
            System.out.println("----------------------");
            System.out.println("Player One: Enter number between 1-9");
            Scanner GetUserValue = new Scanner(System.in);
            int FirstPlayer = GetUserValue.nextInt();
            System.out.println(FirstPlayer);
            while (PlayerOnePostion.contains(FirstPlayer) || PlayerTwoPostion.contains(FirstPlayer)) {
                System.out.println("Values Taken re Enter ");
                FirstPlayer = GetUserValue.nextInt();
            }
            
            PlaceValues(GameBoard, FirstPlayer, "Player one");
            
            String result = CheckWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
            GameBoardPrint(GameBoard);
            
            System.out.println("Player Two: Enter number between 1-9");
            int SecondPlayer = new Scanner(System.in).nextInt();
            

            while (PlayerOnePostion.contains(SecondPlayer) || PlayerTwoPostion.contains(SecondPlayer)) {

                SecondPlayer = new Scanner(System.in).nextInt();
            }
            PlaceValues(GameBoard, SecondPlayer, "Player two");

            GameBoardPrint(GameBoard);
            result = CheckWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
           
        }
    }

    public static void GameBoardPrint(char[][] GameBoard) {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        for (char[] print : GameBoard) {

            System.out.println(print);
        }
    }

    public static void PlaceValues(char[][] GameBoard, int position, String user) {
        char Symbol = ' ';
        if (user.equals("Player one")) {
            Symbol = 'X';
            PlayerOnePostion.add(position);
        } else if (user.equals("Player two")) {
            Symbol = '0';
            PlayerTwoPostion.add(position);
        }
        switch (position) {
            case 1:
                GameBoard[0][0] = Symbol;
                break;
            case 2:
                GameBoard[0][2] = Symbol;
                break;
            case 3:
                GameBoard[0][4] = Symbol;
                break;
            case 4:
                GameBoard[2][0] = Symbol;
                break;
            case 5:
                GameBoard[2][2] = Symbol;
                break;
            case 6:
                GameBoard[2][4] = Symbol;
                break;
            case 7:
                GameBoard[4][0] = Symbol;
                break;
            case 8:
                GameBoard[4][2] = Symbol;
                break;
            case 9:
                GameBoard[4][4] = Symbol;
                break;
            default:
                break;

        }
    }

    public static String CheckWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);

        List topCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List botCol = Arrays.asList(3, 6, 9);

        List LeftCross = Arrays.asList(1, 5, 9);
        List RightCross = Arrays.asList(3, 5, 7);

        List<List> Winning = new ArrayList<>();

        Winning.add(topRow);
        Winning.add(midRow);
        Winning.add(botRow);

        Winning.add(topCol);
        Winning.add(midCol);
        Winning.add(botCol);

        Winning.add(LeftCross);
        Winning.add(RightCross);

        for (List i : Winning) {
            if (PlayerOnePostion.containsAll(i)) {
                return "Player one wins";
            } else if (PlayerTwoPostion.containsAll(i)) {
                return "Player two wins";
            } else if (PlayerOnePostion.size() + PlayerTwoPostion.size() == 9) {
                return " Draw game ";
            }
        }

        return "";
    }

}
