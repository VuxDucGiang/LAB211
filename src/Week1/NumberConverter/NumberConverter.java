package Week1.NumberConverter;

public class NumberConverter {
    private int baseType;
     String fromBase;

    public NumberConverter(int baseType, String fromBase) {
        this.baseType = baseType;
        this.fromBase = fromBase;
    }
    
    public int binaryToDecimal() {
        int decimal = 0;
        int power = 1;

        for (int i = fromBase.length() - 1; i >= 0; i--) {
            decimal += (fromBase.charAt(i) - '0') * power;
            power *= 2;
        }

        return decimal;
    }

    public String decimalToBinary(int decimal) {
        StringBuilder binary = new StringBuilder();

        while (decimal > 0) {
            binary.insert(0, decimal % 2);
            decimal /= 2;
        }

        return binary.length() > 0 ? binary.toString() : "0";
    }

    public String decimalToHexadecimal(int decimal) {
        StringBuilder hex = new StringBuilder();
        char[] hexDigits = "0123456789ABCDEF".toCharArray();

        while (decimal > 0) {
            hex.insert(0, hexDigits[decimal % 16]);
            decimal /= 16;
        }

        return hex.length() > 0 ? hex.toString() : "0";
    }
}
