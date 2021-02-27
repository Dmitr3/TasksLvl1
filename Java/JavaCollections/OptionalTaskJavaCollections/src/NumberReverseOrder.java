// Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class NumberReverseOrder {

    public static void main(String[] args) {

            Stack stack = new Stack();
            int n=0;
            System.out.println("Введите число ");
            Scanner sc1 = new Scanner(System.in);
            try {
                n = sc1.nextInt();
            } catch (InputMismatchException fg)
            {
                System.out.print("Вы ввели не число." );
            }

            char [] numbers = String.valueOf(n).toCharArray();
            for(char num : numbers){
                stack.push(num);
            }

            while(!stack.empty()) {
                char stackNum;
                stackNum = (Character)stack.pop();
                System.out.print(stackNum);
            }
    }

}
