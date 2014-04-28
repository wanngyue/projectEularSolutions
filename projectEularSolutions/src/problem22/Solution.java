package problem22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		File input = new File("files/names.txt");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(input));
			
			String[] names = reader.readLine().replaceAll("\"", "").toUpperCase().split(",");
			
			Arrays.sort(names);
			
			long sum = 0;
			
			for(int i=0;i < names.length;i++){
				sum += getNameValue(names[i]) * (i+1);
			}
			System.out.println(sum);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static long getNameValue(String name){
		if(name == null){
			return Long.MIN_VALUE;
		}
		long res = 0;
		
		for(int i=0;i<name.length();i++){
			res += name.charAt(i) - 'A' + 1;
		}
		return res;
	}
}
