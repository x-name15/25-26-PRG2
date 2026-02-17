import java.util.Scanner;

public class ExamenMina{

	static final int ROWS = 5;
	static final int COLS = 7;
	static final int TOTAL_MINES = 5;
	static final int MAX_MINES_TO_LOSE = 3;
	static final int CELLS_TO_WIN = ROWS * COLS - TOTAL_MINES;

	static String[][] displayBoard = 	
		{
			{" ",	"1", 	"2", 	"3", 	"4",	"5",	"6", 	"7"},
			{"1", 	"-", 	"-", 	"-", 	"-", 	"-", 	"-",	"-"},
			{"2", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"},
			{"3", 	"-", 	"-", 	"-",	"-", 	"-", 	"-",	"-"},
			{"4", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"},
			{"5", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"}
		};
		
	static String[][] mineBoard = 	
		{
			{" ",	"1", 	"2", 	"3", 	"4",	"5",	"6", 	"7"},
			{"1", 	"0", 	"0", 	"0", 	"0", 	"0", 	"0",	"0"},
			{"2", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"},
			{"3", 	"0", 	"0", 	"0",	"0", 	"0", 	"0",	"0"},
			{"4", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"},
			{"5", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"}
		};

	public static void main(String[] args){	
	Scanner scanner = new Scanner(System.in);
		int i=0;	
		while ( i < TOTAL_MINES){
		int mineCol = (int)(Math.random()*COLS+1);
		int mineRow = (int)(Math.random()*ROWS+1);
			if (mineBoard[mineRow][mineCol].equals("1")){
			i=i-1;
			}
			else {
				mineBoard[mineRow][mineCol]="1";
			}
			i++;
		}
	
	int row=0, col=0, cellsRevealed=0, minesHit=0;
	boolean gameRunning=true, validInput;

	while(gameRunning){
			for( i = 0; i<displayBoard.length; i++){            
				for (int j = 0; j<displayBoard[i].length; j++) {                                     
					System.out.print(displayBoard[i][j]);
				}
				System.out.println(" ");
			}
validInput=false;
while(!validInput){
	System.out.println(" ");
	System.out.println("Ingrese X");
	row = scanner.nextInt();
	System.out.println("Ingrese Y");
	col = scanner.nextInt();
	if(row>ROWS || col>COLS){
		System.out.println("Entrada inválida");
	}
	else{
		validInput=true;
		if(mineBoard[row][col].equals("1")){
			displayBoard[row][col]="x";
			minesHit++;
		}
		else if(mineBoard[row][col].equals("0")){
			displayBoard[row][col]=".";
		}
		else{
			System.out.println("No es correcta esa opcion.");
		}
		
		cellsRevealed++;
		if(minesHit>MAX_MINES_TO_LOSE-1){
			gameRunning=false;
			System.out.println("Has perdido");
		}
		else if(cellsRevealed>=CELLS_TO_WIN){
			System.out.println("Felicidades Ganador!");
			gameRunning=false;
	}
}
}
}	
	
	
}
}
