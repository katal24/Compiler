package environment;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* Name of the class has to be "Main" only if the class is public. */
public class Main {
    static PrintWriter writer;
    public static void main(String[] args) throws java.lang.Exception {
        //String tokens = "[1] [+] [2] [*] [3]";

        writer = new PrintWriter("polecenia", "UTF-8");

        ArrayList<String> tokens = new ArrayList<String>();
        tokens.add("[1]");
        tokens.add("[+]");
        tokens.add("[2]");
        tokens.add("[*]");
        tokens.add("[3]");

        Node root = new Node();
        buildTree(root, tokens, 0, tokens.size());
        display(root, 0);
        searchTree(root);
        printToFile("end");
        writer.close();
    }

    static void buildTree(Node r, List<String> arr, int start, int end) {
        int ind = findMultiplication(arr, start, end);
        System.out.println("start" + start + "end" + end);
        if (ind == -1) {
            ind = findAddition(arr, start, end);
            if (ind == -1) {
                //nic nie znalazl start rowny end

                r.setToken(arr.get(start));
                r.setLeft(null);
                r.setRight(null);
                if (start == end) return;
            }
            else {
                //znalazl mnozenie

                r.setToken("[*]");
                r.setLeft(new Node());
                r.setRight(new Node());
                System.out.println("znalazl mnozenie");
                buildTree(r.getLeft(), arr, start, ind - 1);
                buildTree(r.getRight(), arr, ind + 1, end);

            }

        }
        else {
            //znalazl dodawanie

            r.setToken("[+]");
            r.setLeft(new Node());
            r.setRight(new Node());
            buildTree(r.getLeft(), arr, start, ind - 1);
            buildTree(r.getRight(), arr, ind + 1, end);

        }

    }

    static int findMultiplication(List<String> arr, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr.get(i).equals("[*]")) return i;
        }
        return -1;
    }

    static int findAddition(List<String> arr, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr.get(i).equals("[+]")) return i;
        }
        return -1;
    }

    static void display(Node n, int level) {
        if(n==null) return;
        for (int i = 0; i < level; i++) {
            System.out.print(" ");

        }
        System.out.println(n.getToken());
        display(n.getLeft(), level + 2);

        display(n.getRight(), level + 2);
    }


    public static void searchTree(Node tree){
//        if((tree.getLeft() == null) && (tree.getRight()==null))
//            System.out.print(tree.getToken() + " ");
//        else{
//            if(tree.getLeft()==null)
//            {
//                searchTree(tree.getRight());
//            }
//            else{
//                searchTree(tree.getLeft());
//            }
//
//        }



        if(tree!=null){


                searchTree(tree.getLeft());
                searchTree(tree.getRight());


            printToFile(tree.getToken());
           // writer.println();
        }

    }

    public static void printToFile(String token){
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
        else if(newToken.equals("end")){
            writer.println("end");
        }
    }

    public static String getChar(String token){
        return token.substring(1,token.length()-1);

    }


}