#Description
#### Problem Statement
[Remove Duplicates from Sorted List II] (http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-list-ii/)

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example

        Given 1->2->3->3->4->4->5, return 1->2->5.
        Given 1->1->1->2->3, return 2->3.
        
#### Analysis
- Use a dummy node?
- How to deal with duplicates nodes with number of 3 or more
- Be aware of null pointer exception

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
             * @return: ListNode head of the linked list
             */
            public static ListNode deleteDuplicates(ListNode head) {
                // write your code here
                if (head == null || head.next == null) return head;
                ListNode dummy = new ListNode(0);
                dummy.next = head;
                ListNode result = dummy;
                ListNode current = head;
                ListNode next = head.next;
                
                while (next != null) {
                    if (current.val != next.val) {
                        dummy = current;
                        current = current.next;
                        next = next.next;
                    }
                    else {
                    while (next != null && current.val == next.val ){
                        next = next.next;
                    }
                        dummy.next = next;
                        current = next;
                        if (current != null)next = current.next;
                    }
                }
                return result.next;
            }
        }

#### Test Cases
1. null
2. List with one node
3. [1,1]
4. [1,1,1,1,1]
5. [1,1,2,3,4]
