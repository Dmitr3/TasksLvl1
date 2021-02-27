import java.util.Scanner;
import java.util.Arrays;

public class OptionalTask {
    public static void main (String[] args) {

//      Задание. Ввести n чисел с консоли.
        Scanner s = new Scanner(System.in);

        int count = s.nextInt();
        s.nextLine(); // throw away the newline.

        int[] numbers = new int[count];
        Scanner numScanner = new Scanner(s.nextLine());
        for (int i = 0; i < count; i++) {
            if (numScanner.hasNextInt()) {
                numbers[i] = numScanner.nextInt();
            } else {
                System.out.println("You didn't provide enough numbers");
                break;
            }
        }
        System.out.println(Arrays.toString(numbers));

        /*1.Найти самое короткое и самое длинное число. Вывести найденные
        числа и их длину.*/
        int length = String.valueOf(numbers).length();
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i = 0; i<numbers.length; i++) {
            if(numbers[i]<low)
                low = numbers[i];
            else if(numbers[i]>high)
                high = numbers[i];
        }

        System.out.println("Largest is "+high + " " + Integer.toString(high).length());
        System.out.println("Smallest is "+low + " " + Integer.toString(low).length());

        /*2.Вывести числа в порядке возрастания (убывания)
        значений их длины.*/

        for(int i = numbers.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( numbers[j] > numbers[j+1]){
                    int tmp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = tmp;
                }
            }
        }
        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }

    }
}
