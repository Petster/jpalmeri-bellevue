package week04_part01;

class PrintObject<E> implements Traverser<E>
{
   public void visit(E x)
   {
      System.out.print( x + " ");
   }
};

//------------------------------------------------------
public class TestFHTree
{
   // -------  main --------------
   public static void main(String[] args) throws Exception
   {
      FHtree<String> sceneTree = new FHtree<String>(), sceneTree2;
      FHtreeNode<String> tn;
      PrintObject<String> g = new PrintObject<String>();
      
      // create a scene in a room
      tn = sceneTree.addChild(null, "room");
      sceneTree.addChild(tn, "Alice");
      sceneTree.addChild(tn, "table");

      System.out.println("\nAfter adding to the scene:");
      sceneTree.traverse(g);

      // add some parts to Alice ----------------
      // Alice's left arm
      tn = sceneTree.find("Alice");
      tn = sceneTree.addChild(tn, "torso");
      tn = sceneTree.addChild(tn, "left arm");
      tn =  sceneTree.addChild(tn, "left hand");
      sceneTree.addChild(tn, "thumb");
      sceneTree.addChild(tn, "index finger");
      sceneTree.addChild(tn, "middle finger");
      sceneTree.addChild(tn, "ring finger");
      sceneTree.addChild(tn, "pinky");

      System.out.println("\nAfter adding Alice's left arm:");
      sceneTree.traverse(g);

      // Alice's right arm
      tn = sceneTree.find("Alice");
      tn = sceneTree.find(tn, "torso", 0);
      tn = sceneTree.addChild(tn, "right arm");
      tn =  sceneTree.addChild(tn, "right hand");
      sceneTree.addChild(tn, "thumb");
      sceneTree.addChild(tn, "index finger");
      sceneTree.addChild(tn, "middle finger");
      sceneTree.addChild(tn, "ring finger");
      sceneTree.addChild(tn, "pinky");

      System.out.println("\nAfter adding Alice's right arm:");
      sceneTree.traverse(g);

      // add items to table
      tn = sceneTree.find("table");
      tn = sceneTree.addChild(tn, "potion");

      System.out.println("\nAfter adding to the table:");
      sceneTree.traverse(e -> System.out.print(e + ", "));

      // test cloning
      sceneTree2 = (FHtree<String>)sceneTree.clone();

      // remove something from the first tree
      sceneTree.remove("spare mutant paw");
      sceneTree.remove("right hand");
     
      // add some things to the second tree
      tn = sceneTree2.find("right hand");
      sceneTree2.addChild(tn, "6TH FINGER");
      sceneTree2.addChild(tn, "7TH FINGER");

      System.out.println("\n----- Original: should have removed items -----");
      sceneTree.traverse(g);
      System.out.println("\n\n----- Clone: should have extra items -----");
      sceneTree2.traverse(g);
   }
}
