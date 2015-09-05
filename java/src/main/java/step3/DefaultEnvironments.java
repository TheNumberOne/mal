package step3;

import java.util.HashMap;

/**
 * Created by TheNumberOne on 9/1/15.
 */
public class DefaultEnvironments {

    private static final HashMap<MalSymbol, MalObject> repl_env;

    static {
        repl_env = new HashMap<>();
        repl_env.put(new MalSymbol("+"), MalFunctions.add);
        repl_env.put(new MalSymbol("-"), MalFunctions.subtract);
        repl_env.put(new MalSymbol("*"), MalFunctions.multiply);
        repl_env.put(new MalSymbol("/"), MalFunctions.divide);
    }

    public static HashMap<MalSymbol, MalObject> getREPLEnv(){
        return repl_env;
    }

}
