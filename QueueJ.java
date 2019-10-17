import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
//by: Isabella Rolfe
public class QueueJ<Item> implements Iterable<Item>{
    private Node head;
    private Node tail;
    int size = 0;

     public Iterator<Item> iterator() {
        return null;
      }

      private class ReverseArrayIterator implements Iterator<Item>{
          private int i=size;
          public boolean hasNext(){
              return i>0;
          }
          public void remove(){
              //not supported
          }
          public Item next(){
              throw new NoSuchElementException("Queue is empty!");
          }
      }

    private class Node {
        private Item item;
        private Node next;
    }

    public QueueJ() {
        head=null;
        tail=null;
        int size;
    }

    public boolean isEmpty() {
        return(head==null);
    }

    public void enqueue(Item item) {

        Node n=new Node();
        n.item=item;
        n.next=null;

        if(head==null) {
            head=n;
            tail=n;
        } else {
            tail.next=n;
            tail=n;
        }
        size++;
    }

    public Item dequeue() {
        if (size==0) {
            throw new NoSuchElementException("Queue is empty!");
        }
        Item i=head.item;
        head=head.next;
        size--;
        if(size==0){
            tail=null;
        }
        return i;
    }

    public int size(){
         return size;
    }

    public void Josephus(int skip, int number){
        while(size!=1){
            for(int x=0;x<number;x++){
                if(x==skip){
                    for(int y=0;y<skip;y++){
                        enqueue(dequeue());
                    }
                    System.out.println("Person " + dequeue()+ "  killed.");
                }
            }
        }
        System.out.println("Josephus should sit at spot " + head.item);
    }
    public static void main(String[] args){
        QueueJ<Integer> queue = new QueueJ<Integer>();
        Scanner scan=new Scanner(System.in);
        System.out.print("How many people are in your Josephus problem? ");
        int people=scan.nextInt();
        System.out.print("How many would you like to skip each time?");
        int skip=scan.nextInt();

        for(int x=1; x<=people; x++){
            queue.enqueue(x);
        }
        queue.Josephus(skip,people);
    }
}
