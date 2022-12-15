
package HW2;
import java.util.Random;
// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
import java.util.Scanner;
public class task2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any integer number: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = new Random().nextInt(100);

        }
        for(int i : arr){
            System.out.println(i);
        }

        for(int k = 0; k < n -1; k++){
            for(int j = 0; j < n -1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println();
        for(int elem: arr){
            System.out.println(elem);
        }



    }



    
}
