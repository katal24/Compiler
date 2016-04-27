package environment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dawid on 27.04.16.
 */
public class Skaner {


    private static List<String> tokens = new LinkedList<String>();
    static String temp = null;
    static boolean isSth = false;
    String result;

    public static void main(String[] args){
        read("plikDoSkanera");
        System.out.println(generateResult());
    }

    public static String generateResult(){
        StringBuilder result = new StringBuilder();
        for(String token : tokens){
            result.append(token + " ");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    public static void temp(String s){
        if(temp==null){
            temp = s;
        } else
        temp +=s;
        isSth = true;
    }

    public static void saveTemp(){
        pack(temp);
        temp = null;
        isSth = false;
    }

    public static void read(String filename){
        Path path = Paths.get(filename);
        String temp = "";
        try {
            Files.lines(path).forEach(line ->  {
                for(String s : line.split("")){
                    if(s.matches("\\d")){
                        temp(s);
                    } else{
                        if(isSth){
                            saveTemp();
                        }

                        if(s.equals("*") || s.equals("+")){
                            pack(s);
                        }
                    }

                }
                if(isSth) saveTemp();

            });
        } catch (IOException e) {
            System.out.println("Niewlasciwy plik!");
            e.printStackTrace();
        }
    }

    public static void pack(String s){
        tokens.add("[" + s + "]");
    }

}
