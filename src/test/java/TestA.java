import org.junit.Test;

/**
 * @author zhangzhidong
 * @create: 2019-03-17 22:47
 */
public class TestA {

    @Test
    public void testa() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] two = new int[2];
        for (int index = 0; index < nums.length - 1; index++) {
            for (int i = index + 1; i < nums.length; i++) {
                if (nums[index] + nums[i] == target) {
                    two[0] = index;
                    two[1] = i;
                }
            }
        }

    }

    @Test
    public void testb() {

        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(3);

        listNode.next = listNode1;
        listNode1.next = listNode2;


        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(4);

        listNode3.next = listNode4;
        listNode4.next = listNode5;

        addTwoNumbers(listNode, listNode3);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String l1str = "";
        while (l1.next != null) {
            l1str = l1str + l1.val;
            l1 = l1.next;
        }
        l1str = l1str + l1.val;

        String l2str = "";
        while (l2.next != null) {
            l2str = l2str + l2.val;
            l2 = l2.next;
        }
        l2str = l2str + l2.val;

        Long sum = Long.valueOf(l1str) + Long.valueOf(l2str);
        String sumstr = sum + "";

        ListNode head = null;

        char[] chars = sumstr.toCharArray();

        ListNode temp = null;
        for (int i = chars.length - 1; i >= 0; i--) {
            Integer integer = Integer.valueOf(chars[i] + "");
            ListNode node = new ListNode(integer);
            if (i == chars.length - 1) {
                head = node;
                temp = node;
                continue;
            }
            temp.next = node;
            temp = node;
        }
        return head;
    }

    @Test
    public void testc() {
        GenericType genericType = new GenericType();


    }
}
