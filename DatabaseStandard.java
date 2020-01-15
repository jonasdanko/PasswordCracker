import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class DatabaseStandard implements DatabaseInterface {

    private HashMap<String, String> map;
    private int initial;

    public DatabaseStandard(){
        map = new HashMap<>();
        initial = 16;
    }

    @Override
    public String save(String plainPassword, String encryptedPassword) {
        map.put(encryptedPassword, plainPassword);
        return encryptedPassword;
    }

    @Override
    public String decrypt(String encryptedPassword) {
        String decryptedPassword = map.get(encryptedPassword);
        //System.out.println(decryptedPassword);
        if(decryptedPassword == null){
            return "";
        }
        else{
            return decryptedPassword;
        }

    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void printStatistics() {
        System.out.println("*** DatabaseStandard Statistics ***");
        System.out.println("Size is " + size() + " passwords.");
        System.out.println("*** End DatabaseStandard Statistics ***");
    }
}
