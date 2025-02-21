import java.util.Scanner;

public class asgTicTacToe{
    char board[][] = new char[3][3];
    // char empty = '-';
    char p1 = 'O';
    char p2 = 'X';

    int x, y;

    boolean p1turn = true;
    boolean gameWon = false;

    int countMove = 0;

    void fillBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3;j++){
                board[i][j] = '-';
            }
        }
    }

    void printBoard(){
        for(int i = 0; i < 3;i++){
            for(int j = 0; j < 3;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void input(){
        Scanner scanner = new Scanner(System.in);
        
        if(p1turn){
            System.out.print("Player 1 move: ");
        } else {
            System.out.print("Player 2 move: ");
        }

        x = scanner.nextInt();
        y = scanner.nextInt();
    }
    /*
    X X X
    O O O
    X X X
     */

    boolean checkWin(){
        char checkSymbol;
        if(p1turn){
            checkSymbol = p1;
        } else {
            checkSymbol = p2;
        }

        //cek baris
        for(int i = 0; i < 3;i++){
            if(board[i][0] == checkSymbol && board[i][1] == checkSymbol && board[i][2] == checkSymbol){
                return true;
            }
        }

        //cek kolom
        for(int i = 0; i < 3;i++){
            if(board[0][i] == checkSymbol && board[1][i] == checkSymbol && board[2][i] == checkSymbol){
                return true;
            }
        }

        //cek diagonal
        if(board[0][0] == checkSymbol && board[1][1] == checkSymbol && board[2][2] == checkSymbol){
            return true;
        }

        if(board[0][2] == checkSymbol && board[1][1] == checkSymbol && board[2][0] == checkSymbol){
            return true;
        }

        return false;
    }

    void boardLogic(){
        fillBoard(); //isi dulu board nya 

        while(!gameWon && countMove <= 9){
            printBoard(); //print boardnya biar tau mau ngisi yang mana
            input();

            if(x < 0 || x > 2 || y < 0 || y > 2 || board[y][x] != '-'){
                System.out.println("Invalid mode! Input again.");
                continue;
            }

            if(p1turn){
                board[y][x] = p1;
            } else {
                board[y][x] = p2;
            }
            countMove++;

            if(checkWin()){
                gameWon = true;
                printBoard();
                if(p1turn){
                    System.out.println("Player 1 wins!");
                } else {
                    System.out.println("Player 2 wins!");
                }
            } else {
                p1turn = !p1turn;
            }
        }
        if(!gameWon){
            printBoard();
            System.out.println("Draw!");
        }
    }
}