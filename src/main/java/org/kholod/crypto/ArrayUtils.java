package org.kholod.crypto;

public class ArrayUtils {

    static public int[][] prepareArrays(int[] firstArray, int[] secondArray) {
        int firstLength = firstArray.length;
        int secondLength = secondArray.length;
        int length = Math.max(firstLength, secondLength);
        if (firstLength < length) {
            firstArray = supplementArray(firstArray, secondArray);
        }
        if (secondLength < length) {
            secondArray = supplementArray(secondArray, firstArray);
        }
        return new int[][]{firstArray, secondArray};
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
}
