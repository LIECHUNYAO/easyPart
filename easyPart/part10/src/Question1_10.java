import java.util.*;

public class Question1_10 {
    public static void main(String[] args) {
        Question1_10 d1 = new Question1_10();
//        System.out.println(d1.romanToInt("LVIII"));
//        System.out.println(d1.longestCommonPrefix(new String[]{}));
//        System.out.println(d1.isValid("(){}"));
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
//        ListNode node7 = new ListNode(7);
//        node1.next = node2;
//        node2.next = node6;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node7;
//        ListNode newList = d1.mergeTwoLists(node1, node3);
//        while (newList != null){
//            System.out.println(newList.val);
//            newList = newList.next;
//        }

        d1.removeElement(new int[]{0,1,2,2,3,0,4,2},2);

        System.out.println(d1.strStr("aaa", "a"));


    }


//


    public int reverse(int x) {

        int out = 0;

        while(true){
            System.out.println(out);
            if(x != 0){
                if(out > Integer.MAX_VALUE/10 || (out == Integer.MAX_VALUE/10 && ((x%10) >7))){
                    return 0;
                }

                if(out < Integer.MIN_VALUE/10 || (out == Integer.MIN_VALUE/10 && ((x%10) <-8))){
                    return 0;
                }
                int tem = x%10;
                x = x/10;
                out = out*10 + tem;
            }else{
                return out;
            }
        }
    }
    public boolean isPalindrome(int x) {

        if(x < 0){
            return false;
        }else if(x == 0){
            return true;
        }else{
            int copy = x;
            int rev = 0;
            while(true){
                if(x != 0){
                    rev = rev*10 + x%10;
                    x /= 10;
                }else{
                    break;
                }
            }
            if(rev == copy){
                return true;
            }else{
                return false;
            }
        }

    }
    /**
     * public int romanToInt(String s) {
     *I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     *     }
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map map = new HashMap();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int sum = 0;

        for (int i = 0; i < s.length(); ) {
            String two="", one="";
            if (i < s.length() - 1) {
                two = Character.toString(s.charAt(i)) + Character.toString(s.charAt(i + 1));
            }
            one = Character.toString(s.charAt(i));
            if (map.keySet().contains(two)) {
                sum += (int) map.get(two);
                i += 2;

            }else{
                sum += (int) map.get(one);
                i++;
            }
        }

        return sum;
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }


        //get minimum length of str
        int min = Integer.MAX_VALUE;
        for ( String entry: strs ) {
            if(min > entry.length()) min = entry.length();
        }

        String prefix = "";
        for (int i = 0; i < min; i++) {
            boolean flag = true;

            for (int j = 0; j < strs.length-1 ; j++) {
                if(strs[j].charAt(i) == strs[j+1].charAt(i)){
                    continue;
                }else{
                    flag =false;
                    break;
                }
            }
            if(flag == false){
                return prefix = strs[0].substring(0,i);
            }
        }
        prefix =strs[0].substring(0,min);
        return prefix;

    }
    /*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.
     */
    public boolean isValid(String s) {

        if(s.length()%2 != 0){
            return  false;
        }
        if(s.length() == 0){
            return true;
        }
        String left = "";
        String right = "";
        Map map = new HashMap();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        Set leftSet = new HashSet();
        leftSet.add('(');
        leftSet.add('[');
        leftSet.add('{');
        if(!leftSet.contains(s.charAt(0))){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if(leftSet.contains(s.charAt(i))) {
                left = left+Character.toString(s.charAt(i));
            }else {
                if(left.charAt(left.length()-1) == (char) map.get(s.charAt(i))){
                    left = left.substring(0,left.length()-1);
                }else{
                    return false;
                }
            }
        }
        if(left.length() == 0){
            return true;
        }else {
            return false;
        }
    }
    /*
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode smaller, bigger, current;
        //if one of them is null, return another ListNode
        if(l1 == null || l2 == null){
            if(l1 == null) return l2;
            if(l2 == null) return l1;
        }
        //choose the ListNode with smaller first value
        if(l1.val <= l2.val){
            smaller = l1;
            bigger = l2;
        }else {
            smaller = l2;
            bigger = l1;
        }
        current = smaller;
        while(current.next != null && bigger != null){
            int tem = bigger.val;
            int nextVar = current.next.val;
            if(nextVar <= tem){
                current = current.next;
            }else {
                ListNode newNode = new ListNode(tem);
                bigger = bigger.next;
                newNode.next = current.next;
                current.next = newNode;
            }
        }

        if(current.next == null){
            current.next = bigger;
            return smaller;
        }else {
            return smaller;
        }


    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(nums == null){
            return 0;
        }
        int count = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] != nums[i+1]){
                nums[count] = nums[i+1];
                count += 1;
            }else continue;
        }

        return count;
    }

    /*
    27. Remove Element
    Given an array nums and a value val, remove all instances of that value in-place and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     */
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i = 0; i < nums.length; i++ ){
            if(nums[i] == val){
                for (int j = i+1; j < nums.length; j++) {
                    if(nums[j] != val){
                        count ++;
                        nums[i] = nums[j];
                        nums[j] = val;
                        System.out.println(Arrays.toString(nums));
                        break;
                    }
                }
            }else continue;
        }
        return count;
        /*
        int length = nums.length;
        if(length == 0)
            return 0;

        int count = 0;
        int index = 0;
        for(int i = 0;i<length;i++){
            if(nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }else
                count++;
        }

        return length - count;
         */

    }
/*
Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
//null 和 "" 是不一样的
    public int strStr(String haystack, String needle) {
        if((haystack.length() == 0 && needle.length() == 0) || needle.length() == 0){
            return 0;
        }
        if(haystack.length() < needle.length()){
            return -1;
        }
        char[] haystackChar = haystack.toCharArray();
        char[] needleCahr = needle.toCharArray();
        for (int i = 0; i < haystackChar.length; i++) {
            if(haystackChar[i] == needle.charAt(0)){
                if (haystack.length() == 1 || needle.length() == 1){
                    return 0;
                }
                if(haystackChar.length - i < needleCahr.length){
                    return -1;
                }else{
                    for (int j = 1; j < needleCahr.length; j++) {
                        if (haystackChar[i+j] == needleCahr[j]){
                            if(j == needleCahr.length-1) return i;
                        }else break;
                    }
                }
            } else continue;
        }
        return -1;
    }




}

