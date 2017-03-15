package study;

public class Permutation {  
    public static void permutation(int[]ss,int i){  
         
        if(i==ss.length){  
            for(int k = 0; k < ss.length; k++){
            	System.out.print(ss[k]);
            }
            System.out.println();
        }else{  
            for(int j=i;j<ss.length;j++){  
                int temp=ss[j];//交换前缀,使之产生下一个前缀  
                ss[j]=ss[i];  
                ss[i]=temp;  
                permutation(ss,i+1);  
                temp=ss[j]; //将前缀换回来,继续做上一个的前缀排列.  
                ss[j]=ss[i];  
                ss[i]=temp;  
            }  
        }  
    }  
    public static void main(String args[]){  
        int []ss={1,2,3,4};  
        permutation(ss,0);  
    }  
} 