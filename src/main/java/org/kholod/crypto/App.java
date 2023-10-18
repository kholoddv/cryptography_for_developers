package org.kholod.crypto;

import static org.kholod.crypto.MyBigInteger.*;

public class App {
    public static void main(String[] args) {
        testXOR();
        testOR();
        testAND();
    }

    private static void testXOR() {
        System.out.println("----------------------------");
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
        System.out.println();
    }

    private static void testOR() {
        System.out.println("----------------------------");
        System.out.println("TEST OR");
        MyBigInteger number1 = new MyBigInteger();
        MyBigInteger number2 = new MyBigInteger();
        number1.setHex("51bf608414ad5726a3c1bec098f77b1b54ffb2787f8d528a74c1d7fde6470ea4");
        number2.setHex("403db8ad88a3932a0b7e8189aed9eeffb8121dfac05c3512fdb396dd73f6331c");
        MyBigInteger result = OR(number1, number2);
        System.out.println(number1.getHex());
        System.out.println("OR");
        System.out.println(number2.getHex());
        System.out.println("result");
        System.out.println(result.getHex());
        String expectedResult = "51bff8ad9cafd72eabffbfc9befffffffcffbffaffdd779afdf3d7fdf7f73fbc";
        System.out.println("Check result: " + expectedResult.equals(result.getHex()));
        System.out.println();
    }

    private static void testAND() {
        System.out.println("----------------------------");
        System.out.println("TEST AND");
        MyBigInteger number1 = new MyBigInteger();
        MyBigInteger number2 = new MyBigInteger();
        number1.setHex("51bf608414ad5726a3c1bec098f77b1b54ffb2787f8d528a74c1d7fde6470ea4");
        number2.setHex("403db8ad88a3932a0b7e8189aed9eeffb8121dfac05c3512fdb396dd73f6331c");
        MyBigInteger result = AND(number1, number2);
        System.out.println(number1.getHex());
        System.out.println("AND");
        System.out.println(number2.getHex());
        System.out.println("result");
        System.out.println(result.getHex());
        String expectedResult = "403d208400a113220340808088d16a1b10121078400c1002748196dd62460204";
        System.out.println("Check result: " + expectedResult.equals(result.getHex()));
        System.out.println();
    }
}
