package xiii.geekbrains.lesson_9;

/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
   При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
   Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
   должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
   и вывести результат расчета.
*/

import xiii.geekbrains.lesson_9.exceptions.MyArrayDataException;
import xiii.geekbrains.lesson_9.exceptions.MyArraySizeException;

public class Lesson_9_DZ {
    public static void main(String[] args) {
        String[][] arrayOfStrings = new String[4][4];
        try {
            System.out.println(arrayStringsToIntegers(arrayOfStrings));
        } catch (MyArraySizeException e) {
            System.out.println("Размер массива не [4][4]. Mission failed");
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println("Невозможно преобразовать элемент массива в int. Mission failed");
            e.printStackTrace();
        }
    }

    public static int arrayStringsToIntegers(String[][] array4x4) throws MyArraySizeException, MyArrayDataException {
        if (array4x4.length > 4 || array4x4[0].length > 4) {
            throw new MyArraySizeException("Размер массива не соответствует размеру [4][4]");
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array4x4[i][j] = String.valueOf(i + j);
                //array4x4[3][3] = "***" + (i + j); // раскомментировать строку для проверки MyArrayDataException
                try {
                    sum += Integer.parseInt(array4x4[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Невозможно преобразовать в int элемент массива [" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }
}


