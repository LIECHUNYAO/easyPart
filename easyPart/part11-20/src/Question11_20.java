import javax.rmi.CORBA.Util;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question11_20 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Question11_20 test = new Question11_20();
//        test.plusOne(new int[]{2,4,9,3,9});
//        System.out.println(test.addBinary("10","101101101"));
//        byte[] iso = "我试试".getBytes("ISO8859-1");
//        System.out.println(new String(iso,"ISO8859-1"));
        int[] m = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        test.merge(m,3,nums2,3);
        System.out.println(Arrays.toString(m));
    }

    /*
    Given a sorted array and a target value, return the index if the target is found.
    If not, return the index where it would be if it were inserted in order.
    Example 1:
    Input: [1,3,5,6], 5
    Output: 2
     */
    public int searchInsert(int[] nums, int target) {

        if (target <= nums[0] || nums.length == 0) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= target) return i;
            }
        }
        return -1;
    }


    /*
    The count-and-say sequence is the sequence of integers with the first five terms as following:
    1 is read off as "one 1" or 11.
    11 is read off as "two 1s" or 21.
    21 is read off as "one 2, then one 1" or 1211.
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            return utilCountSay2(countAndSay(n - 1));

        }
    }

    public String utilCountSay2(String n) {
        String result = "";
        for (int i = 0; i < n.length() ; i++) {
            String temStr = "";
            if(i == n.length()-1){
                temStr ="1"+n.charAt(i);
            }else{
                if(n.charAt(i) == n.charAt(i+1)){
                    int index = i;
                    int count = 1;
                    for (int j = i+1; j < n.length(); j++) {
                        if(n.charAt(index) == n.charAt(j)){
                            count++;
                        }else {
                            break;
                        }
                    }
                    temStr = Integer.toString(count)+n.charAt(i);
                    i = i + count-1;
                }else{
                    temStr = "1"+n.charAt(i);
                }
            }
            result = result + temStr;
        }
        return result;
    }

    /*
        Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest
        sum and return its sum.
        Example:
        Input: [-2,1,-3,4,-1,2,1,-5,4],
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.
     */

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if(sum > max) max=sum;
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if(sum > max) max = sum;
            }
        }
        return max;
    }

    /*
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
    return the length of last word (last word means the last appearing word if we loop from
    left to right) in the string.
    Input: "Hello World"
    Output: 5
     */
    public int lengthOfLastWord(String s) {
        if(s == null) return 0;
        String[] sArray = s.split(" ");
        if(sArray == null || sArray.length ==0) return 0;
        return sArray[sArray.length-1].length();

    }


    /*
    Given a non-empty array of digits representing a non-negative integer,
    plus one to the integer.

    The digits are stored such that the most significant digit is at the head
    of the list, and each element in the array contain a single digit.
    Input: [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.
     */

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(digits[len-1] < 9){
                digits[len-1] += 1;
                return digits;
        }else{
            int count = 1;
            for (int i = 1; i < len; i++) {
                if(digits[len-1-i] < 9){
                    digits[len-1-i] += 1;
                    break;
                }else {
                    count++;
                }
            }
            System.out.println(count);

            if(count > (len-1)){
                int[] newArr = new int[len+1];
                newArr[0] = 1;
                return  newArr;
            }else {
                for (int i = 1; i <= count; i++) {
                    digits[len-i] = 0;
                }
                return digits;
            }

        }

    }

//    Given two binary strings, return their sum (also a binary string).
//    The input strings are both non-empty and contains only characters 1 or 0.
    public String addBinary(String a, String b) {
        int shorter = a.length()<=b.length() ? a.length():b.length();
        if(a.length() != b.length()){
            if(a.length() > b.length()){
                int sub = a.length() -b.length();
                String sub0 = "";
                for (int i = 0; i < sub ; i++) {
                    sub0 += "0";
                }
                b = sub0 + b;
            }else{
                int sub = b.length() -a.length();
                String sub0 = "";
                for (int i = 0; i < sub ; i++) {
                    sub0 += "0";
                }

                a = sub0 + a;
            }
        }
        System.out.println(a+"\n"+ b);

        Map<String, String > cal = new HashMap<>();
        cal.put("00","0");
        cal.put("10","1");
        cal.put("01","1");
        cal.put("11","10");
        int index = 0;
        String result = "";
        for (int i = a.length()-1; i >= 0; i--) {
            String tem = ""+ a.charAt(i) + b.charAt(i);
            String tem_result = cal.get(tem);
            if(index == 0){
                if(tem_result.length() > 1){
                    tem_result = "0";
                    index = 1;
                }else{
                    index = 0;
                }
            }else {
                if(tem_result.length() > 1 ){
                    index = 1;
                    tem_result = "1";
                }else if(cal.get(tem).equals("0")){
                    index = 0;
                    tem_result = "1";
                }else{
                    index = 1;
                    tem_result = "0";
                }
            }
//            System.out.println("index : "+index+ " temresult: " + tem_result);
            result = tem_result + result;
//            System.out.println("result: "+result);
        }

        if(index == 1){
            return "1"+result;
        }else {
            return result;
        }
    }

    /*
    Implement int sqrt(int x).
    Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
    Since the return type is an integer, the decimal digits are truncated and only
    the integer part of the result is returned.
     */
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int head = 1;
        int tail = x;
        int result;
        while(true){
            int medium = (head+tail)/2;
            if(medium == head) return head;
            if(medium < x/medium){
                head = medium;
            }else if(medium > x/medium){
                tail = medium;
            }else {
                return medium;
            }
        }
    }

    public int climbStairs(int n) {
        //recursion
//        System.out.println(n);
//        if((n-2) == 0){
//            return 2;
//        }
//
//        if((n-1) == 0){
//            return 1;
//        }
//        return climbStairs(n-2)+climbStairs(n-1);

        //dynamic programing
        //define the initial state
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        //1st solution use n+1 length to save all the state
        //2ed solution use two extra parameter to save state to infer next state
        int oneStep_before = 1;
        int twoStep_before = 2;
        int now = 0;
        int tem;
        for (int i = 3; i <= n; i++) {
            now = oneStep_before + twoStep_before;
            tem = oneStep_before;
            oneStep_before = now;
            twoStep_before = tem;
        }
        return now;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     * public ListNode deleteDuplicates(ListNode head) {
     *         if(head == null || head.next == null)return head;
     *         head.next = deleteDuplicates(head.next);
     *         return head.val == head.next.val ? head.next : head;
     * }
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode now = head;
        ListNode next;
        while(now.next != null){
            if(now.val != now.next.val){
                now = now.next;
            }else {
                if (now.next.next != null){
                    next = now.next.next;
                    now.next = next;
                }else {
                    now.next = null;
                }
            }
        }
        return head;
    }

    /*
    Given two sorted integer arrays nums1 and nums2,
    merge nums2 into nums1 as one sorted array.
    Note:
    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is equal to m + n) to hold
    additional elements from nums2.
    Input:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3
    Output: [1,2,2,3,5,6]
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count=0;
        for (int i = 0; i < nums1.length; i++) {
            if (n==count) return;
            if(nums1[i] > nums2[count]){
                count++;
                backOne(nums1, i, n-count, nums2[count-1]);

            }else {
                m--;
                System.out.println(m);
            }
            if (m == -1){
                System.out.println("nums1[i]: "+nums1[i]);
                for (int j = 0; j < n-count; j++) {
                    nums1[i+j] = nums2[count+j];
                }
                return;
            }
        }
    }

    public void backOne(int[] m, int index, int n_left, int val){
        int bef = m[index];
        m[index] = val;
        for (int i = index+1; i < m.length - n_left; i++) {
            int tem = m[i];
            m[i] = bef;
            bef = tem;
        }
    }

}



