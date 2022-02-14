import java.util.HashMap;

public class Maps {
    public static void main(String[] args) {
        // map is a key value pairs

        HashMap<String, Integer> empIds = new HashMap<>();

        empIds.put("John", 1243);
        empIds.put("Bob", 56565);

//        System.out.println("Here is my hashmap: " + empIds);


        System.out.println(empIds.get("Bob "));
    }
}
