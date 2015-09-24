#Descrition

Spend much time on this one, lol

#### Problem Statement
[Reverse LinkedList II](https://leetcode.com/problems/reverse-linked-list-ii/)

Reverse a linked list from position m to n. Do it in-place and in one-pass.

        For example:
        Given 1->2->3->4->5->NULL, m = 2 and n = 4,
        
        return 1->4->3->2->5->NULL.
        
#### Problem Analysis
Use iterative solution. In each iteration, having three pointers, one points to the previous node, one to the current node,
and one to the last node, move the last node after the previous node (previous to the current node). 

#### My Code
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode(int x) { val = x; }
         * }
         */
        public class Solution {
            public ListNode reverseBetween(ListNode head, int m, int n) {
                if (head == null || head.next == null) return head;
                if (m == n) return head;
                ListNode current = head;
                ListNode dummy = new ListNode(0);
                dummy.next = head;
                ListNode next = current.next;
                ListNode prehead = dummy;
                // find the mth node
                for (int i = 1; i< m; i++){
                    current = current.next;
                    dummy = dummy.next;
                    if (next != null) next = next.next;
                }
                
                while (m < n && next != null){
                    current.next = next.next;
                	next.next = dummy.next;
                	dummy.next = next;
                	next = current.next;
                    m++;
                }
                return prehead.next;
            }
        }
        
#### Time Complexity 
O(n)

#### Test Cases
1. Null
2. List with one node
3. m == n
4. 1->2->3
5. 1->2->3->4->5
