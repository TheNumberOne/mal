package step4;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Created by TheNumberOne on 9/1/15.
 */
public class MalMap extends step4.MalObject {
    private final HashMap<step4.MalObject, step4.MalObject> map;

    public MalMap(HashMap<step4.MalObject, step4.MalObject> map) {
        this.map = map;
    }

    @Override
    public String repr() {
        return map.entrySet().stream()
                .map(entry -> entry.getKey().repr() + " " + entry.getValue().repr())
                .collect(Collectors.joining(" ", "{", "}"));
    }
}
