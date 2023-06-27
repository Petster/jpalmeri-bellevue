Week 1 Part 2
========================

Learning Objectives
-------------------
- Subset Sum

<hr>

<br>


Problem 1
---------
****Determine the set of items S to buy below.**<br>
<code>bananas,2.50
apples,4
beans,11.50
mushrooms,7
watermelon,15
juice,4
avocadoes,6
rasberries,8</code>

**What is the closets sublist of items that we can purchase 
given the following target budgets?**

- budget $22
- budget $22.20
- budget $2
- budget $200

Recall the pseudo-code for the subset sum algorithm is:
<pre><code>Initialize the collection Col with one sub-list: the empty sub-list.
outer-loop: Loop over all elements x in S
    inner-loop: Loop over all subsets, L, that are already members of Col
        first-if: if sum(L) + x ≤ t, add the sub-list L + x to Col
        second-if: if sum(L) + x == t, break from both loops!
Of all the subsets that end up in Col, find the sub-list L' with the largest sum()</code></pre>

**As part of your answer, show the updated collection Col at the 
beginning of each iteration of the inner-loop.**
<br><br>**
