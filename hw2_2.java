package hw2_2;

import java.util.Scanner;
import java.util.Random;

public class hw2_2 {

	public static void main(String[] args) {
		Random rand = new Random(10);
		int ans=rand.nextInt(100);
		int guess=0;
		int max=100;
		int min=1;		
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.print("請輸入數字");
			guess=sc.nextInt();
			
			int validate_num=ans-guess;
			if(guess<min || guess>max) {
				System.out.print("你確定嗎?");
			}
			else {if(validate_num>0) {
				System.out.print("你猜的答案太小了");
				min=guess;
			}else if(validate_num<0) {
				System.out.print("你猜的答案太大了");
				max=guess;
			}else {
				System.out.print("你猜對答案了");
				break;
			}
		}

	}
	}
}
		


