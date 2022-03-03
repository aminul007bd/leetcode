public class MajorityElement_169 {
    public static int majorityElement(int[] nums) {
        int m_element = 0, count = 0;
        for(int num: nums) {
            if(count == 0) {
                m_element = num;
            }
            count += (num == m_element) ? 1: -1;
        }
        return m_element;
    }

    public static void main(String[] args) {
        int[]  nums = {2,2,1,1,1,2,2};
        var result = majorityElement(nums);
        System.out.println(result);
    }
}
