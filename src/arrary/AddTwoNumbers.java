package arrary;



public class AddTwoNumbers {

    public static ListNode solution(ListNode l1, ListNode l2){

        //进位标志
        int flag = 0;

        ListNode result = new ListNode(0);
        ListNode resultTag = result;
        ListNode l1tag = l1;
        ListNode l2tag = l2;

        int x ;
        int  y;
        do {
            if(l1tag == null){
                 x = 0;
            }else{
                x =l1tag.val;
            }

            if(l2tag == null) {
                y = 0;
            }else {
                y=l2tag.val;
            }

            ListNode listNode = new ListNode(0);
            listNode.val = (x + y + flag) % 10;
            flag = (x + y + flag) / 10;
            resultTag.next = listNode;
            resultTag = resultTag.next;
            if (l1tag != null){
                l1tag = l1tag.next;
            }
            if (l2tag != null){
                l2tag = l2tag.next;
            }
        }while ( l1tag != null || l2tag != null || flag !=0 );
        resultTag = result;
        result = result.next;
        resultTag.next = null;

        return result;

    }




    public static void main(String[] args) {

        //创建逆序链表 123
        ListNode l1 = ListNode.creatListByInt(631);
        ListNode l2 = ListNode.creatListByInt(542);
        ListNode l3 = ListNode.merge2Lists(l1, l2);
        System.out.println(l3);


    }



}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    static ListNode creatListByInt( int target){
        ListNode result = new ListNode(0);
        ListNode tag = result;
       do {
           ListNode listNode = new ListNode(0);
           listNode.val = target % 10;
           target = target/10;
           tag.next = listNode;
           tag = tag.next;
       } while ( target != 0 );
       //移除开始初始出来的ListNode
        tag = result;
        result = result.next;
        tag.next = null;
        return result;
    }

    public static ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        }
        l2.next = merge2Lists(l1, l2.next);
        return l2;
    }
    @Override
    public String toString() {
        if (next != null) {
            return val + next.toString();
        }
        return String.valueOf(val);
    }
}