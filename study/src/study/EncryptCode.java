package study;

import java.io.File;
import java.util.Scanner;


public class EncryptCode {
	
	public static final int NUM_0 = 13;
	public static final int NUM_1 = 25;
	public static final int NUM_2 = 19;
	public static final int NUM_3 = 61;
	public static final int NUM_4 = 35;
	public static final int NUM_5 = 49;
	public static final int NUM_6 = 47;
	public static final int NUM_7 = 59;
	public static final int NUM_8 = 55;
	public static final int NUM_9 = 11;
	public static final int BLOCKNUM = 56;
	public static final int ANSWERCOUNT = 8;
	public static final int ANSWERLENGTH = 7;
	public static int[] result = new int[ANSWERCOUNT];
	public static char[] validData = new char[BLOCKNUM]; 

	public static void charBinary(char[] array){
		for(int i = 0; i < ANSWERCOUNT; i++){
			int num = 0;
			for(int j = 0; j < ANSWERLENGTH; j++){
				num = array[j + i * ANSWERLENGTH] - '0' + num * 2;
			}
			switch (num) {
			case NUM_0:
				result[i] = 0;
				break;
			case NUM_1:
				result[i] = 1;
				break;
			case NUM_2:
				result[i] = 2;
				break;
			case NUM_3:
				result[i] = 3;
				break;
			case NUM_4:
				result[i] = 4;
				break;
			case NUM_5:
				result[i] = 5;
				break;
			case NUM_6:
				result[i] = 6;
				break;
			case NUM_7:
				result[i] = 7;
				break;
			case NUM_8:
				result[i] = 8;
				break;
			case NUM_9:
				result[i] = 9;
				break;
			default:
				System.out.println("Wrong number!");
				break;
			}
		}
	}
	
	public static int decodeResult(int[] result){
		int assertNum = (result[0] + result[2] + result[4] + result[6]) * 3 + result[1] + result[3] + result[5] + result[7];
		if((assertNum % 10) == 0){
			return result[0] + result[2] + result[4] + result[6] + result[1] + result[3] + result[5] + result[7];
		}else{
			return 0;
		}
	}
	
	public static void filterData(char[][] code, int row, int column){
		int rowIndex = 0;
		int columnIndex = 0;
		for(int i = 0; i < row; i++){
			for(int j = column - 1; j >= BLOCKNUM - 1; j--){
				if(code[i][j] == '1'){
					rowIndex = i;
					columnIndex = j;
					break;                                                                                                              
				}
			}
			if(columnIndex != 0){
				break;
			}
		}
		for(int k = 0, m = columnIndex - BLOCKNUM + 1; k < 56; k++, m++){
			validData[k] = code[rowIndex][m];
		}
	}
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		try {		
			Scanner cin = new Scanner(new File("C:/Users/zhourunfeng/Desktop/test/sample_input1_2.txt"));
			int caseCount = cin.nextInt();
			System.out.println(caseCount);
			for(int i = 1; i <= caseCount; i++){
				int row = cin.nextInt();
				int column = cin.nextInt();
				cin.nextLine();
				char[][] codeArray;
				String tempString = "";
				codeArray = new char[row][column];
				//System.out.println(row + " " + column);				
				for(int j = 0; j < row; j++){
					tempString = cin.nextLine();
					codeArray[j] = tempString.toCharArray();
					//System.out.println(tempString);
				}
				filterData(codeArray, row, column);
				charBinary(validData);
				int value = decodeResult(result);
			    System.out.println("#" + i + " " + value);
				
			}
			cin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("程序运行时间：" + (endTime-startTime) + "ms");

	}

}
