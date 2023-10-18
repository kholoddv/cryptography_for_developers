package org.kholod.crypto;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

import static org.kholod.crypto.ArrayUtils.prepareArrays;

public class MyBigInteger {

    private final static int HEX_SYMBOLS_PER_INT = 8;
    private final static int HEX_RADIX = 16;

    // Java doesn't provide unsigned int type, but we can use correspond methods from Integer class those allow us
    // to treat int as unsigned int - https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
    private int[] unsignedIntArray;

    public void setHex(String hex) {
        int hexLength = hex.length();
        int arrayLength = hexLength / HEX_SYMBOLS_PER_INT;
        if (hexLength % HEX_SYMBOLS_PER_INT > 0) {
            arrayLength++;
        }
        unsignedIntArray = new int[arrayLength];
        int cursor = hexLength;
        int index = arrayLength - 1;
        while (cursor > 0) {
            int start = cursor - HEX_SYMBOLS_PER_INT;
            start = start > 0 ? start : 0;
            String hexPart = hex.substring(start, cursor);
            unsignedIntArray[index] = Integer.parseUnsignedInt(hexPart, HEX_RADIX);
            cursor = cursor - HEX_SYMBOLS_PER_INT;
            index--;
        }
    }

    public String getHex() {
        StringBuilder hex = new StringBuilder();
        int index = 0;
        while (index < unsignedIntArray.length) {
            hex.append(Integer.toHexString(unsignedIntArray[index]));
            index++;
        }
        return hex.toString();
    }

    public static MyBigInteger XOR(MyBigInteger first, MyBigInteger second) {
        return binaryOperation(first, second, (n, m) -> n ^ m);
    }

    public static MyBigInteger OR(MyBigInteger first, MyBigInteger second) {
        return binaryOperation(first, second, (n, m) -> n | m);
    }

    private static MyBigInteger binaryOperation(MyBigInteger first, MyBigInteger second, IntBinaryOperator operator) {
        int[][] preparedArrays = prepareArrays(first.unsignedIntArray, second.unsignedIntArray);

        int[] firstArray = preparedArrays[0];
        int[] secondArray = preparedArrays[1];
        int length = firstArray.length;
        int[] resultArray = new int[length];
        for (int i = 0; i < length; i++) {
            resultArray[i] = operator.applyAsInt(firstArray[i], secondArray[i]);
        }

        MyBigInteger result = new MyBigInteger();
        result.unsignedIntArray = resultArray;
        return result;
    }

    @Override
    public String toString() {
        return "MyBigInteger{" +
                "unsignedIntArray=" + Arrays.toString(unsignedIntArray) +
                '}';
    }
}
