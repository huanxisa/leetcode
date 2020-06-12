package arrary;



public class AddTwoNumbers {
    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode solution(ListNode l1, ListNode l2){

        //进位标志
        int flag = 0;

        ListNode result = new ListNode(0);
        ListNode resultTag = result;
        ListNode l1tag = l1;
        ListNode l2tag = l2;

        int x,y;
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
        ListNode l1 = ListNode.creatListByInt(3);
        ListNode l2 = ListNode.creatListByInt(7);
        System.out.println(l2);
        ListNode solution = AddTwoNumbers.solution(l1, l2);
        System.out.println(solution);
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

    @Override
    public String toString() {
        if (next != null) {
            return val + next.toString();
        }
        return String.valueOf(val);
    }
}