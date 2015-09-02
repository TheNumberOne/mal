package step2;

/**
 * Created by TheNumberOne on 9/1/15.
 */
public class MalString extends MalObject {
    private final String content;

    public MalString(String content) {
        this.content = content;
    }

    @Override
    public String repr() {
        return '"' + content.replace("\"", "\\\"").replace("\n", "\\n") + '"';
    }
}
