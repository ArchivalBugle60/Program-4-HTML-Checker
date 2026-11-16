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
   
}
