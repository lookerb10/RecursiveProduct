import java.math.BigInteger;
import java.util.Scanner;

public class RecursiveProduct {

    // Plain recursive version: product of nums[idx..end]
    public static BigInteger product(BigInteger[] nums, int idx) {
        // Base case: past the last element → multiplicative identity
        if (idx == nums.length) return BigInteger.ONE;
        // Recursive step: current * product(rest)
        return nums[idx].multiply(product(nums, idx + 1));
    }

    // Tail-recursive version (optional, shows style; not required)
    public static BigInteger productTail(BigInteger[] nums, int idx, BigInteger acc) {
        if (idx == nums.length) return acc;               // base case
        return productTail(nums, idx + 1, acc.multiply(nums[idx])); // tail call
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger[] nums = new BigInteger[5];

        System.out.println("Enter 5 integers (press Enter after each):");
        for (int i = 0; i < 5; i++) {
            while (true) {
                try {
                    String token = sc.next().trim();
                    nums[i] = new BigInteger(token);
                    break;
                } catch (Exception e) {
                    System.out.print("Invalid input. Please enter an integer: ");
                    sc.nextLine(); // clear bad line if needed
                }
            }
        }

        // Either approach is fine; both are recursive:
        BigInteger result = product(nums, 0);
        // BigInteger result = productTail(nums, 0, BigInteger.ONE);

        System.out.println("Product of the five numbers: " + result);
    }
}
