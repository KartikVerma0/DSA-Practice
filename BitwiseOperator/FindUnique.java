package BitwiseOperator;

public class FindUnique {
    public static void main(String[] args) {
        System.out.println(findUnique(new int[] { 1, 3, 4, 7, 4, 1, 3, 7, 9 }));
    }

    static int findUnique(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            answer = answer ^ nums[i];
        }

        return answer;
    }
}
