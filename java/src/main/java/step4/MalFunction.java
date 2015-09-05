package step4;

/**
 * Created by TheNumberOne on 9/2/15.
 */
public abstract class MalFunction extends step4.MalObject {

    public abstract step4.MalObject apply(step4.MalObject... args);

    @Override
    public String repr(){
        return "func";
    }

}
