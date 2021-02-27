import java.util.Scanner;

public class MainTask {
    public static void main (String[] args) {

        /*1.Приветствовать любого пользователя при вводе его
        имени через командную строку.*/

        Scanner welcomeUser = new Scanner(System.in);
        System.out.print("Input name:");
        String name = welcomeUser.nextLine();
        System.out.printf("Hello %s", name);

        /*2.Отобразить в окне консоли аргументы командной строки в
        обратном порядке.*/

        Scanner argReverse = new Scanner(System.in);
        System.out.print("Input smth:");
        String reverseOrder = argReverse.nextLine();
        String reverse = new StringBuffer(reverseOrder).reverse().toString();
        System.out.println("после реверса: " + reverse);

        /*3.Вывести заданное количество случайных чисел с переходом
        и без перехода на новую строку*/

        int a = 2;
        int b = 19;
        for (int i = 0; i < 10; i++) {
            int x = a + (int) (Math.random() * ((b - a) + 1));
            System.out.println(x);
        }
        for (int i = 0; i < 10; i++) {
            int y = a + (int) (Math.random() * ((b - a) + 1));
            System.out.print(y + " ");
        }

       /* 4.Ввести целые числа как аргументы командной строки, подсчитать
       их сумму (произведение) и вывести результат на консоль.*/

          Scanner wholeNumbers = new Scanner(System.in);
          System.out.print("Input number a:");
          int numberA = wholeNumbers.nextInt();
          System.out.print("Input number b:");
          int numberB = wholeNumbers.nextInt();
          System.out.print(numberA + numberB);

        /*5.Ввести число от 1 до 12. Вывести на консоль название месяца,
        соответствующего данному числу. Осуществить проверку корректности
        ввода чисел.*/

        Scanner oneToTwelve = new Scanner(System.in);
        System.out.print("Input number of month:");
        int numberOfMonth = oneToTwelve.nextInt();
        String month;
        switch (numberOfMonth) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                month = "Invalid month";
                break;
        }
        System.out.print(month);
    }

}

