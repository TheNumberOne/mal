package step4;

import java.math.BigInteger;

/**
 * Created by TheNumberOne on 9/2/15.
 */
public class MalFunctions {

    private static final step4.MalInt ZERO = new step4.MalInt(BigInteger.ZERO);
    private static final step4.MalInt ONE = new step4.MalInt(BigInteger.ONE);

    public static final step4.MalFunction add = new step4.MalFunction() {
        @Override
        public step4.MalObject apply(step4.MalObject... args) {
            step4.MalInt sum = ZERO;
            for (int i = 0; i < args.length; i++){
                sum = sum.add((step4.MalInt) args[i]);
            }
            return sum;
        }
    };

    public static final step4.MalFunction subtract = new step4.MalFunction() {
        @Override
        public step4.MalObject apply(step4.MalObject... args) {
            step4.MalInt total = ZERO;
            if (args.length > 0){
                total = total.add((step4.MalInt) args[0]);
            }
            if (args.length == 1){
                return total.negate();
            }
            for (int i = 1; i < args.length; i++){
                total = total.subtract((step4.MalInt) args[i]);
            }
            return total;
        }
    };

    public static final step4.MalFunction multiply = new step4.MalFunction() {
        @Override
        public step4.MalObject apply(step4.MalObject... args) {
            step4.MalInt total = ONE;
            for (int i = 0; i < args.length; i++){
                total = total.multiply((step4.MalInt) args[i]);
            }
            return total;
        }
    };

    public static final step4.MalFunction divide = new step4.MalFunction() {
        @Override
        public step4.MalObject apply(step4.MalObject... args) {
            step4.MalInt total = ONE;
            if (args.length == 1){
                return total.divide((step4.MalInt) args[0]);
            }
            if (args.length > 0){
                total = total.multiply((step4.MalInt) args[0]);
            }
            for (int i = 1; i < args.length; i++){
                total = total.divide((step4.MalInt) args[i]);
            }
            return total;
        }
    };

}
