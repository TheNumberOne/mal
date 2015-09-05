package step3;

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

    public MalInt add(MalInt other){
        return new MalInt(this.val.add(other.val));
    }

    public MalInt subtract(MalInt other){
        return new MalInt(this.val.subtract(other.val));
    }

    public MalInt multiply(MalInt other){
        return new MalInt(this.val.multiply(other.val));
    }

    public MalInt divide(MalInt other){
        return new MalInt(this.val.divide(other.val));
    }

    public MalInt negate(){
        return new MalInt(this.val.negate());
    }
}
