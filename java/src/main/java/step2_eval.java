import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import step2.*;

/**
 * Created by TheNumberOne on 8/31/15.
 */
public class step2_eval {

    public static MalObject READ(String input){
        return Reader.read_str(input);
    }

    public static MalObject EVAL(MalObject input, HashMap<MalSymbol, MalObject> env){
        if (!(input instanceof MalList)){
            return eval_ast(input, env);
        } else {
            MalList evaluated = (MalList) eval_ast(input, env);
            List<MalObject> list = evaluated.list;
            List<MalObject> args = list.subList(1, list.size());
            return ((MalFunction) list.get(0)).apply(args.toArray(new MalObject[args.size()]));
        }
    }

    private static MalObject eval_ast(MalObject input, HashMap<MalSymbol, MalObject> env){
        if (input instanceof MalSymbol){
            MalObject value = env.get(input);
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

    public static String rep(String input){
        return PRINT(EVAL(READ(input), DefaultEnvironments.getREPLEnv()));
    }

    public static void main(String[] args){
        PrintStream out = System.out;
        Scanner in = new Scanner(System.in);
        while (true){
            out.print("user> ");
            String input = in.nextLine();
            if (input == null){
                break;
            }
            try {
                out.println(rep(input));
            } catch (Exception e){
                out.println(e.getMessage());
            }
        }
    }
}
