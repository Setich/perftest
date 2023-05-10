package my.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Task2 {

    private int inputFromKeyboard(){
        System.out.println("Введите нечетное число, которое меньше или равное 3  ");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String input;
            while ((input = reader.readLine()) != null) {
                if (Integer.parseInt(input) < 2 || Integer.parseInt(input) % 2 == 0) {
                    System.out.println("Вы ввели не верное число, число должно быть нечетным и не меньше числа 3 ");
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

    private double[][] fillingTheArray(int inputNumber) {
        double[][] array = new double[inputNumber][inputNumber];

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Math.round(random.nextDouble() * 99.99 * 100.0) / 100.0;
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t          ");
            }
            System.out.println();
        }
       return array;
    }

    private void minimalElement(double[][] doubleArray){
        ArrayList<Double> arrayList = new ArrayList<>();

        for (int i = 0; i < doubleArray.length; i++) {
            if (i != doubleArray.length / 2) {
                for (int j = 0; j < doubleArray[i].length;) {
                    arrayList.add(doubleArray[i][doubleArray[j].length - 1 - i]);
                    break;
                }
            }
        }

        System.out.println(Collections.min(arrayList));
    }

    public void start(){
        minimalElement(fillingTheArray(inputFromKeyboard()));
    }
}
