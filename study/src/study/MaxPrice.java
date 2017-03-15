package study;

import java.io.File;
import java.util.Scanner;


public class MaxPrice {
		
	public static int changePrice(int num,int count){		
		
		char[] numArray = Integer.toString(num).toCharArray();
		int currentCount = 0;
		int index = 0;
		while(index < numArray.length&&currentCount < count){
			char maxChar = numArray[index];
			int maxIndex = index;
			for(int j = index + 1; j < numArray.length; j++){
				if(maxChar <= numArray[j]){
					maxChar = numArray[j];
					maxIndex = j;
				}
			}
			if(index < maxIndex){
				numArray[maxIndex] = numArray[index];
				numArray[index] = maxChar;
				currentCount++;
			}
			index++;
		}
		return convertCharToInt(numArray);
	}
	
	public static int convertCharToInt(char[] numArray){
		int num = 0;
		final int radix = 10;
		for(int i = 0; i < numArray.length; i++){
			num = num * radix + numArray[i] - '0';
		}
		return num;
	}
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		int maxChange = 0;
		int num;
		try {		
			Scanner cin = new Scanner(new File("C:/Users/zhourunfeng/Desktop/test/sample_input1_1.txt"));
			int caseCount = cin.nextInt();
			System.out.println(caseCount);
			for(int i = 1; i <= caseCount; i++){
				num = cin.nextInt();
				maxChange = cin.nextInt();
				//System.out.println(num + " " + maxChange);
				System.out.println("#" + i + " " + changePrice(num, maxChange));
			}
			cin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("程序运行时间：" + (endTime-startTime) + "ms");

	}

}
