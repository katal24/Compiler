package advanced;

/**
 * To jest nowy projekt
 */
public class Main1 {


    public static void main(String[] args){

        Grammar.terminalSymbols.add("Expr");
        Grammar.terminalSymbols.add("Term");

        Grammar.nonTerminalSymbols.add("num");
        Grammar.nonTerminalSymbols.add("add");
        Grammar.nonTerminalSymbols.add("mul");

        Skaner1 skaner = new Skaner1("advancedSkaner");
        System.out.println(skaner.generateResult());
    }
}
