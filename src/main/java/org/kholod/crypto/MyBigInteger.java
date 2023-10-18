package org.kholod.crypto;

import java.util.Arrays;

public class MyBigInteger {

    private final static int HEX_SYMBOLS_PER_INT = 8;
    private final static int HEX_RADIX = 16;

    // Java doesn't provide unsigned int type, but we can use correspond methods from Integer class those allow us
    // to treat int as unsigned int - https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
    private int[] unsignedIntArray;

    static MyBigInteger XOR(MyBigInteger first, MyBigInteger second) {
        int[] firstArray = first.unsignedIntArray;
        int firstLength = firstArray.length;
        int[] secondArray = second.unsignedIntArray;
        int secondLength = secondArray.length;
        int length = Math.max(firstLength, secondLength);
        if (firstLength < length) {
            firstArray = supplementArray(firstArray, secondArray);
        }
        if (secondLength < length) {
            secondArray = supplementArray(secondArray, firstArray);
        }

        MyBigInteger result = new MyBigInteger();
        int[] resultArray = new int[length];
        for (int i = 0; i < length; i++) {
            resultArray[i] = firstArray[i] ^ secondArray[i];
        }
        result.unsignedIntArray = resultArray;
        return result;
    }

    static private int[] supplementArray(int[] little, int[] big) {
        int[] newArray = new int[big.length];
        int indexBig = big.length - 1;
        int indexLittle = little.length - 1;
        while(indexBig >= 0) {
            if (indexLittle >=0) {
                newArray[indexBig] = little[indexLittle];
            } else {
                newArray[indexBig] = 0;
            }
            indexBig--;
            indexLittle--;
        }
        return newArray;
    }

    void setHex(String hex) {
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

    String getHex() {
        StringBuilder hex = new StringBuilder();
        int index = 0;
        while (index < unsignedIntArray.length) {
            hex.append(Integer.toHexString(unsignedIntArray[index]));
            index++;
        }
        return hex.toString();
    }

    @Override
    public String toString() {
        return "MyBigInteger{" +
                "unsignedIntArray=" + Arrays.toString(unsignedIntArray) +
                '}';
    }
}
