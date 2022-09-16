package solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("day1.txt"));
		String line;
		int count = 0;
		int n1 = Integer.valueOf(bf.readLine());
		int n2 = Integer.valueOf(bf.readLine());
		int n3 = Integer.valueOf(bf.readLine());
		int nTotal = n1 + n2 + n3;
		
		while((line = bf.readLine()) != null) {
			n1 = n2;
			n2 = n3;
			n3 = Integer.valueOf(line);
			int i = n1 + n2 + n3; 
			if(nTotal < i)
				count++;
			nTotal = i;
		}
		
		System.out.println(count);
		
	}
}
