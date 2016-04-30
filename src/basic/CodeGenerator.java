package basic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by dawid on 30.04.16.
 */
public class CodeGenerator {

    PrintWriter writer;

    public CodeGenerator() throws FileNotFoundException, UnsupportedEncodingException {
        writer = new PrintWriter("polecenia", "UTF-8");

    }

    public void generate(Node root){
         searchTree(root);
         printToFile("end");
         writer.close();
    }

    public void searchTree(Node tree){

        if(tree!=null){
            searchTree(tree.getLeft());
            searchTree(tree.getRight());
            printToFile(tree.getToken());
        }
    }

    public void printToFile(String token){
        System.out.println(token);
        String newToken = getChar(token);
        if(newToken.matches("\\d")){
            writer.println("put " + newToken);
        }
        else if(newToken.equals("+")){
            writer.println("add");
        }
        else if(newToken.equals("*")){
            writer.println("mul");
        }
        else if(token.equals("end")){
            writer.println("end");
        }
    }

    public String getChar(String token){
        return token.substring(1,token.length()-1);
    }
}
