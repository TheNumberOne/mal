package step2;

import java.math.BigInteger;

/**
 * Created by TheNumberOne on 9/2/15.
 */
public class MalFunctions {

    private static final MalInt ZERO = new MalInt(BigInteger.ZERO);
    private static final MalInt ONE = new MalInt(BigInteger.ONE);

    public static final MalFunction add = new MalFunction() {
        @Override
        public MalObject apply(MalObject... args) {
            MalInt sum = ZERO;
            for (int i = 0; i < args.length; i++){
                sum = sum.add((MalInt) args[i]);
            }
            return sum;
        }
    };

    public static final MalFunction subtract = new MalFunction() {
        @Override
        public MalObject apply(MalObject... args) {
            MalInt total = ZERO;
            if (args.length > 0){
                total = total.add((MalInt) args[0]);
            }
            if (args.length == 1){
                return total.negate();
            }
            for (int i = 1; i < args.length; i++){
                total = total.subtract((MalInt) args[i]);
            }
            return total;
        }
    };

    public static final MalFunction multiply = new MalFunction() {
        @Override
        public MalObject apply(MalObject... args) {
            MalInt total = ONE;
            for (int i = 0; i < args.length; i++){
                total = total.multiply((MalInt) args[i]);
            }
            return total;
        }
    };

    public static final MalFunction divide = new MalFunction() {
        @Override
        public MalObject apply(MalObject... args) {
            MalInt total = ONE;
            if (args.length == 1){
                return total.divide((MalInt) args[0]);
            }
            if (args.length > 0){
                total = total.multiply((MalInt) args[0]);
            }
            for (int i = 1; i < args.length; i++){
                total = total.divide((MalInt) args[i]);
            }
            return total;
        }
    };

}
