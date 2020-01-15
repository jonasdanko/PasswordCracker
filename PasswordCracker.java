import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class PasswordCracker {

    public String crackPassword(String encryptedPassword, DatabaseInterface database){

        String decryptedPassword = database.decrypt(encryptedPassword);
        //return the decrypted password found from database.
        return decryptedPassword;

    }

    public void createDatabase(ArrayList<String> commonPasswords, DatabaseInterface database){

        for(String password : commonPasswords){
            try {
                database.save(password, Sha1.hash(password));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        for(String password : commonPasswords){
            StringBuffer s = new StringBuffer();
            s.append(Character.toUpperCase(password.charAt(0)));
            String sub = password.substring(1);
            s.append(sub);
            String newPass = s.toString();
            try {
                database.save(newPass, Sha1.hash(newPass));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        for(String password : commonPasswords){
            String newPass = password + "2018";
            try {
                database.save(newPass, Sha1.hash(newPass));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        for(String password : commonPasswords){
            String newPass = password.replace('a', '@');
            try {
                database.save(newPass, Sha1.hash(newPass));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        for(String password : commonPasswords){
            String newPass = password.replace('e', '3');
            try {
                database.save(newPass, Sha1.hash(newPass));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        for(String password : commonPasswords){
            String newPass = password.replace('i', '1');
            try {
                database.save(newPass, Sha1.hash(newPass));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        for(String password : commonPasswords){
            StringBuffer s = new StringBuffer();
            s.append(Character.toUpperCase(password.charAt(0)));
            String sub = password.substring(1);
            s.append(sub);
            String newPass = s.toString()+"2018";
            newPass = newPass.replace('a', '@');
            newPass = newPass.replace('i', '1');
            newPass = newPass.replace('e', '3');
            try {
                database.save(newPass, Sha1.hash(newPass));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        for(String password : commonPasswords){
            String newPass = password.replace('a', '@');
            newPass = newPass.replace('i', '1');
            newPass = newPass.replace('e', '3');
            try {
                database.save(newPass, Sha1.hash(newPass));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        for(String password : commonPasswords){
            String newPass = password.replace('a', '@');
            newPass = newPass.replace('i', '1');
            newPass = newPass.replace('e', '3');
            newPass = newPass + "2018";
            try {
                database.save(newPass, Sha1.hash(newPass));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }


    }
}
