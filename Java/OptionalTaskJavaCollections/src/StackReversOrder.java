// Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.Scanner;

public class StackReversOrder {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        try (Scanner scan = new Scanner(new File("input.txt"));
             FileWriter writer = new FileWriter(new File("output.txt"))) {

            // input
            while (scan.hasNextLine()) {
                stack.push(scan.nextLine());
            }

            // output
            int lim = stack.size();
            for (int i = 0; i < lim; i++) {
                writer.write(stack.pop() + "\n");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
