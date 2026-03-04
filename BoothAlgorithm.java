import java.util.Scanner;

public class BoothAlgorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter multiplicand: ");
        String multiplicandBin = scanner.nextLine().trim();

        System.out.print("Enter multiplier: ");
        String multiplierBin = scanner.nextLine().trim();

        // Convert binary strings to signed integers
        int M = toSigned(multiplicandBin);
        int Q = toSigned(multiplierBin);

        int A = 0;
        int Q_1 = 0;
        int count = 4;

        System.out.println();
        printIteration(0, M, Q, A, Q_1);

        for (int i = 1; i <= count; i++) {


            int Q0 = Q & 1;

            // Booth's logic
            if (Q0 == 1 && Q_1 == 0) {
                A = add4Bit(A, -M); // A = A - M
            } else if (Q0 == 0 && Q_1 == 1) {
                A = add4Bit(A, M); // A = A + M
            }

            // Arithmetic right shift [A, Q, Q-1]
            int combined = ((A & 0xF) << 5) | ((Q & 0xF) << 1) | Q_1;

            int sign = (A & 0x8) != 0 ? 1 : 0;
            combined = combined >> 1;
            if (sign == 1) {
                combined |= 0x100; // preserve sign
            }

            A = (combined >> 5) & 0xF;
            if ((A & 0x8) != 0) A |= ~0xF;

            Q = (combined >> 1) & 0xF;
            if ((Q & 0x8) != 0) Q |= ~0xF;

            Q_1 = combined & 1;
            printIteration(i, M, Q, A, Q_1);
        }

    }

    // Add two signed 4-bit integers and return signed 4-bit result
    static int add4Bit(int a, int b) {
        int result = a + b;
        result &= 0xF; // keep only 4 bits
        if ((result & 0x8) != 0) result |= ~0xF; // sign extend if needed
        return result;
    }

    // Convert 4-bit binary string to signed int
    static int toSigned(String bin) {
        if (bin.length() != 4) throw new IllegalArgumentException("Must be 4 bits.");
        int val = Integer.parseInt(bin, 2);
        if (bin.charAt(0) == '1') val -= 16;
        return val;
    }

    // Convert signed 4-bit number to 4-bit binary string
    static String binary4(int num) {
        String binary = Integer.toBinaryString(num & 0xF);
        while (binary.length() < 4) {
            binary = "0" + binary;
        }
        return binary;
    }


    // Print current iteration state
    static void printIteration(int step, int M, int Q, int A, int Q_1) {
        int productDecimal = (A << 4) | (Q & 0xF);
        System.out.println("Iteration " + step + ": multiplicand " + binary4(M) + " (" + M + "); multiplier " + binary4(Q) + " (" + Q + ");");
        System.out.println("product " + binary4(A) + " " + binary4(Q) + " (" + productDecimal + ")");
    }

}
