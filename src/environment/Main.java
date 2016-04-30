package environment;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by dawid on 30.04.16.
 */
public class Main {

    static Skaner skaner;
    static Parser parser;
    static CodeGenerator codeGenerator;
    static Run run;
    static String skanerResult;
    static Node root;

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, InterruptedException {

        skaner = new Skaner();

        skaner.read("plikDoSkanera");
        skanerResult = skaner.generateResult();

        parser = new Parser(skaner.getTokens());
        parser.parse();
        root = parser.getRoot();

        codeGenerator = new CodeGenerator();
        codeGenerator.generate(root);

        run = new Run();
        run.runCode();
    }
}
