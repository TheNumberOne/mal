package step4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by TheNumberOne on 9/1/15.
 */
public class Reader {
    private static final Pattern tokenRE =
            Pattern.compile("[\\s,]*(~@|[\\[\\]{}()'`~^@]|\"(?:\\\\.|[^\\\\\"])*\"|;.*|[^\\s\\[\\]{}('\"`,;)]*)");

    private static final Pattern intRE =
            Pattern.compile("[+-]?\\d+");

    private static final Pattern nilRE =
            Pattern.compile("nil");

    private static final Pattern boolRE =
            Pattern.compile("true|false");

    private List<String> tokens;
    private int position;

    private Reader(List<String> tokens) {
        this.tokens = tokens;
    }

    private String next() {
        return tokens.get(position++);
    }

    private String peek(){
        return tokens.get(position);
    }

    private boolean hit_end(){
        return position >= tokens.size();
    }

    private boolean isNext(String token){
        if (hit_end()){
            throw new IllegalArgumentException("expected '"+token+"', got EOF");
        }
        return peek().equals(token);
    }

    public static step4.MalObject read_str(String string){
        List<String> tokens = tokenizer(string);
        return new Reader(tokens).read_form();
    }

    private static List<String> tokenizer(String string) {
        Matcher m = tokenRE.matcher(string);
        List<String> tokens = new ArrayList<>();

        while (m.find()){
            tokens.add(m.group(1));
        }

        return tokens;
    }

    private step4.MalObject read_form() {
        char c = peek().charAt(0);
        if (hit_end()){
            throw new IllegalArgumentException("");
        }
        switch (c){
            case '(':
                next();
                return read_list();
            case '"':
                return read_string();
            case ':':
                return read_keyword();
            case '[':
                next();
                return read_vector();
            case '{':
                next();
                return read_map();
            case ';':
                next();
                return read_form();
            default:
                return read_atom();
        }
    }

    private step4.MalObject read_map() {
        HashMap<step4.MalObject, step4.MalObject> map = new HashMap<>();
        while (!isNext("}")) {
            step4.MalObject key = read_form();
            step4.MalObject value = read_form();
            map.put(key, value);
        }
        next();
        return new step4.MalMap(map);
    }

    private step4.MalObject read_keyword() {
        String k = next();
        return new MalKeyword(k.substring(1));
    }

    private step4.MalObject read_string() {
        String s = next();
        s = s.substring(1, s.length() - 1);
        return new step4.MalString(s.replace("\\\"", "\"").replace("\\n", "\n"));
    }

    private step4.MalObject read_vector() {
        List<step4.MalObject> list = new ArrayList<>();
        while (!isNext("]")) {
            list.add(read_form());
        }
        next();
        return new step4.MalVector(list);
    }

    private step4.MalList read_list() {
        List<step4.MalObject> list = new ArrayList<>();
        while (!isNext(")")) {
            list.add(read_form());
        }
        next();
        return new step4.MalList(list);
    }

    private step4.MalObject read_atom() {
        String code = next();
        if (intRE.matcher(code).matches()){
            return new step4.MalInt(new BigInteger(code));
        } else if (boolRE.matcher(code).matches()){
            return new step4.MalBool(Boolean.parseBoolean(code));
        } else if (nilRE.matcher(code).matches()){
            return step4.MalNil.nil;
        }
        else {
            return new step4.MalSymbol(code);
        }
    }
}
