package environment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;

public class Run {

    private static Stack<Integer> stack;

    public Run(){
        stack = new Stack<Integer>();
    }

    public static void runCode(){
        String filename = "polecenia";
        Path path = Paths.get(filename);
        try {
            Files.lines(path).forEach(s ->  {

                String[] line = s.split(" ");
                if(line[0].equals("put")){
                    stack.push(Integer.parseInt(line[1]));
                }
                else if(s.equals("add") || s.equals("mul")){
                    calculate(s);
                } else if(s.equals("end")){
                    System.out.println("Result: " + stack.pop());
                    System.exit(0);
                } else{
                    try {
                        throw new ErrorInFileException();
                    } catch (ErrorInFileException e) {
                        System.out.println("Blad w pliku, niewlasciwa skladnia!");
                        e.printStackTrace();
                    }
                }

            });
        } catch (IOException e) {
            System.out.println("Niewlasciwy plik!");
            e.printStackTrace();
        }
    }

    public static void calculate(String s){
        int x = stack.pop();
        int y = stack.pop();
        int result = 0;
        if(s.equals("add")) {
            result = x + y;
        } else if(s.equals("mul")){
            result = x * y;
        }
        stack.push(result);
    }

}
