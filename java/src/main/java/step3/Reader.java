package step3;

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

    public static MalObject read_str(String string){
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

    private MalObject read_form() {
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

    private MalObject read_map() {
        HashMap<MalObject, MalObject> map = new HashMap<>();
        while (!isNext("}")) {
            MalObject key = read_form();
            MalObject value = read_form();
            map.put(key, value);
        }
        next();
        return new MalMap(map);
    }

    private MalObject read_keyword() {
        String k = next();
        return new MalKeyword(k.substring(1));
    }

    private MalObject read_string() {
        String s = next();
        s = s.substring(1, s.length() - 1);
        return new MalString(s.replace("\\\"", "\"").replace("\\n", "\n"));
    }

    private MalObject read_vector() {
        List<MalObject> list = new ArrayList<>();
        while (!isNext("]")) {
            list.add(read_form());
        }
        next();
        return new MalVector(list);
    }

    private MalList read_list() {
        List<MalObject> list = new ArrayList<>();
        while (!isNext(")")) {
            list.add(read_form());
        }
        next();
        return new MalList(list);
    }

    private MalObject read_atom() {
        String code = next();
        if (intRE.matcher(code).matches()){
            return new MalInt(new BigInteger(code));
        } else if (boolRE.matcher(code).matches()){
            return new MalBool(Boolean.parseBoolean(code));
        } else if (nilRE.matcher(code).matches()){
            return MalNil.nil;
        }
        else {
            return new MalSymbol(code);
        }
    }
}
