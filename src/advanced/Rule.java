package advanced;

import java.util.LinkedList;

/**
 * Created by dawid on 27.04.16.
 */
public class Rule {
    String starter;
    LinkedList<LinkedList<String>> rules;

    public String getStarter() {
        return starter;
    }

    public void setStarter(String starter) {
        this.starter = starter;
    }

    public LinkedList<LinkedList<String>> getRules() {
        return rules;
    }

    public void setRules(LinkedList<LinkedList<String>> rules) {
        this.rules = rules;
    }
}