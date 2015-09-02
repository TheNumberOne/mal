package step2;

/**
 * Created by TheNumberOne on 9/1/15.
 */
public class MalFloat extends MalObject {
    private final double val;

    public MalFloat(double val) {
        this.val = val;
    }

    @Override
    public String repr() {
        return Double.toString(val);
    }
}
