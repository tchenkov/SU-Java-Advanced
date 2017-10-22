import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Joto on 21.10.2017 г..
 */
public class P01_BitFlipper {
    private static final int BITS = 64;
    private static final int BIT_OFFSET = BITS - 1;
    private static final int BIT_SEQUENCE = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long inputNumber = Long.parseUnsignedLong(br.readLine());
        //System.out.println(String.format("%64s", Long.toUnsignedString(inputNumber, 2)).replace(' ', '0'));
        int lastBit = -1;
        int bitSequenceCounter = 0;
        long mask = 0L;
        for (int bitPosition = BIT_OFFSET; bitPosition >= 0; bitPosition--) {
            int currentBit = currentBit(inputNumber, bitPosition);
            if (lastBit == currentBit) {
                bitSequenceCounter++;
                mask <<= 1;
                if (bitSequenceCounter == BIT_SEQUENCE){
                    mask += bitSequence(BIT_SEQUENCE);
                    bitSequenceCounter = 0;
                }
            } else {
                bitSequenceCounter = 1;
                lastBit = currentBit;
                mask <<= 1;
            }
            //String maskStr = String.format("%64s", Long.toUnsignedString(mask, 2)).replace(' ', '0');
            //System.out.println(maskStr);
        }
        //System.out.println(String.format("%64s", Long.toUnsignedString(mask, 2)).replace(' ', '0'));
        //System.out.println(String.format("%64s", Long.toUnsignedString(inputNumber^mask, 2)).replace(' ', '0'));

        System.out.println(inputNumber^mask);
    }

    private static long bitSequence(int size) {
        long result = 1L;
        for (int i = 1; i < size; i++) {
            result <<= 1;
            result++;
        }

        return result;
    }

    private static int currentBit(long num, int bitPosition) {
        num = num >> bitPosition;
        return (int) (num & 1);
    }
}
