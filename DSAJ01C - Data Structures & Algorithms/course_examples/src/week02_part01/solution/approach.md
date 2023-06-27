Problem 2
---------
-----------------------------------------------------
Test case 1
NOTES: Demonstrates using iter.remove() method where 
       mIterModCount and modCount remain in sync.
-----------------------------------------------------
Contents of list before remove:
Enter the requested value to remove:
X
Enter number of items to remove:
20
Contents of list after remove:
When, Harry, Met, Sally, Wild, Beast, La, Femme, Nikita, Back, To, The, Future, 


Process finished with exit code 0

<br><br>
-----------------------------------------------------
Test case 2
NOTES: Demonstrates parent class calling remove() method
       and updating modCount. Result is mIterModCount and
       modCount are different. 
-----------------------------------------------------
Contents of list before remove:
Enter the requested value to remove:
X
Enter number of items to remove:
5
Exception in thread "main" java.util.ConcurrentModificationException
	at week02_part01.practice.FHarrayList$FHiterator.next(FHarrayList.java:330)
	at week02_part01.practice.TestRemoveWhileIterating.main(TestRemoveWhileIterating.java:41)

Process finished with exit code 1

