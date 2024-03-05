package com.chuwa.KotlinRedbook.Controller

import java.util.Stack

class palindrome {
    fun isPalindrome(x: Int): Boolean {
        val str : String = x.toString();
        for(i in 0..str.length / 2){
            if(str[i] != str[str.length - 1 - i]) return false;
        }
        return true;
    }

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>();
        for(c in s){
            when(c){
                '(','[','{' -> stack.push(c);
                ')' -> if(stack.isEmpty() || stack.pop() != '(') return false;
                ']' -> if(stack.isEmpty() || stack.pop() != '[') return false;
                '}' -> if(stack.isEmpty() || stack.pop() != '{') return false;
            }
        }
        return true;
    }

    fun searchInsert(nums: IntArray, target: Int): Int {
        var l : Int = 0
        var r : Int = nums.size
        while(l < r){
            val mid : Int = (l + r) / 2
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}