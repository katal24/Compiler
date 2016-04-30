package advanced;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Skaner1 {


    static List<String> tokens = new LinkedList<>();
    static String temp = null;
    static boolean isSth = false;


    public Skaner1(String filename){
        read(filename);
    }

    public static List<String> getTokens(){
        return tokens;
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
                for(String s : line.split(" ")){
                    if(Grammar.terminalSymbols.contains(s)){
                        temp(s);
                    } else{
                        if(isSth){
                            saveTemp();
                        }

                        if(Grammar.nonTerminalSymbols.contains(s)){
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

    public static String generateResult(){
        StringBuilder result = new StringBuilder();
        for(String token : tokens){
            result.append(token + " ");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

}
