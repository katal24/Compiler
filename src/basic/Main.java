package basic;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, InterruptedException {

        Skaner skaner;
        Parser parser;
        CodeGenerator codeGenerator;
        Run run;

        skaner = new Skaner("plikDoSkanera");
        // String skanerResult = skaner.generateResult();

        parser = new Parser(skaner.getTokens());
        Node root = parser.parse();

        codeGenerator = new CodeGenerator();
        codeGenerator.generate(root);

        run = new Run();
        run.runCode();
    }
}
