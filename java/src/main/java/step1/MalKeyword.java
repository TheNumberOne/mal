package step1;

/**
 * Created by TheNumberOne on 9/1/15.
 */
public class MalKeyword extends MalObject {
    private final String name;

    public MalKeyword(String name) {
        this.name = name;
    }

    @Override
    public String repr() {
        return ":" + name;
    }
}
