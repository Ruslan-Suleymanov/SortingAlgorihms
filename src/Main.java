import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ruslaanko on 25.04.17.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] unsortedArray = {2, 1, 4, 8, 7, 5, 6, 3};

        unsortedArray = createShuffledArray(10000);
        Integer[] sortedArray = createSortedArray(1000);

        choiceSort(unsortedArray);
//        choiceSort(sortedArray);

        bubbleSort(unsortedArray);
//        bubbleSort(sortedArray);

        insertSort(unsortedArray);
//        insertSort(sortedArray);
    }

    private static void choiceSort(Integer[] arrayToSort) {

        System.out.println("Сортировка выбором");

        Integer[] array = Arrays.copyOf(arrayToSort, arrayToSort.length);
        //пройти по массиву
        //найти минимальный элемент
        //поменять местами 1 и минимальный элемент
        //
        //повторять пока не пройдем по всему массиву
        long start = System.nanoTime();

        int indexMin;

        for (int index = 0; index < array.length - 1; index++) {
            indexMin = index;

            for (int indexForScan = index; indexForScan < array.length; indexForScan++) {
                if (array[indexMin] > array[indexForScan]) {
                    indexMin = indexForScan;
                }
            }

            int temp = array[index];
            array[index] = array[indexMin];
            array[indexMin] = temp;

        }
        long stop = System.nanoTime();
        System.out.println("Время выполнения: " + (stop - start));
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(Integer[] arrayToSort) {

        Integer[] array = Arrays.copyOf(arrayToSort, arrayToSort.length);

        System.out.println("Сортировка пузырьком");
        //проходим по массиву
        //сравнивам два соседних элемента, если первый элемент больше второго - меням их местами
        //повторяем, пока массив не будет отсортирован

        long start = System.nanoTime();
        int changeCounter;
        do {
            changeCounter = 0;
            for (int index = 0; index < array.length - 1; index++) {

                if (array[index] > array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                    changeCounter++;
                }

            }
        } while (changeCounter > 0);

        long stop = System.nanoTime();
        System.out.println("Время выполнения: " + (stop - start));
        System.out.println(Arrays.toString(array));
    }

    private static void insertSort(Integer[] arrayToSort) {

        Integer[] array = Arrays.copyOf(arrayToSort, arrayToSort.length);

        System.out.println("Сортировка вставкой");

        //проходим по массиву
        // выбираем элемент

        //ставим элемент на его место
        long start = System.nanoTime();

        int element;
        int indexToInsert;
        for (int index = 0; index < array.length; index++) {
            element = array[index];

            indexToInsert = index;

            while (indexToInsert > 0
                    && array[indexToInsert - 1] > element) {
                array[indexToInsert] = array[indexToInsert - 1];
                indexToInsert--;
                array[indexToInsert] = element;
            }
        }
        long stop = System.nanoTime();
        System.out.println("Время выполнения: " + (stop - start));
        System.out.println(Arrays.toString(array));
    }



    public static Integer[] createShuffledArray(int lenght) {
        Integer[] arrayToSort = new Integer[lenght];

        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < lenght; i++) {
            temp.add(i);
        }

        Collections.shuffle(temp);
        return temp.<Integer>toArray(arrayToSort);
    }

    public static Integer[] createSortedArray(int lenght) {
        Integer[] array = new Integer[lenght];

        for (int i = 0; i < lenght; i++) {
            array[i] = i;
        }

        return array;
    }


}
