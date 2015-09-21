# Description
#### Problem Statement
[Remove Duplicates from Sorted List] (http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-list/)

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example

          Given 1->1->2, return 1->2.
          Given 1->1->2->3->3, return 1->2->3.
          
#### Analysis
- Does it need a dummy node?
- How to remove a node from the list?
- Corner Case

#### My Code

        /**
         * Definition for ListNode
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode(int x) {
         *         val = x;
         *         next = null;
         *     }
         * }
         */
        public class Solution {
            /**
             * @param ListNode head is the head of the linked list
             * @return: ListNode head of linked list
             */
            public static ListNode deleteDuplicates(ListNode head) { 
                // write your code here
                if (head == null || head.next == null) return head;
                ListNode current = head;
                ListNode next = head.next;
                while (next != null){
                    if (current.val == next.val) {
                        current.next = next.next;
                        next = current.next;
                    }
                    else {
                        current = current.next;
                        next = next.next;
                    }
                }
                return head;
            }  
        }
#### Test Case
1. Null
2. List with only one node
3. 1->1->1
4. 1->2->2->4
