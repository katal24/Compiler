package basic;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    ArrayList<String> tokens;
    Node root;

    public Parser(List<String> tokenList){
        tokens = new ArrayList<String>();
        for(String token : tokenList ){
            tokens.add(token);
        }
    }

   public Node parse(){
        root = new Node();
        buildTree(root, tokens, 0, tokens.size());
        display(root, 0);
        return root;
    }

    void buildTree(Node r, List<String> arr, int start, int end) {
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

    int findMultiplication(List<String> arr, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr.get(i).equals("[*]")) return i;
        }
        return -1;
    }

    int findAddition(List<String> arr, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr.get(i).equals("[+]")) return i;
        }
        return -1;
    }

    void display(Node n, int level) {
        if(n==null) return;
        for (int i = 0; i < level; i++) {
            System.out.print(" ");

        }
        System.out.println(n.getToken());
        display(n.getLeft(), level + 2);

        display(n.getRight(), level + 2);
    }



    public Node getRoot() {
        return root;
    }


}