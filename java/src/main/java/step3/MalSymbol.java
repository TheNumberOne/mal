package step3;

/**
 * Created by TheNumberOne on 9/1/15.
 */
public class MalSymbol extends MalObject {
    public final String name;

    public MalSymbol(String name) {
        this.name = name;
    }

    @Override
    public String repr() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MalSymbol malSymbol = (MalSymbol) o;

        return name.equals(malSymbol.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
