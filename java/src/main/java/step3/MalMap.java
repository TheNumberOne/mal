package step3;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Created by TheNumberOne on 9/1/15.
 */
public class MalMap extends MalObject {
    private final HashMap<MalObject, MalObject> map;

    public MalMap(HashMap<MalObject, MalObject> map) {
        this.map = map;
    }

    @Override
    public String repr() {
        return map.entrySet().stream()
                .map(entry -> entry.getKey().repr() + " " + entry.getValue().repr())
                .collect(Collectors.joining(" ", "{", "}"));
    }
}
