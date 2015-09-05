package step3;

import java.util.HashMap;

/**
 * Created by TheNumberOne on 9/4/15.
 */
public class Env {

    private HashMap<MalSymbol, MalObject> data = new HashMap<>();
    private Env outer;

    public Env(Env outer){
        this.outer = outer;
    }

    public void set(MalSymbol key, MalObject value){
        data.put(key, value);
    }

    public Env find(MalSymbol key){
        MalObject result = data.get(key);
        if (result == null && outer != null){
            return outer.find(key);
        } else {
            return result == null ? null : this;
        }
    }

    public MalObject get(MalSymbol key){
        MalObject result = data.get(key);
        if (result == null){
            if (outer == null){
                throw new IllegalArgumentException("Not found: " + key.name);
            } else {
                return outer.get(key);
            }
        } else {
            return result;
        }
    }

}
