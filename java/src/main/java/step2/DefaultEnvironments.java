package step2;

import java.util.HashMap;

/**
 * Created by TheNumberOne on 9/1/15.
 */
public class DefaultEnvironments {

    private static final HashMap<MalSymbol, MalObject> repl_env;

    static {
        repl_env = new HashMap<>();
    }

    public static HashMap<MalSymbol, MalObject> getREPLEnv(){
        return repl_env;
    }

}
