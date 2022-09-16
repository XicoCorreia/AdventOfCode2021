package solutions;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {

	public static void main(String[] args) throws IOException {
		int[] horDepAim = {0,0,0};
		BufferedReader bf = new BufferedReader(new FileReader("day2.txt"));
		String line;
		while((line = bf.readLine()) != null) {
			String[] lines = line.split(" ");
			switch(lines[0]) {
			case "forward":
				horDepAim[0] += Integer.valueOf(lines[1]);
				horDepAim[1] += (Integer.valueOf(lines[1]) * horDepAim[2]);
				break;
			case "up":
				horDepAim[2] -= Integer.valueOf(lines[1]);
				break;
			case "down":
				horDepAim[2] += Integer.valueOf(lines[1]);
				break;
			default:
				break;
			}
		}
		int n = horDepAim[0] * horDepAim[1];
		System.out.println(n);
		bf.close();
	}

}
