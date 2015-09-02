package step1;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by TheNumberOne on 9/1/15.
 */
public class MalVector extends MalObject {
    private final List<MalObject> list;

    public MalVector(List<MalObject> list) {
        this.list = list;
    }

    @Override
    public String repr() {
        return list.stream().map(MalObject::repr).collect(Collectors.joining(" ", "[", "]"));
    }
}
