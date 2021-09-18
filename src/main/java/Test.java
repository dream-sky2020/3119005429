import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args){

        File f=new File(args[0]);
        String s1,s2;
        String[] s = new String[2];
        int i;
        try(BufferedReader fr=new BufferedReader(new FileReader(f))){
            s1= fr.readLine();
            s2= fr.readLine();
            while (s1!=null&&s2!=null){
                s[0]=s1;
                s[1]=s2;
                s[2]=args[1];
                Main.main(s);
            }
        }catch (IOException e){e.printStackTrace();}
    }
}
