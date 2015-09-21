# Description
#### Problem Statement

[Reverse a LinkedList] (http://www.lintcode.com/en/problem/reverse-linked-list/)

Example

          For linked list 1->2->3, the reversed linked list is 3->2->1
#### Analysis
- How to solve it recursively?
- How to solve it iteratively? 

#### My Code
1. Recursive

        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode(int x) { val = x; }
         * }
         */
        public class Solution {
            public ListNode reverseList(ListNode head) {
                if (head == null || head.next == null) return head;
                ListNode next = head.next;
                ListNode cur = reverseList(next);
                ListNode newHead = cur;
                while (cur.next != null) cur = cur.next;
                cur.next = head;
                head.next = null;
                return newHead;
            }
        }

2. Iterative

        /**
         * Definition for ListNode.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode(int val) {
         *         this.val = val;
         *         this.next = null;
         *     }
         * }
         */ 
        public class Solution {
            /**
             * @param head: The head of linked list.
             * @return: The new head of reversed linked list.
             */
            public ListNode reverse(ListNode head) {
                // write your code here
               if (head == null || head.next == null) return head;
               ListNode cur = head;
               ListNode next = head.next;
               
               cur.next = null;
               while (head != null && next != null) {
                   ListNode p3 = next.next;
                   next.next = cur;
                   cur = next;
                   if (p3 != null) next = p3;
                   else break;
               }
               return cur;
            }
        }

#### Test Case
1. Null
2. List with just one node
3. 1->2->3
