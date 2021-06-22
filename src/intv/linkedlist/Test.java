package intv.linkedlist;

public class Test {

	ListNode root;

	public static void main(String[] args) {

		Test t = new Test();
		t.root = new ListNode(1);
		t.root.next = new ListNode(2);
		t.root.next.next = new ListNode(3);
		t.root.next.next.next = new ListNode(3);
		t.root.next.next.next.next = new ListNode(4);
		t.root.next.next.next.next.next = new ListNode(4);
		t.root.next.next.next.next.next.next = new ListNode(5);
		deleteDuplicates(t.root);
		print(t.root);

	}

	static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p, dummy = new ListNode(0);
		p = dummy;
		dummy.next = head;
		while (head != null && head.next != null) {
			if (head.val == head.next.val) {
				while (head.next != null && head.val == head.next.val) {
					head = head.next;
				}
				head = head.next;
				p.next = head;
			} else {
				head = head.next;
				p = p.next;
			}
		}
		return dummy.next;
	}

	static ListNode deleteDuplicates1(ListNode head) {
		ListNode node = head;
		while (node != null) {
			if (node.next != null) {
				if (node.val == node.next.val)
					node.next = node.next.next;
				else
					node = node.next;
			} else
				return head;
		}

		return head;
	}

	static void print(ListNode root) {
		while (root != null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}