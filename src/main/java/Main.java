
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        // 准备文件lol.txt其中的内容是AB
        File f = new File(args[0]);
        File f2=new File(args[1]);
        File f3=new File(args[2]);
        char[] charter1;
        char[] charter2;
        String Charter1 = null;
        String Charter2 = null;
        // 创建基于文件的Reader
        try (FileReader fr = new FileReader(f)) {
            // 创建字符数组，其长度就是文件的长度
            charter1 = new char[(int) f.length()];
            // 以字符流的形式读取文件所有内容
            fr.read(charter1);
            Charter1=String.valueOf(charter1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try (FileReader fr = new FileReader(f2)) {
            // 创建字符数组，其长度就是文件的长度
            charter2 = new char[(int) f.length()];
            // 以字符流的形式读取文件所有内容
            fr.read(charter2);
            Charter2=String.valueOf(charter2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        double dis = StringUtils.getJaroWinklerDistance(Charter1, Charter2);
        System.out.println(dis);
        try (FileWriter fr = new FileWriter(f3)) {
            // 以字符流的形式把数据写入到文件中
            BigDecimal disB=new BigDecimal(dis*100);
            String data= new StringBuilder().append(String.valueOf(disB.setScale(2,RoundingMode.HALF_UP))).append("%").toString();
            char[] cs = data.toCharArray();
            fr.write(cs);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
