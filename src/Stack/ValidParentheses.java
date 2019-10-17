package Stack;

import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		stack.push('#');
		for(int i=0;i<s.length();i++) {
			switch (s.charAt(i)) {
			case ')':
				if(stack.peek()=='(') stack.pop();
				else stack.push(s.charAt(i));
				break;
			case '}':
				if(stack.peek()=='{') stack.pop();
				else stack.push(s.charAt(i));
				break;
			case ']':
				if(stack.peek()=='[') stack.pop();
				else stack.push(s.charAt(i));
				break;
			default:
				stack.push(s.charAt(i));
				break;
			}
		}
		return stack.peek()=='#';
    }
	 
	public static void main(String[] args) {
		String s = "()[]{}";
		System.out.println(new ValidParentheses().isValid(s));

	}

}
