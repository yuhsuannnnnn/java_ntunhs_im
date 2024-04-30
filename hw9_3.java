package hw9_3;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hw9_3 {
	private static final Map<String, Integer> scores = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("�п�ܾާ@�G");
            System.out.println("1. �s�W�ǥͦ��Z");
            System.out.println("2. �d�߾ǥͦ��Z");
            System.out.println("3. �ק�ǥͦ��Z");
            System.out.println("4. �R���ǥͦ��Z");
            System.out.println("5. �C�X�Ҧ��ǥͦ��Z");
            System.out.println("0. �h�X");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addScore();
                    break;
                case 2:
                    queryScore();
                    break;
                case 3:
                    modifyScore();
                    break;
                case 4:
                    deleteScore();
                    break;
                case 5:
                    listAllScores();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("�L�Ī���ܡI");
            }
        }
    }

    private static void addScore() {
        System.out.println("�п�J�ǥͩm�W�G");
        String name = scanner.nextLine();
        System.out.println("�п�J�ǥͦ��Z�G");
        int score = scanner.nextInt();
        scanner.nextLine(); // consume newline
        scores.put(name, score);
        System.out.println("�ǥ� " + name + " �����Z�w�s�W�I");
    }

    private static void queryScore() {
        System.out.println("�п�J�n�d�ߪ��ǥͩm�W�G");
        String name = scanner.nextLine();
        Integer score = scores.get(name);
        if (score != null) {
            System.out.println("�ǥ� " + name + " �����Z���G" + score);
        } else {
            System.out.println("�䤣��ǥ� " + name + " �����Z�I");
        }
    }

    private static void modifyScore() {
        System.out.println("�п�J�n�ק令�Z���ǥͩm�W�G");
        String name = scanner.nextLine();
        Integer score = scores.get(name);
        if (score != null) {
            System.out.println("�п�J�s�����Z�G");
            int newScore = scanner.nextInt();
            scanner.nextLine(); // consume newline
            scores.put(name, newScore);
            System.out.println("�ǥ� " + name + " �����Z�w�ק�I");
        } else {
            System.out.println("�䤣��ǥ� " + name + " �����Z�I");
        }
    }

    private static void deleteScore() {
        System.out.println("�п�J�n�R�����Z���ǥͩm�W�G");
        String name = scanner.nextLine();
        Integer score = scores.remove(name);
        if (score != null) {
            System.out.println("�ǥ� " + name + " �����Z�w�R���I");
        } else {
            System.out.println("�䤣��ǥ� " + name + " �����Z�I");
        }
    }

    private static void listAllScores() {
        System.out.println("�Ҧ��ǥͦ��Z�p�U�G");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println("�ǥ͡G" + entry.getKey() + "�A���Z�G" + entry.getValue());
        }
    }

}
