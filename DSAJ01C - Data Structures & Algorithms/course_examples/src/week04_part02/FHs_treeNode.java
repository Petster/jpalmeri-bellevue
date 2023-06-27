package week04_part02;

public class FHs_treeNode<E extends Comparable< ? super E > >
{
   // use public access so the tree or other classes can access members 
   FHs_treeNode<E> lftChild;
   FHs_treeNode<E> rtChild;
   protected E data;

   public FHs_treeNode( E d, FHs_treeNode<E> lft, FHs_treeNode<E> rt )
   {
      lftChild = lft; 
      rtChild = rt;
      data = d;
   }
   
   public FHs_treeNode()
   {
      this(null, null, null);
   }
}

