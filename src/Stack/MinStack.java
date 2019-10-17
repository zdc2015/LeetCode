package Stack;

import java.util.Stack;

/*设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。

思路：想不出来。。。多设置一个辅助栈，辅助栈储存当前最小的元素，最小的元素在栈顶
*/

public class MinStack {
	
	Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<>();
	
	 /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(minStack.isEmpty() || x<=minStack.peek()) {
        	minStack.push(x);
        }else {
        	minStack.push(minStack.peek());//当出现元素比最小元素大时，这样子方便“记住”最小元素在s中的位置，minStack中最小元素靠近栈底的位置就是最小元素在s中的位置，该位置以下就是第二小元素（如果有的话）
        }
        s.push(x);
    }
    
    public void pop() {
    	s.pop();
    	minStack.pop();//s与minStack相对应，s中最小元素的位置以上minStack都是最小值，确保minStack直到弹出所有最小值之前，也就是s弹出最小值之前，最小值不变。
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
