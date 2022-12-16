package HW2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.logging.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class task4 {

    public static String addSpaces(String exp){
        exp = exp.replaceAll("(?<=[0-9()])[\\/]", " / ");
        exp = exp.replaceAll("(?<=[0-9()])[\\^]", " ^ ");
        exp = exp.replaceAll("(?<=[0-9()])[\\*]", " * ");
        exp = exp.replaceAll("(?<=[0-9()])[+]", " + "); 
        exp = exp.replaceAll("(?<=[0-9()])[-]", " - ");
        exp = exp.replaceAll(" {2,}", " ");
    
           return exp;
    }
    public static int calculator(String ex){
        String exp = addSpaces(ex);
        List<Integer> nums = new ArrayList<>();
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(exp);
        while(matcher.find()) {
            String s = matcher.group(0);
            if (s.replaceAll("\\D", "").length() == s.length()) {
                nums.add(Integer.parseInt(s));
            }
        }
        int res = 0;
        if(exp.contains("+") == true){
            res = nums.get(0) + nums.get(1);
        }else if(exp.contains("-") == true){
            res = nums.get(0) - nums.get(1);
        }else if(exp.contains("*") == true){
            res = nums.get(0) * nums.get(1);
        }else if(exp.contains("/") == true){
            res = nums.get(0) / nums.get(1);
        }else if(exp.contains("^") == true){
            res = (int) Math.pow(nums.get(0),nums.get(1));
        }

        else{
            System.out.println("Такой операции нет или возможно Вы неверно ввели выражение, выражение должно быть в формате 8 + 6");
            logger.log(Level.SEVERE,"User input error");

        }
        return res;
}
        private static Logger logger = null;
        static
        {
            System.setProperty(
                "java.util.logging.SimpleFormatter.format",
                "[%1$tF %1$tT] [%4$-7s] %5$s %n");
            logger = Logger.getLogger(
                task4.class.getName());
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
            = new FileHandler("calculator.log", true);
        SimpleFormatter sFormat = new SimpleFormatter();
        fileHandler.setFormatter(sFormat);
        logger.addHandler(fileHandler);
        logger.log(Level.CONFIG,
                              "Config data is set");
    }
        catch(SecurityException | IOException e) {
            logger.log(Level.SEVERE,"Cannot make a file",e);
        }

            Scanner iScanner = new Scanner(System.in);
            System.out.println("Введите,пожалуйста, числовое выражение,состоящие из двух цифр и операции: ");
            String a = iScanner.nextLine();
            logger.log(Level.INFO,"Expression from user " + a);
            int result = calculator(a);
            logger.log(Level.INFO,"Result of calculation: " + String.valueOf(result));
            System.out.printf("Результат выражения %s = %d",a,result);
            iScanner.close();
    }
    
}
