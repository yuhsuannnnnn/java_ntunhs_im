package hw9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class hw9 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Integer> numbers = new ArrayList<>();
		
		System.out.println("�п�J�Ʀr�A��J�D�Ʀr����:");
		while(scanner.hasNextInt()) {
			int num = scanner.nextInt();
			numbers.add(num);
			scanner.nextLine();
		}
		
		Collections.sort(numbers);
		
		int max = numbers.get(numbers.size() - 1);
		int min = numbers.get(0);
		double sum = 0;
		for(int num : numbers) {
			sum += num;
		}
		double average = sum / numbers.size();
		
		System.out.println("�Ƨǫ᪺�Ʀr:");
		for(int num : numbers) {
			System.out.print(num + " ");
		}
		System.out.println("\n�̤j��:" + max); // �ץ�����
		System.out.println("�̤p��:" + min);
		System.out.println("������:" + average);
		
	}

}
