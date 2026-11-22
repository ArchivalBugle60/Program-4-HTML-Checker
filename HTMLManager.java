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
   public string toString() {
      String res = "";
      for (int i = 0; i < tags.size(); i++) {
         HTMLTag cur = tags.remove();
      }
      res = res + cur.toString().trim();
      tags.add(cur);
      return res;
   }
   
}
