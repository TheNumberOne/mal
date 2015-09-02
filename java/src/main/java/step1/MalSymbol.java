package step1;

/**
 * Created by TheNumberOne on 9/1/15.
 */
public class MalSymbol extends MalObject {
    private final String name;

    public MalSymbol(String name) {
        this.name = name;
    }

    @Override
    public String repr() {
        return name;
    }
}
