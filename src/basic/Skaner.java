package basic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Skaner {


    List<String> tokens = new LinkedList<>();
    String temp = null;
    boolean isSth = false;


    public Skaner(String filename){
        read(filename);
    }

    public String generateResult(){
        StringBuilder result = new StringBuilder();
        for(String token : tokens){
            result.append(token + " ");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    public List<String> getTokens(){
        return tokens;
    }

    public void temp(String s){
        if(temp==null){
            temp = s;
        } else
        temp +=s;
        isSth = true;
    }

    public void saveTemp(){
        pack(temp);
        temp = null;
        isSth = false;
    }

    public void read(String filename){
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

    public void pack(String s){
        tokens.add("[" + s + "]");
    }

}
