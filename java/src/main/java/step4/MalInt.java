package step4;

import step3.MalObject;

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

    public step3.MalInt add(step3.MalInt other){
        return new step3.MalInt(this.val.add(other.val));
    }

    public step3.MalInt subtract(step3.MalInt other){
        return new step3.MalInt(this.val.subtract(other.val));
    }

    public step3.MalInt multiply(step3.MalInt other){
        return new step3.MalInt(this.val.multiply(other.val));
    }

    public step3.MalInt divide(step3.MalInt other){
        return new step3.MalInt(this.val.divide(other.val));
    }

    public step3.MalInt negate(){
        return new step3.MalInt(this.val.negate());
    }
}
