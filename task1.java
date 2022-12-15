package HW2;
import java.util.HashMap;
import java.util.Map;

public class task1 {
    public static String getWhere(HashMap<String,String> mylist){
        StringBuilder result = new StringBuilder();
        for(Map.Entry<String,String> entry : mylist.entrySet()){

            if(entry.getKey() == null || entry.getValue() == null ) continue;
            result.append(entry.getKey()).append(" = ").append(entry.getValue()).append(" and ");
        }
        if(result.length() > 5){
            result.delete(result.length() - 5,result.length());
        }
        return result.toString();


    }
    public static void main(String[] args) {

        HashMap<String,String> school = new HashMap<>();
        school.put("name","Ivanov");
        school.put("country","Russia");
        school.put("city","Moscow");
        school.put("age",null);
        System.out.println(getWhere(school));

    }
    
}
