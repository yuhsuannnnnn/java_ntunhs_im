package hw2_2;

import java.util.Scanner;
import java.util.Random;

public class hw2_2 
{
	public static void main(String[] args)
	 {
		Random rand =new Random();
		int ans=rand.nextInt(100);
		int guess=0;	
		Scanner sc = new Scanner(System.in);
		int max=100;
		int min=1;
		while (true) 
		{
			System.out.println("請輸入一個數字");
			guess=sc.nextInt();
			int validate_num=ans-guess;			
						

			if(validate_num>0)
			{
				System.out.println("輸入的數字太小了");
				min=guess;			
				System.out.print("數字介於"+min+"和"+max);			
				
			}
			else if (validate_num<0) 
			{
				System.out.println("輸入的數字太大了");
				max=guess;	
				System.out.print("數字介於"+min+"和"+max);
			}
			else
			{
				System.out.println("猜對囉");
				break;
			}
		}		
	}	
}
