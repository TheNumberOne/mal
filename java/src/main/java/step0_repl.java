import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by TheNumberOne on 8/31/15.
 */
public class step0_repl {

    public static String READ(String input){
        return input;
    }

    public static String EVAL(String input){
        return input;
    }

    public static String PRINT(String input){
        return input;
    }

    public static String rep(String input){
        input = READ(input);
        input = EVAL(input);
        return PRINT(input);
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
            out.println(rep(input));
        }
    }

}
