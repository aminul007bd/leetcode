public class MajorityElement_169 {
    public static int majorityElement(int[] nums) {
        int m_element = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                m_element = num;
            }
            count += (num == m_element) ? 1 : -1;
        }
        return m_element;
    }
}
