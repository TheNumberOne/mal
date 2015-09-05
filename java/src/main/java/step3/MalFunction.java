package step3;

/**
 * Created by TheNumberOne on 9/2/15.
 */
public abstract class MalFunction extends MalObject {

    public abstract MalObject apply(MalObject... args);

    @Override
    public String repr(){
        return "func";
    }

}
