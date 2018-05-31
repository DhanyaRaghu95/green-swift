package org.greenswiftTry3;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by aarti on 11/12/2015.
 */
public class try_file {


    private static List<String> fileList = new ArrayList<String>();
    public static PrintWriter out;


    public static void main(String[] args) throws IOException, ParameterException {

        try {
            out = new PrintWriter("C:\\Users\\aarti\\Desktop\\CCBDwithTimestamp\\LogGreenSwift.txt", "UTF-8");
        } catch (java.io.FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        Files.walk(Paths.get("C:\\MINE\\PESIT\\SEM V\\CCBD\\planetlab")).forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                //System.out.println(filePath+" "+(filePath.toFile()).length()/50);
                fileList.add(filePath+"");
            }
        });
        Random rn = new Random();
        int rNo=1;
        Account acc=new Account();
        try_file.out.println("Green Swift Simulation");

        for(int i=0 ; i<fileList.size() ; i++)
        {
            rNo = rn.nextInt(3 - 1 + 1) + 1 ;

            SwiftMain.operations(acc, rNo, fileList.get(i));
        }
        for(int i=0 ; i<fileList.size() ; i++)
        {
            rNo = rn.nextInt(3 - 1 + 1) + 1 ;

            SwiftMain.operations(acc, rNo, fileList.get(i));
        }

        out.println(" Power Consumed by SSDs : "+SwiftMain.SSDPowerConsumption());
        out.println(" Power Consumed by Disks(Nodes) :: "+SwiftMain.nodePowerConsumption());

        out.close();
    }
}
