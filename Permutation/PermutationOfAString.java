package Permutation;

public class PermutationOfAString {
    public static void main(String[] args) {
        System.out.printf("\nNumber of permutations are: %d\n", permutation("", "abc"));
    }

    static int permutation(String processed, String unprocessed) {
        int count = 0;
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return 1;

        }

        for (int i = 0; i < unprocessed.length(); i++) {
            int c = permutation(processed + unprocessed.charAt(i),
                    unprocessed.substring(0, i) + unprocessed.substring(i + 1));
            count += c;
        }
        return count;
    }
}
