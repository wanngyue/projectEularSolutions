package problem25;

import java.math.BigDecimal;

public class Solution {

	public static void main(String[] args) {
		BigDecimal num1 = new BigDecimal(1);//
		BigDecimal num2 = new BigDecimal(1);
		
		char[] tmp = new char[1000];
		tmp[0] = '0' + 1;
		for(int i=1;i<1000;i++){
			tmp[i] = '0';
		}
		BigDecimal com = new BigDecimal(tmp);
		
		int counter = 2;
		
		while(true){
			BigDecimal sum = new BigDecimal(0); 
			sum = sum.add(num1);
			sum = sum.add(num2);
			counter++;
			if(sum.compareTo(com) >=0){
				System.out.println(counter);
				break;
			}
			num2 = new BigDecimal(0).add(num1);
			num1 = new BigDecimal(0).add(sum);
		}
		
		
	}
	

}
