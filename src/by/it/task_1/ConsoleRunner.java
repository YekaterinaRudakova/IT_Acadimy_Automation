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
            expression = expression.trim();
            switch (expression) {
                case "+":
                case "-":
                case "*":
                case "/":
                    break;
                default:
                    System.out.println("Вы ввели некорректный математический знак операции");
                    continue;
            }
            for (; ; ) {
                System.out.print("Введите первое число: ");
                String firstNumber = scanner.nextLine();
                try {
                    firstDouble = parseToDouble(firstNumber);
                } catch (NumberFormatException e) {
                    System.out.println("Вы ввели некорректные данные!");
                    continue;
                }
                break;
            }
            for (; ; ) {
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
                break;
            }
            Calculator calc = new Calculator();
            switch (expression) {
                case "+" -> {
                    double result = calc.add(firstDouble, secondDouble);
                    System.out.printf("Сумма чисел равна: %.2f%n", result);
                    break label;
                }
                case "-" -> {
                    double result = calc.sub(firstDouble, secondDouble);
                    System.out.printf("Разница чисел равна: %.2f%n", result);
                    break label;
                }
                case "*" -> {
                    double result = calc.mul(firstDouble, secondDouble);
                    System.out.printf("Произведение чисел равно: %.2f%n", result);
                    break label;
                }
                case "/" -> {
                    double result = calc.div(firstDouble, secondDouble);
                    System.out.printf("Частное чисел равно: %.2f%n", result);
                    break label;
                }
            }
        }
    }

    private static double parseToDouble(String inputNumber) throws NumberFormatException {
        return Double.parseDouble(inputNumber);
    }
}
