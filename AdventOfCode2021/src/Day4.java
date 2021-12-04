import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("day4.txt"));
		
		String line;
		line = br.readLine();
		String[] l = line.split(",");
		
		Queue<Integer> numbers = new LinkedList<Integer>();
		List<int[][]> boards = new ArrayList<>();
		
		for (int i = 0; i < l.length; i++) 
			numbers.add(Integer.valueOf(l[i]));
		br.readLine();
		
		do {
			int[][] board = new int[5][5];
			boards.add(board);
			
			for (int i = 0; i < 5; i++) {
				int index = 0;
				line = br.readLine(); 
				for (int j = 0; j < 5; j++) {
					board[i][index] = Integer.valueOf(line.substring(j * 3, j * 3 + 2).strip());
					index++;
					}
				}	
		} while((line = br.readLine()) != null);
		
		//PART 1
		int currentNumber = 0;
		while(numbers.isEmpty() == false) {
			boolean winner = false;
			currentNumber = numbers.remove();
			markBoards(boards, currentNumber);
			
			for(int[][] b : boards) {
				if(winner(b)) {
					int sum = sumUnMarked(b);
					System.out.println(sum * currentNumber);
					winner = true;
					break;
				}
			}
			if(winner)
				break;
		}
		
		//PART2
		currentNumber = 0;
		while(numbers.isEmpty() == false) {
			boolean winner = false;
			
			currentNumber = numbers.remove();
			markBoards(boards, currentNumber);
			
			for(int i = boards.size()-1; i >= 0 ;i--) {
				if(winner(boards.get(i))) {
					if(boards.size() == 1) {
						int sum = sumUnMarked(boards.get(i));
						System.out.println(sum * currentNumber);
						winner = true;
						break;
					}
					boards.remove(i);
				}
			}
			if(winner)
				break;
		}
		
		br.close();	
	}

	private static int sumUnMarked(int[][] b) {
		int sum = 0;
		for (int row = 0; row < b.length; row++) {
			for (int col = 0; col < b[0].length; col++) {
				if(b[row][col] != -1) {
					sum += b[row][col];
				}
			}
		}
		
		
		return sum;
	}

	private static boolean winner(int[][] b) {
		boolean win;
		for (int row = 0; row < b.length; row++) {
			win = true;
			for (int col = 0; col < b[0].length; col++) {
				if(b[row][col] != -1) {
					win = false;
					break;
				}
			}
			if(win)
				return true;
		}
		
		for (int col = 0; col < b.length; col++) {
			win = true;
			for (int row = 0; row < b[0].length; row++) {
				if(b[row][col] != -1) {
					win = false;
					break;
				}
			}
			if(win)
				return true;
		}
		
		return false;
	}

	private static void markBoards(List<int[][]> boards, int n) {
		for(int[][] b : boards) 
			for (int row = 0; row < b.length; row++) 
				for (int col = 0; col < b[0].length; col++) 
					if(b[row][col] == n) 
						b[row][col] = -1;		
	}


}
