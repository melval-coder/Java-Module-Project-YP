



import java.util.Scanner;
public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int people = allPeople();
        calculator.allProduct();
        calculator.conclusion(allPeople());
    }
    public static int allPeople() {

        int people = 0;
        while (true) {
            System.out.println("На какое количество человек вы планируете разделить счёт?");
            if (scanner.hasNextInt()) {
                people = scanner.nextInt();
            } else {
                scanner.nextLine();
            }
            if (people > 1) {
                break;
            }
            if (people == 1) {
                System.out.println("Число человек должно быть больше 1");
            }else
                System.out.println("Серьёзно!");
        }
        return people;
    }
}
class Calculator {
    String products;
    double costOfGoods;

    public Calculator() {
        products = "";
        costOfGoods = 0.0;
    }
    public void allProduct() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название товара");
            String product = scanner.nextLine();
            if (!product.equalsIgnoreCase("завершить")) {
                products += product + "\n";
                System.out.println("Введите стоимость товара");
                double cost = addCost();
                costOfGoods += cost;
                System.out.println("Товар успешно добавлен.\nДобавить ещё товар?\nДля выхода введите\"завершить\"");
            } else {
                break;
            }
        }
    }
    public double addCost() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextDouble()) {
                double cost = scanner.nextDouble();
                if (cost > 0) {
                    return cost;
                } else {
                    System.out.println("Попробуйте ещё");
                }
            } else {
                System.out.println("Введите сумму");
            }
        }
    }

    public static String rubleS(double cost) {
        if ((int) cost % 100 / 10 == 1) {
            return "рублей";
        }
        if ((int) cost % 10 == 1) {
            return "рубль";
        } else if ((int) cost % 10 == 2 || (int) cost % 10 == 3 || (int) cost % 10 == 4) {
            return "рубля";
        }
        return "рублей";
    }
    public void conclusion(int people) {
        System.out.println("Добавленные товары\n" + products);
        System.out.printf("Сумма к оплате: %.2f \n", costOfGoods);
        System.out.printf("Каждый заплатит\n%.2f %s", costOfGoods / people, rubleS(people));

    }
}