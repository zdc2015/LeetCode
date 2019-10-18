package String;

/*
 * ����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��

˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���

ʾ�� 1:

����: "A man, a plan, a canal: Panama"
���: true
ʾ�� 2:

����: "race a car"
���: false

 * ֱ��ģ��Ϳ�����
 * */

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		if(s==null) return true;
		int left = 0;
		int right = s.length()-1;
		s = s.toLowerCase();
		
		while(left<=right) {
			while(!isDigitalOrAlpha(s.charAt(left))&&left<right) left++;
			while(!isDigitalOrAlpha(s.charAt(right))&&right>left) right--;
			if(s.charAt(left)!=s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
    }
	
	public boolean isDigitalOrAlpha(char t) {
		if((t<='9' && t>='0') || (t<='z'&&t>='a')) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		ValidPalindrome v = new ValidPalindrome();
		System.out.println(v.isPalindrome("race a car"));
	}

}
