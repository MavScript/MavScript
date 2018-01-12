import java.util.Arrays;

public class bubblesort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 54, 53, 23, 43, 2};
        int len = 8;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}