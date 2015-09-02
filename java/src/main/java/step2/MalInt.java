package step2;

import java.math.BigInteger;

/**
 * Created by TheNumberOne on 9/1/15.
 */
public class MalInt extends MalObject {
    private final BigInteger val;

    public MalInt(BigInteger val) {
        this.val = val;
    }

    @Override
    public String repr() {
        return val.toString();
    }
}
