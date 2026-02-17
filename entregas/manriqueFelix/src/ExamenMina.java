import java.util.Scanner;

class Board {
	static final int ROWS = 5;
	static final int COLS = 7;
	
	private String[][] displayBoard;
	private String[][] mineBoard;
	
	public Board() {
		displayBoard = new String[][] {
			{" ",	"1", 	"2", 	"3", 	"4",	"5",	"6", 	"7"},
			{"1", 	"-", 	"-", 	"-", 	"-", 	"-", 	"-",	"-"},
			{"2", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"},
			{"3", 	"-", 	"-", 	"-",	"-", 	"-", 	"-",	"-"},
			{"4", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"},
			{"5", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"}
		};
		
		mineBoard = new String[][] {
			{" ",	"1", 	"2", 	"3", 	"4",	"5",	"6", 	"7"},
			{"1", 	"0", 	"0", 	"0", 	"0", 	"0", 	"0",	"0"},
			{"2", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"},
			{"3", 	"0", 	"0", 	"0",	"0", 	"0", 	"0",	"0"},
			{"4", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"},
			{"5", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"}
		};
	}
	
	public void placeMines(int totalMines) {
		int minesPlaced = 0;
		while (minesPlaced < totalMines) {
			int col = (int)(Math.random() * COLS + 1);
			int row = (int)(Math.random() * ROWS + 1);
			if (!mineBoard[row][col].equals("1")) {
				mineBoard[row][col] = "1";
				minesPlaced++;
			}
		}
	}
	
	public void display() {
		for (int i = 0; i < displayBoard.length; i++) {
			for (int j = 0; j < displayBoard[i].length; j++) {
				System.out.print(displayBoard[i][j]);
			}
			System.out.println(" ");
		}
	}
	
	public boolean hasMine(int row, int col) {
		return mineBoard[row][col].equals("1");
	}
	
	public boolean isRevealed(int row, int col) {
		return !displayBoard[row][col].equals("-");
	}
	
	public void revealCell(int row, int col, boolean isMine) {
		displayBoard[row][col] = isMine ? "x" : ".";
	}
}

class Game {
	static final int TOTAL_MINES = 5;
	static final int MAX_MINES_TO_LOSE = 3;
	static final int CELLS_TO_WIN = Board.ROWS * Board.COLS - TOTAL_MINES;
	
	private Board board;
	private Scanner scanner;
	private int cellsRevealed;
	private int minesHit;
	private boolean gameRunning;
	
	public Game() {
		board = new Board();
		scanner = new Scanner(System.in);
		cellsRevealed = 0;
		minesHit = 0;
		gameRunning = true;
	}
	
	public void start() {
		board.placeMines(TOTAL_MINES);
		
		while (gameRunning) {
			board.display();
			playTurn();
		}
		
		scanner.close();
	}
	
	private void playTurn() {
		int row = 0, col = 0;
		boolean validInput = false;
		
		while (!validInput) {
			System.out.println(" ");
			System.out.println("Ingrese X");
			row = scanner.nextInt();
			System.out.println("Ingrese Y");
			col = scanner.nextInt();
			
			if (row > Board.ROWS || col > Board.COLS) {
				System.out.println("Entrada inválida");
			} else if (board.isRevealed(row, col)) {
				System.out.println("No es correcta esa opcion.");
			} else {
				validInput = true;
			}
		}
		
		processMove(row, col);
	}
	
	private void processMove(int row, int col) {
		boolean isMine = board.hasMine(row, col);
		board.revealCell(row, col, isMine);
		
		if (isMine) {
			minesHit++;
		}
		
		cellsRevealed++;
		checkGameStatus();
	}
	
	private void checkGameStatus() {
		if (minesHit >= MAX_MINES_TO_LOSE) {
			gameRunning = false;
			System.out.println("Has perdido");
		} else if (cellsRevealed >= CELLS_TO_WIN) {
			System.out.println("Felicidades Ganador!");
			gameRunning = false;
		}
	}
}

public class ExamenMina {
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}
