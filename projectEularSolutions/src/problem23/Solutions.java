package problem23;

import java.util.ArrayList;
import java.util.Arrays;

public class Solutions {

	public static void main(String[] args) {
		//System.out.println(isAbundantNumber(4));
		boolean[] nums = new boolean[28123];
		Arrays.fill(nums, true);
		ArrayList<Integer> abundantNum = new ArrayList<Integer>();
		for(int i=1;i<=28123;i++){
			if(isAbundantNumber(i)){
				abundantNum.add(Integer.valueOf(i));
				//System.out.println(i);
			}
		}
		final int len = abundantNum.size();
		for(int i=0;i<len;i++){
			final long numTmp = abundantNum.get(i);
			for(int j=1;j<len;j++){
				final long sumTmp = numTmp + abundantNum.get(j);
				if(sumTmp<=28123&&nums[(int)sumTmp - 1] == true){
					nums[(int)sumTmp - 1] = false;
				}
			}
			if(numTmp*2 <= 28123 && nums[(int)numTmp*2 - 1] == true){
				nums[(int)numTmp*2 - 1] = false;
			}
		}
		long sum = 0;
		for(int i=0;i<nums.length;i++){
			if(nums[i] == true){
				sum += i + 1;
				//System.out.println((i + 1));
			}
		}
		System.out.println(sum);
	}

	private static boolean isAbundantNumber(int num){
		boolean res;

		if(num <= 0){
			return false;
		}

		long sum = 1;
		long len = Math.round(Math.sqrt(num));
		//System.out.println(len);
		
		for(int i=2;i<=(int)len;i++){
			if(num%i == 0){
				if(i*i == num ){
					sum += i;
				}else {
					sum = sum + i + num/i;
				}	
				//System.out.println(sum);
			}
		}
		if(sum > num){
			res = true;
		}else {
			res = false;
		}
		return res;
	}
}
