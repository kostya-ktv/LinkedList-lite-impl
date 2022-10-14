public class CustomLinkedList {
   public Integer size = 0;
   private Node tail;
   private Node head;
   /* Add a new value to the end of list */
   public void push(Integer value) {
      Node newValue = new Node(value);

      if(tail == null && head == null) {
         tail = newValue;
         head = newValue;
      } else {
         tail.setNext(newValue);
         newValue.setPrevious(tail);
         tail = newValue;
      }
      size++;
   }
   /** Add a new value to head */
   public void unshift(int value) {
      Node newValue = new Node(value);

      if(tail == null && head == null) {
         tail = newValue;
         head = newValue;
      } else {
         head.setPrevious(newValue);
         newValue.setNext(head);
         head = newValue;
      }
      size++;
   }
   /** Remove value by index */
   public void remove(int index) {
      if(index < 0) throw new Error("invalid index");
      if(index > size) throw new Error("invalid index");
      if(tail == null) return;
      int position = 0;
      Node tmp = head;
      while(true) {
         if(position == index) {
          Node nextVictimNode = tmp.next;
          Node previousVictimNode = tmp.previous;
          
          if(nextVictimNode != null){
            if(previousVictimNode != null){
               nextVictimNode.setPrevious(previousVictimNode);
            } else {
               nextVictimNode.setPrevious(null);
            }
          }
          if(previousVictimNode != null) {
            if(nextVictimNode != null) {
               previousVictimNode.setNext(nextVictimNode);
            }else {
               previousVictimNode.setNext(null);
            }
          }
          if(previousVictimNode == null && nextVictimNode == null){
            head = null;
            tail = null;
          }
          tmp.setNext(null);
          tmp.setPrevious(null);

          size--;
            break;
         } else {
            position++;
            tmp = tmp.next;
         }
      }
   }
   /** Convert list to string of values */
   public String listToString() {
      String result = "";
      if(tail ==  null) return result;
      Node tmp = tail;
      while(true) {
         if(tmp == null) break;
         result = tmp.value.toString() + "," + result;
         tmp = tmp.previous;
      }
      return result;
   }
   class Node {
      public Node next;
      public Node previous;
      public Integer value;
      public Node(int number) {
         this.value = number;
      }
      public void setNext(Node next) {
         this.next = next;
      }
      public void setPrevious(Node previous) {
         this.previous = previous;
      }
      
   }
}
