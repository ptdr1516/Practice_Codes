public class BubbleSortGeneric<T extends Comparable<? super T>> {
    public static void main(String[] args) {
        String[] arrOfStrings = {"Andree", "Leana", "Faviola", "Loyce", "Quincy", "Milo", "Jamila", "Toccara", "Nelda", "Blair", "Ernestine", "Chara", "Kareen", "Monty", "Rene", "Cami", "Winifred", "Tara", "Demetrice", "Azucena"};
        BubbleSortGeneric<String> strSorter = new BubbleSortGeneric<>();
        strSorter.bubbleSort(arrOfStrings);
        System.out.println(java.util.Arrays.toString(arrOfStrings));

        Double[] arrOfDoubles = {0.35, 0.02, 0.36, 0.82, 0.27, 0.49, 0.41, 0.17, 0.30, 0.89, 0.37, 0.66, 0.82, 0.17, 0.20, 0.96, 0.18, 0.25, 0.37, 0.52};
        BubbleSortGeneric<Double> doubleSorter = new BubbleSortGeneric<>();
        doubleSorter.bubbleSort(arrOfDoubles);
        System.out.println(java.util.Arrays.toString(arrOfDoubles));
    }

    void bubbleSort(T[] arr) {
        int n = arr.length;

        while (n > 0){
            int LastModifiedIndex = 0;
            for (int currentIndex = 1; currentIndex < n; currentIndex++){
                if(arr[currentIndex - 1].compareTo(arr[currentIndex]) > 0){
                    T temp = arr[currentIndex - 1];
                    arr[currentIndex - 1] = arr[currentIndex];
                    arr[currentIndex] = temp;

                    LastModifiedIndex = currentIndex;
                }
            }
            n = LastModifiedIndex;
        }

    }
}
