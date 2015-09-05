package step3;

/**
 * Created by TheNumberOne on 9/1/15.
 */
public class MalBool extends MalObject {
    private final boolean val;

    public MalBool(boolean val) {
        this.val = val;
    }

    @Override
    public String repr() {
        return Boolean.toString(val);
    }
}
