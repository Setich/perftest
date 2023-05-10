package my.project;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Task {

    private int inputFromKeyboard() {
        System.out.println("Введите число от 10 до 99");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String input;
            while ((input = reader.readLine()) != null) {
                if (Integer.parseInt(input) < 10 || Integer.parseInt(input) > 99){
                    System.out.println("Вы ввели неверное число, число должно быть больше 9 и меньше 100, " +
                            "попробуйте ещё раз");
                } else {
                    break;
                }
            }
            assert input != null;
            return Integer.parseInt(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int[] fillingTheArray(int inputNumber){
        int[] fillingArray = new int[inputNumber];
        for (int i = 0; i < fillingArray.length; i++) {
            fillingArray[i] = (int) (Math.random() * 90) + 10;
        }
        for (int num : fillingArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        return fillingArray;
    }

    private LinkedHashSet<Integer> uniqueNumbers(int[] intArray){
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
        for (int i = 0; i < intArray.length; i++) {
            hashSet.add(intArray[i]);
        }

        for (int num : hashSet) {
            System.out.print(num + " ");
        }
        System.out.println();
    return hashSet;
    }

    private void countNumbers(LinkedHashSet<Integer> intList) {
        int count = 0;
        for (int counter : intList) {
            count += 1;
        }
        System.out.println(count);
    }

    public void start() {
        countNumbers(uniqueNumbers(fillingTheArray(inputFromKeyboard())));
    }
}
