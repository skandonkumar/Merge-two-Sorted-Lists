import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> a = new ArrayList<Integer>();
        
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        
        while(temp1 != null){
            if(temp2 == null){
                while(temp1 != null){
                    a.add(temp1.val);
                    temp1 = temp1.next;
                }
                break;
            }
            if(temp1.val < temp2.val){
                a.add(temp1.val);
                temp1 = temp1.next;
            }
            else if(temp2.val < temp1.val){
                a.add(temp2.val);
                temp2 = temp2.next;
            }
            else if(temp1.val == temp2.val){
                a.add(temp1.val);
                a.add(temp2.val);
                temp1 = temp1.next;
                temp2 = temp2.next;
            }            
        }
        
        if(temp1 == null){
            while(temp2 != null){
                    a.add(temp2.val);
                    temp2 = temp2.next;
            }
        }
        
        int[]res = new int[a.size()];
        for(int i=0;i<a.size();i++) {
			res[i] = a.get(i);
		}
        
        ListNode result = add(res);
        return result;
    }
    
    public static ListNode add(int[] a){
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : a) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    public static ListNode getLinkedList(int[] list) {
    	ListNode dummyRoot = new ListNode(0);
	    ListNode ptr = dummyRoot;
	        for(int item : list) {
	            ptr.next = new ListNode(item);
	            ptr = ptr.next;
	        }
	     return dummyRoot.next;
    }
	public static void main(String args[]) {
		int[] list1 = {1, 4 ,6, 9};
		int[] list2 = {1, 2, 5, 14, 18, 21}; 
		
		ListNode l1 = getLinkedList(list1);
		ListNode l2 = getLinkedList(list2);
		
		ListNode result = mergeTwoLists(l1, l2);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
