import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int people = allPeople();
        calculator.allProduct();
        calculator.conclusion(people);
    }
    public static int allPeople() {
        System.out.println("На какое количество человек вы планируете разделить счёт?");
        int people = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                people = scanner.nextInt();
            } else {
                scanner.next();
            }
            if (people > 1) {
                break;
            } else if (people == 1) {
                System.out.println("Число человек должно быть больше 1");
            } else
                System.out.println("Серьёзно!");
        }
        return people;
    }
}
