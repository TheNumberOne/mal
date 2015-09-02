import java.io.PrintStream;
import java.util.Scanner;
import step2.*;

/**
 * Created by TheNumberOne on 8/31/15.
 */
public class step2_eval {

    public static MalObject READ(String input){
        return Reader.read_str(input);
    }

    public static MalObject EVAL(MalObject input){
        return input;
    }

    public static String PRINT(MalObject input){
        return Printer.pr_str(input);
    }

    public static String rep(String input){
        return PRINT(EVAL(READ(input)));
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
