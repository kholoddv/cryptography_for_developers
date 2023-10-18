package org.kholod.crypto;

import static org.kholod.crypto.MyBigInteger.XOR;

public class App {
    public static void main(String[] args) {
        testXOR();
    }

    private static void testXOR() {
        System.out.println("******************************");
        System.out.println("TEST XOR");
        MyBigInteger number1 = new MyBigInteger();
        MyBigInteger number2 = new MyBigInteger();
        number1.setHex("51bf608414ad5726a3c1bec098f77b1b54ffb2787f8d528a74c1d7fde6470ea4");
        number2.setHex("403db8ad88a3932a0b7e8189aed9eeffb8121dfac05c3512fdb396dd73f6331c");
        MyBigInteger result = XOR(number1, number2);
        System.out.println(number1.getHex());
        System.out.println("XOR");
        System.out.println(number2.getHex());
        System.out.println("result");
        System.out.println(result.getHex());
        String expectedResult = "1182d8299c0ec40ca8bf3f49362e95e4ecedaf82bfd167988972412095b13db8";
        System.out.println("Check result: " + expectedResult.equals(result.getHex()));
        System.out.println("******************************");
    }
}
