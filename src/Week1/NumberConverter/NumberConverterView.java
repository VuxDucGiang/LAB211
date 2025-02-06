package Week1.NumberConverter;

public class NumberConverterView {

    public void converteFromBin(NumberConverter converter) {
        int decimal = converter.binaryToDecimal();
        System.out.println("Binary to Decimal: " + decimal);  // 2 -> 10
        System.out.println("Binary to Hexadecimal: " + converter.decimalToHexadecimal(decimal)); // 2 -> 16 = 2 ->10 + 10 -> 16
    }

    public void converteFromDec(NumberConverter converter) {
        int decimal = Integer.parseInt(converter.fromBase);
        System.out.println("Decimal to Binary: " + converter.decimalToBinary(decimal)); // 10 -> 2
        System.out.println("Decimal to Hexadecimal: " + converter.decimalToHexadecimal(decimal)); 
    }

    public void converteFromHex(NumberConverter converter) {
        int decimal = Integer.parseInt(converter.fromBase, 16);
        System.out.println("Hexadecimal to Decimal: " + decimal);
        System.out.println("Hexadecimal to Binary: " + converter.decimalToBinary(decimal));
    }
}
