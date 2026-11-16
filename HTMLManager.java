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
      tag = new LinkedList<HTMLTag>();
      
      // adding elements to tags
      for (int i  = 0; i < html.size(); i++) {
         HTMLTag cur = html.remove();
         tag.add(cur);
         html.add(cur);
      }
   }
   public Queue<HTMLTag> getTags() {
      return tag;
   }
   
}
