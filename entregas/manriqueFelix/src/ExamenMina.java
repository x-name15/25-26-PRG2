import java.util.Scanner;

public class ExamenMina{

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
		while ( i < 5){
		int mineCol = (int)(Math.random()*7+1);
		int mineRow = (int)(Math.random()*5+1);
			if (mineBoard[mineRow][mineCol].equals("1")){
			i=i-1;
			}
			else {
				mineBoard[mineRow][mineCol]="1";
			}
			i++;
		}
	
	int row=0, col=0, gameRunning=1, validInput, cellsRevealed=0, minesHit=0;

		while(gameRunning==1){
			for( i = 0; i<displayBoard.length; i++){            
				for (int j = 0; j<displayBoard[i].length; j++) {                                     
					System.out.print(displayBoard[i][j]);
				}
				System.out.println(" ");
			}
			validInput=0;
			while(validInput==0){
				System.out.println(" ");
				System.out.println("Ingrese X");
			row = scanner.nextInt();
			System.out.println("Ingrese Y");
			col = scanner.nextInt();
				if(row>5){
					validInput=0;
				}
				else if(col>7){
					validInput=0;
				}
				else{
					validInput=1;
				}
			}

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
			if(minesHit>2){
				gameRunning=0;
				System.out.println("Has perdido");
			}
		else if(cellsRevealed>=30){
		
}System.out.println("Felicidades Ganador!");
gameRunning=0;
}
else{

}
}
}


}
