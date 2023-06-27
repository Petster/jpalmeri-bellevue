package stacks;

/**
 * An object of type Navigator helps to keep track of two StackList objects
 * as well as a currentLink to see where the user is in a set of instructions
 *
 * @author Foothill College, Jason Palmeri
 */
public class Navigator {
    private String currentLink;
    private StackList<String> backLinks;
    private StackList<String> forwardLinks;
    /**
     *  Navigator() creates an object of Navigator that sets default
     *  currentLink to null and initializes empty StackLists for backLinks and forwardLinks
     */
    public Navigator() {
        currentLink = null;
        backLinks = new StackList<String>("backLinks");
        forwardLinks = new StackList<String>("forwardLinks");
    }
    /**
     *  getCurrentLink() returns the currentLink
     */
    public String getCurrentLink() {
        return currentLink;
    }
    /**
     *  getBackLinks() returns the backLinks StackList
     */
    public StackList<String> getBackLinks() {
        return backLinks;
    }
    /**
     *  getForwardLinks() returns the forwardLinks StackList
     */
    public StackList<String> getForwardLinks() {
        return forwardLinks;
    }
    /**
     *  setCurrentLink() sets the current link of Navigator
     *  checks that the currentLink isn't null
     *  and pushes the link to the top of the backLink List
     *  and clears the forwardLinks list
     *  if currentLink is null set the currentLink to the linkName
     *
     * @param linkName the value to add to the backLinks
     */
    public void setCurrentLink(String linkName) {
        if(currentLink != null) {
            backLinks.push(currentLink);
            forwardLinks.clear();
        }
        this.currentLink = linkName;
    }
    /**
     *  goBack() checks that backLinks is not empty
     *  and then pushes the currentLink to forwardLinks List
     *  and sets the currentLink to the top of the backLinks List
     *  if backLinks is empty give a warning message
     */
    public void goBack() {
        if(!backLinks.isEmpty()) {
            forwardLinks.push(currentLink);
            currentLink = backLinks.pop();
        } else {
            System.out.println("WARNING! No back links left");
        }
    }
    /**
     *  goForward() checks if forwardLinks is not empty
     *  create a temp value of the top of forwardLinks
     *  set backLinks top value to the currentLink
     *  set the currentLink to the temp
     *  if forwardLinks is empty give a warning message
     */
    public void goForward() {
        if(!forwardLinks.isEmpty()) {
            String temp = forwardLinks.pop();
            backLinks.push(currentLink);
            currentLink = temp;
        } else {
            System.out.println("WARNING! No forward links left");
        }
    }
}
