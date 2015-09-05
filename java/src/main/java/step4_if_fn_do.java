import step4.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by TheNumberOne on 8/31/15.
 */
public class step4_if_fn_do {

    public static MalObject READ(String input){
        return Reader.read_str(input);
    }

    public static MalObject EVAL(MalObject input, Env env){
        if (!(input instanceof MalList)){
            return eval_ast(input, env);
        } else {
            List<MalObject> list = ((MalList) input).list;
            MalObject first = list.get(0);
            if (first.equals(new MalSymbol("def!"))){
                MalObject value = EVAL(list.get(2), env);
                env.set((MalSymbol) list.get(1), value);
                return value;
            } else if (first.equals(new MalSymbol("let*"))){
                env = new Env(env);
                List<MalObject> bindings = ((MalList) list.get(1)).list;
                for (int i = 0; i < bindings.size(); i += 2){
                    env.set((MalSymbol) bindings.get(i), EVAL(bindings.get(i + 1), env));
                }
                return EVAL(list.get(2), env);
            } else {
                list = ((MalList) eval_ast(input, env)).list;
                first = list.get(0);
                List<MalObject> args = list.subList(1, list.size());
                return ((MalFunction) first).apply(args.toArray(new MalObject[args.size()]));
            }
        }
    }

    private static MalObject eval_ast(MalObject input, Env env){
        if (input instanceof MalSymbol){
            MalObject value = env.get((MalSymbol) input);
            if (value == null){
                throw new NullPointerException("No symbol named " + input.repr());
            }
            return value;
        } else if (input instanceof MalList){
            List<MalObject> evaluated = new ArrayList<>();
            MalList list = (MalList) input;
            for (MalObject o : list.list){
                evaluated.add(EVAL(o, env));
            }
            return new MalList(evaluated);
        } else {
            return input;
        }
    }

    public static String PRINT(MalObject input){
        return Printer.pr_str(input);
    }

    public static String rep(String input, Env env){
        return PRINT(EVAL(READ(input), env));
    }

    public static void main(String[] args){
        PrintStream out = System.out;
        Scanner in = new Scanner(System.in);
        Env env = createDefaultEnvironment();
        while (true){
            out.print("user> ");
            String input = in.nextLine();
            if (input == null){
                break;
            }
            try {
                out.println(rep(input, env));
            } catch (Exception e){
                out.println(e.getMessage());
            }
        }
    }

    private static Env createDefaultEnvironment() {
        Env environment = new Env(null);
        environment.set(new MalSymbol("+"), MalFunctions.add);
        environment.set(new MalSymbol("-"), MalFunctions.subtract);
        environment.set(new MalSymbol("*"), MalFunctions.multiply);
        environment.set(new MalSymbol("/"), MalFunctions.divide);
        return environment;
    }
}
