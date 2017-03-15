package study;

import java.util.UUID;

public class RandomTest {
	final static int UUIDNUM = 32;
	
	public static String randomString(int length){
		if(length<0){
			return null;
		}
		StringBuffer tempBuffer = new StringBuffer();	
		int loopCount = length/UUIDNUM;
		int num = length%UUIDNUM;
		for(int i=0; i < loopCount; i++){
			tempBuffer.append(uuidString());
		}
		tempBuffer.append(uuidString().substring(0, num));		
		return tempBuffer.toString();
	}

	private static String uuidString(){
		return UUID.randomUUID().toString().replace("-","");
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();//获取当前时间
		System.out.println(randomString(13456));
		long endTime = System.currentTimeMillis();
		System.out.println("程序运行时间："+(endTime-startTime)+"ms");
		System.out.println('s'-'1');


	}

}
