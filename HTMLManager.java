import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
   // Part 1 - HTMLManager(Queue<HTMLTag> html)
   public HTMLManager(Queue<HTMLTag> html) {
      // check if it is null
      if (html == null) {
         throw new IllegalArgumentException("null");
         
      }
      // creating a new queue
      tags = new LinkedList<HTMLTag>();
      
      // adding elements to tags
      for (int i  = 0; i < html.size(); i++) {
         HTMLTag cur = html.remove();
         tags.add(cur);
         html.add(cur);
      }
   }
   public Queue<HTMLTag> getTags() {
      return tags;
   }
   
   // to string method
   public String toString() {
      String res = "";
      for (int i = 0; i < tags.size(); i++) {
         HTMLTag cur = tags.remove();
         res = res + cur.toString().trim();
         tags.add(cur);
      
      }
   
      return res;
   }
   
   // Part 2.4- fixHTML()
   public void fixHTML(){
      
      Stack<HTMLTag> stack = new Stack<HTMLTag>();
         // creating a loop to process the queue
         for (int i = 0; i < tags.size(); i++) {
            HTMLTag cur = tags.remove();
            // self closing tags handling
            if (cur.isSelfClosing()) {
               tags.add(cur);
            } else if (cur.isOpening()) { //opening tag handling
               tags.add(cur);
               stack.push(cur);
            } else if (cur.isClosing()) {
               // handling closing tags
               // there are 3 situations t handle (stack empty, top matches and stack not empty, stack not empty and top not matching)
               // check whether stack is empty
               if (stack.isEmpty()) { // discard it
               } else if (stack.peek().matches(cur)) {// If the tag on the top of the stack matches the tag you are currently looking at, then you should add the closing tag back to the queue and remove the opening tag from the stack. 
                  tags.add(cur);
                  stack.pop();
               } else { // If the tag on the top of the stack does not match the closing tag you found, then the writer of the HTML page made a mistake. To fix the mistake, you should add a new closing tag that matches the opening one at the top of the stack
                  tags.add(stack.peek().getMatching());
                  stack.pop();
                  tags.add(cur);
               }
               
            }
            
         }
         // closing leftover tags
         while(!stack.isEmpty()) {
            tags.add(stack.pop().getMatching());
         }
    }
}
