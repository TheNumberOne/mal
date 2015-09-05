package step4;

import step3.MalFunctions;
import step3.MalObject;

import java.util.HashMap;

/**
 * Created by TheNumberOne on 9/1/15.
 */
public class DefaultEnvironments {

    private static final HashMap<MalSymbol, step4.MalObject> repl_env;

    static {
        repl_env = new HashMap<>();
        repl_env.put(new MalSymbol("+"), step4.MalFunctions.add);
        repl_env.put(new MalSymbol("-"), step3.MalFunctions.subtract);
        repl_env.put(new MalSymbol("*"), step3.MalFunctions.multiply);
        repl_env.put(new MalSymbol("/"), MalFunctions.divide);
    }

    public static HashMap<MalSymbol, MalObject> getREPLEnv(){
        return repl_env;
    }

}
