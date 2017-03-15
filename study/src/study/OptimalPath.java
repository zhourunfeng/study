package study;

import java.io.File;
import java.util.Scanner;

public class OptimalPath {
	public static int optimalPath;
	
	public static void permutation(int[][] customArray, int customerNum, int startIndex, int homeX, int homeY, int officeX, int officeY){
		if(startIndex == customerNum){
			int distance = 0;
			for(int i = 0; i <= customerNum; i++){
				if(i == 0){
					distance += abs(homeX, customArray[i][0]) + abs(homeY, customArray[i][1]);
				}else if( i == customerNum) {
					distance += abs(officeX, customArray[i-1][0]) + abs(officeY, customArray[i-1][1]);
				}else{
					distance += abs(customArray[i-1][0], customArray[i][0]) + abs(customArray[i-1][1], customArray[i][1]);
				}				
			}
			if(optimalPath > distance){
				optimalPath = distance;
			}
		}
		for(int j = startIndex; j < customerNum; j++){
			int[] temp = customArray[j];
			customArray[j] = customArray[startIndex];
			customArray[startIndex] = temp;
			permutation(customArray, customerNum, startIndex+1, homeX, homeY, officeX, officeY);
			temp = customArray[j];
			customArray[j] = customArray[startIndex];
			customArray[startIndex] = temp;
		}
	}

	public static int abs(int num1, int num2){
		if(num1 > num2){
			return num1 - num2;
		}else{
			return num2 - num1;
		}
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		try {		
			Scanner cin = new Scanner(new File("C:/Users/zhourunfeng/Desktop/test/sample_input2_1.txt"));
			int caseCount = cin.nextInt();
			System.out.println(caseCount);
			for(int i = 1; i <= caseCount; i++){
				int customerNum = cin.nextInt();
				//System.out.println(customerNum);
				int homeX = cin.nextInt();
				//System.out.print(homeX + " ");
				int homeY = cin.nextInt();
				//System.out.print(homeY + " ");
				int officeX = cin.nextInt();
				//System.out.print(officeX + " ");
				int officeY = cin.nextInt();
				//System.out.print(officeY + " ");
				int[][] cunstomerArray = new int[customerNum][2];							
				for(int k = 0; k < customerNum; k++){
					for(int j = 0; j < 2; j++){
						cunstomerArray[k][j] = cin.nextInt();
						//System.out.print(cunstomerArray[k][j] + " ");
					}
				}
				//System.out.println();
				optimalPath = 999999;
				permutation(cunstomerArray, customerNum, 0, homeX, homeY, officeX, officeY);
			    System.out.println("#" + i + " " + optimalPath);
				
			}
			cin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("程序运行时间：" + (endTime-startTime) + "ms");
		

	}

}
