import java.util.Scanner;

public class Calculator {
    String products;
    double costOfGoods;

    public Calculator() {
        products = "";
        costOfGoods = 0.0;
    }

    public void allProduct() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите название товара");
            String product = scanner.nextLine();
            if (product.equalsIgnoreCase("завершить")) {
                break;
            }
            products += (product + "\n");
            System.out.println("Введите стоимость товара");
            double cost = addCost();
            costOfGoods += cost;
            System.out.println("Товар успешно добавлен.\nДобавить ещё товар?\nДля выхода введите:\"завершить\"");
        }
    }

    public double addCost() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextDouble()) {
                double cost = scanner.nextDouble();
                if (cost >= 0) {
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
        if ((int) (cost % 100 / 10) == 1) {
            return "рублей";
        }
        return switch ((int) cost % 10) {
            case 1 -> "рубль";
            case 2, 3, 4 -> "рубля";
            default -> "рублей";
        };
    }

    public void conclusion(int people) {
        System.out.println("Добавленные товары\n" + products);
        System.out.printf("Сумма к оплате: %.2f \n", costOfGoods);
        System.out.printf("Каждый заплатит\n%.2f %s", costOfGoods / people, rubleS(costOfGoods / people));
    }
}
