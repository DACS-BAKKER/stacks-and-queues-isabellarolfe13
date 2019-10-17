//by: Isabella Rolfe
import java.util.Iterator;
public class LinkedList<Item> implements Iterable<Item> {
    private Node start;
    private Node finishedsorted;

    public LinkedList() {
        start=null;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class Node {
        private Item item;
        private Node next;
    }

    public void add(Item item) {
        if(start==null) {
            start=new Node();
            start.item=item;
        }
        else {
            Node temp=start;
            while(temp.next!=null) {
                temp=temp.next;
            }
            temp.next=new Node();
            temp.next.item=item;
        }
    }

    public void insert(int index,int value) {
        if(start==null) {
            start=new Node();
        }
        else {
            Node temp=start;
            for(int x=0;x<index-1;x++) {
                temp=temp.next;
            }
            Node setter=temp.next;
            Node newer=new Node(); //(next)
            temp.next=newer;
            newer.next=setter;
            //adds the item in the position given by index
        }
    }

    public boolean contains(Item value) {
        Node test=start;
        if(test.item==value) {
            return true;
        }
        while(test.next!=null) {
            test=test.next;
            if(test==value) {
                return true;
            }
        }
        //Returns true if this list contains the specified element.
        return false;
    }

    public String toString(){
        String result="";
        Node current=start;
        while(current!=null){
            result+=current.item;
            current=current.next;
        }
        return result;
    }

        public void Reverse() {
            Node prev = null;
            Node cur = start;
            Node next = cur.next;

            while (next!= null) {
               cur.next=prev;
               prev=cur;
               cur=next;
               next=next.next;
            }
            cur.next=prev;
            start=cur;
        }

        public void ReverseRecursive(){
            reverse(null, start);
        }

        private void reverse(Node prev, Node current){
            if(current.next==null){
                //once at end of the list
                start=current;
                current.next=prev;
                return;
            }
            Node n=current.next;
            current.next=prev;
            //call current as previous,
            reverse(current,n);

        }

    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.add(5);
        list.add(8);
        list.add(3);
        list.add(1);
        System.out.println(list.toString());
        //list.Reverse();
        list.ReverseRecursive();
        System.out.println(list.toString());
    }
}



