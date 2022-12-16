
package HW2;
import java.util.Random;
import java.util.logging.*;
import java.io.IOException;
// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
public class task2 {

        private static Logger logger = null;
        static
        {
            System.setProperty(
                "java.util.logging.SimpleFormatter.format",
                "[%1$tF %1$tT] [%4$-7s] %5$s %n");
            logger = Logger.getLogger(
                task2.class.getName());
        }

    public static void main(String[] args) {
        try{
            LogManager.getLogManager().readConfiguration(
                new FileInputStream(
                    "mylogging.properties"));


        } catch (SecurityException | IOException ex) {
            logger.log(Level.SEVERE,"Security exception message ",ex);
        }

        logger.setLevel(Level.FINE);
        logger.addHandler(new ConsoleHandler());
        try{
            FileHandler fileHandler
            = new FileHandler("iter.log", true);
        SimpleFormatter sFormat = new SimpleFormatter();
        fileHandler.setFormatter(sFormat);
        logger.addHandler(fileHandler);
        logger.log(Level.CONFIG,
                              "Config data is set");
    }
        catch(SecurityException | IOException e) {
            logger.log(Level.SEVERE,"Cannot make a file",e);
        }

        try{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any integer number: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        String res = "";
        for(int i = 0; i < n ; i++){
            arr[i] = new Random().nextInt(100);
            res = Integer.toString(arr[i]);
            logger.info("Number before iteration "+res);
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
                    logger.info("Number after iteration "+String.valueOf(arr[j]));
                    logger.info("Number after iteration "+String.valueOf(arr[j+1]));
            
                }
            }
        }
        System.out.println();
        for(int elem: arr){
            System.out.println(elem);
        }
        sc.close();
    }catch (Exception exp){
        logger.log(Level.SEVERE,"User enter error",exp);
    }


        }
}
