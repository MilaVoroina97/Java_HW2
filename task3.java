package HW2;
//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] 
//получил [оценка] по предмету [предмет].

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class task3 {

    public static StringBuilder rd(String file) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while((str = br.readLine()) != null){
            stringBuilder.append(str);
            stringBuilder.append(ls);
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        br.close();
        return stringBuilder;
        }

        public static Map<String,String> makeMap(String info){
            Map<String,String> student = new HashMap<String,String>();
            String[] student_info = info.split(",");
            for(String part: student_info){
                String[] parts = part.split(":");
                String keys = parts[0].trim();
                String values = parts[1].trim();
                student.put(keys, values);

            }
            return student;
        }

        public static void print_info(Map<String,String> students){
            System.out.printf("Student %s get mark %s on subject %s",students.get("Surname"),students.get("Mark"),students.get("Subject"));
            System.out.println();
        }

        public static void main(String[] args)throws Exception{
            StringBuilder s = rd("task3.json");
            String temp = s.toString();
            temp = temp.replaceAll("\\{","");
            temp = temp.replaceAll("\\}", "");
            temp = temp.replaceAll("\\[", "");
            temp = temp.replaceAll("\\]", "");
            temp = temp.replaceAll("\"", "");
            int index = temp.indexOf("Surname",2);
            String s1 = temp.substring(0,index-1);
            int index1 = temp.indexOf("Surname", index+1);
            String s2 = temp.substring(index, index1-1);
            int index2 = temp.lastIndexOf("Surname");
            String s3 = temp.substring(index2,temp.length()-1);
            Map<String,String> student1 = makeMap(s1);
            Map<String,String> student2 = makeMap(s2);
            Map<String,String> student3 = makeMap(s3);
            print_info(student1);
            print_info(student2);
            print_info(student3);
            
    }
}

