import java.util.Stack;

public class ReverseAStack {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);
        stk.push(6);

        int counter = 6;
        reverseStack(stk, counter);
        while (!stk.empty()) {
            System.out.println(stk.pop());
        }
    }

    static void reverseStack(Stack<Integer> stk, int counter) {
        if (counter == 0) {
            return;
        }
        int top = stk.pop();
        insertAtBottom(top, stk, counter);
        reverseStack(stk, --counter);
    }

    static void insertAtBottom(int num, Stack<Integer> stk, int counter) {
        if (counter == 1) {
            stk.push(num);
            return;
        }
        int top = stk.pop();
        insertAtBottom(num, stk, --counter);
        stk.push(top);
    }
}
