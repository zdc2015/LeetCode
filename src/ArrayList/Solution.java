package ArrayList;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	/*two sum
	 * ����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ
	 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�

ʾ��:

���� nums = [2, 7, 11, 15], target = 9

��Ϊ nums[0] + nums[1] = 2 + 7 = 9
���Է��� [0, 1]
	 */
	
	static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] ans = new int[2];
		for(int i=0;i<nums.length;i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			}
			int t = target - nums[i];
			if(map.containsKey(t)) {
				ans[0] = map.get(t);
				ans[1] = i;
				return ans;
			}
		}
		return null;
	}
	
	static void testTwoSum() {
		int[] nums = new int[] {2,7,11,15};
		int[] ans = twoSum(nums,9);
		System.out.println(ans[0]+" "+ans[1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testTwoSum();
	}

}
