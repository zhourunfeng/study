package study;

import java.io.File;
import java.util.Scanner;

public class test {
	
	public static int charBinary(char[] array){
		int num = 0;
		for(int i = 0; i < array.length; i++){
			num += (array[i] - '0')<<(array.length - i - 1);
		}
		return num;
	}
	
	
	

public static void main(String[] args) {
	
		long startTime = System.currentTimeMillis();
		try {		
			Scanner cin = new Scanner(new File("C:/Users/admin/Desktop/test/sample_input1_2.txt"));
			int caseCount = cin.nextInt();
			System.out.println(caseCount);
			while (cin.hasNextLine()) {
				int row = cin.nextInt();
				int column = cin.nextInt();
				char[][] codeArray;
				String tempString = "";
				codeArray = new char[row][column];
				System.out.println(row + " " + column);
				cin.nextLine();
				for(int i = 0; i < row; i ++){
					tempString = cin.nextLine();
					codeArray[i] = tempString.toCharArray();
					System.out.println(tempString);
				}
				
				
			}
			cin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("程序运行时间：" + (endTime-startTime) + "ms");
    /**
	String str = "1011110001101011101100110010111011011101101110110011001";
	char[] test = str.toCharArray();
	System.out.println(test.length);
	System.out.println(charBinary(test));
	**/
	}

}
