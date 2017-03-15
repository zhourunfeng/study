package study;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

public class BalancedPoint {
	
	public static double getBalancedPoint(double[][] pointArray, int pointNum){
		return calculateBalancePoint(pointArray, pointNum, pointArray[0][0], pointArray[pointNum-1][0]);
	}

	public static double calculateBalancePoint(double[][] pointArray, int pointNum, double left, double right){
		double balancePoint = left + (right - left)/2;
		double force = 0;
		while (right - left >= 0.0000000001) {
			for(int i =0; i < pointNum; i++){
				if(balancePoint > pointArray[i][0]){
					force += pointArray[i][1]/((balancePoint-pointArray[i][0])*(balancePoint-pointArray[i][0]));
				}
				if(balancePoint < pointArray[i][0]){
					force -= pointArray[i][1]/((balancePoint-pointArray[i][0])*(balancePoint-pointArray[i][0]));
				}
			}
			if(force > 0){
				return calculateBalancePoint(pointArray, pointNum, balancePoint, right);
			}else if (force < 0) {
				return calculateBalancePoint(pointArray, pointNum, left, balancePoint);
			}else {
				break;
			}
		}
		return balancePoint;
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		try {		
			Scanner cin = new Scanner(new File("C:/Users/zhourunfeng/Desktop/test/sample_input2_2.txt"));
			int caseCount = cin.nextInt();
			System.out.println(caseCount);
			for(int i = 1; i <= caseCount; i++){
				int pointNum = cin.nextInt();
				//System.out.println(pointNum);
				double[][] pointArray = new double[pointNum][2];							
				for(int j = 0; j < 2; j++){
					for(int k = 0; k < pointNum; k ++){
						pointArray[k][j] = cin.nextDouble();
						//System.out.print(pointArray[k][j] + " ");
					}
				}
				//System.out.println();
				double result = getBalancedPoint(pointArray, pointNum);
				DecimalFormat dFormat = new DecimalFormat("#.0000000000");
			    System.out.println("#" + i + " " + dFormat.format(result));
				
			}
			cin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("程序运行时间：" + (endTime-startTime) + "ms");

	}

}
