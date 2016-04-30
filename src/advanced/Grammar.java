package advanced;
import java.util.ArrayList;

public class Grammar {


    static ArrayList<String> terminalSymbols = new ArrayList<>(); //symboole terminalne
    static ArrayList<String> nonTerminalSymbols = new ArrayList<>();  //nieterminalne duze litery zmiennne
    static ArrayList<Rule> rules;
    static String starter = "Expr";



    public ArrayList<String> getNonTerminalSymbols() {
        return nonTerminalSymbols;
    }

    public void setNonTerminalSymbols(ArrayList<String> nonTerminalSymbols) {
        this.nonTerminalSymbols = nonTerminalSymbols;
    }

    public ArrayList<String> getTerminalSymbols() {
        return terminalSymbols;
    }

    public void setTerminalSymbols(ArrayList<String> terminalSymbols) {
        this.terminalSymbols = terminalSymbols;
    }

    public ArrayList<Rule> getRules() {
        return rules;
    }

    public void setRules(ArrayList<Rule> rules) {
        this.rules = rules;
    }

    public String getStarter() {
        return starter;
    }

    public void setStarter(String starter) {
        this.starter = starter;
    }
}