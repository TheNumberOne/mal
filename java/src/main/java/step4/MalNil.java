package step4;

/**
 * Created by TheNumberOne on 9/1/15.
 */
public class MalNil extends step4.MalObject {

    public final static MalNil nil = new MalNil();

    private MalNil(){}

    @Override
    public String repr() {
        return "nil";
    }
}
