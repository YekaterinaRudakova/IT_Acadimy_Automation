package by.it.task_1;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        double firstDouble;
        double secondDouble;
        Scanner scanner = new Scanner(System.in);
        label:
        for (; ; ) {
            System.out.print("Введите знак операции: ");
            String expression = scanner.nextLine();
            switch (expression) {
                case "+":
                case "-":
                case "*":
                case "/":
                    break;
                default:
                    System.out.println("Вы ввели некорректный математический знак операции");
                    return;
            }

            System.out.print("Введите первое число: ");
            String firstNumber = scanner.nextLine();
            try {
                firstDouble = parseToDouble(firstNumber);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели некорректные данные!");
                continue;
            }
            System.out.print("Введите второе число: ");
            String secondNumber = scanner.nextLine();
            try {
                secondDouble = parseToDouble(secondNumber);
                if (expression.equals("/") & secondDouble == 0) {
                    System.out.println("На 0 делить нельзя!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели некорректные данные!");
                continue;
            }

            switch (expression) {
                case "+" -> {
                    double result = add(firstDouble, secondDouble);
                    System.out.printf("Сумма чисел равна: %.2f%n", result);
                    break label;
                }
                case "-" -> {
                    double result = sub(firstDouble, secondDouble);
                    System.out.printf("Разница чисел равна: %.2f%n", result);
                    break label;
                }
                case "*" -> {
                    double result = mul(firstDouble, secondDouble);
                    System.out.printf("Произведение чисел равно: %.2f%n", result);
                    break label;
                }
                case "/" -> {
                    double result = div(firstDouble, secondDouble);
                    System.out.printf("Частное чисел равно: %.2f%n", result);
                    break label;
                }
            }
        }
    }

    private static double parseToDouble(String inputNumber) throws NumberFormatException {
        return Double.parseDouble(inputNumber);
    }

    private static double add(double firstDouble, double secondDouble) {
        return firstDouble + secondDouble;
    }

    private static double sub(double firstDouble, double secondDouble) {
        return firstDouble - secondDouble;
    }

    private static double mul(double firstDouble, double secondDouble) {
        return firstDouble * secondDouble;
    }

    private static double div(double firstDouble, double secondDouble) {
        return firstDouble / secondDouble;
    }

}
