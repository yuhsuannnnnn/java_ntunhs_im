package hw9_2;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class hw9_2 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> phoneNumbers = new HashSet<>();

        System.out.println("�п�J������X�A��J 0 ����:");

        while (true) {
            String phoneNumber = scanner.nextLine().trim();

            if (phoneNumber.equals("0")) {
                break;
            }

            phoneNumbers.add(phoneNumber);
        }

        System.out.println("�`�@��J�F " + phoneNumbers.size() + " �Ӥ�����X:");

        System.out.println("�Ҧ���J��������X��:");
        for (String number : phoneNumbers) {
            System.out.println(number);
        }
    }
	

}
