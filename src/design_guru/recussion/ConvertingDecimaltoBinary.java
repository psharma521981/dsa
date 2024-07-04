package recussion;

public class ConvertingDecimaltoBinary {
    public static String decimalToBinary(int decimal) {
        if(decimal==0) {
            return "";
        }
        return decimalToBinary (decimal / 2) + (decimal % 2);

    }

    public static void main(String[] args) {
        // Example inputs
        int[] examples = {10, 27, 5};

        for (int example : examples) {
            String binary = decimalToBinary(example);
            System.out.println("Binary representation of " + example + " is: " + binary);
        }
    }
}
