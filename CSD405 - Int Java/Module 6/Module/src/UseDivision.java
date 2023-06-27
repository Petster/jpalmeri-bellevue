/*
    Jason Palmeri
    3/21/22
    Assignment6
    Create an abstract class, then create 2 subclasses that use fields and methods from the abstract class
*/

public class UseDivision {
    public static void main(String[] args) {
        InternationalDivision IDOne = new InternationalDivision("KFC", 123, "Great Britain", "English");
        InternationalDivision IDTwo = new InternationalDivision("Target", 146, "America", "English");
    
        DomesticDivision DDOne = new DomesticDivision("Market Basket", 612, "Massachusetts");
        DomesticDivision DDTwo = new DomesticDivision("Rite Aid", 421, "New Hampshire");
    
        System.out.println(IDOne.display());
        System.out.println("-------------------");
        System.out.println(IDTwo.display());
        System.out.println("-------------------");
        System.out.println(DDOne.display());
        System.out.println("-------------------");
        System.out.println(DDTwo.display());

    }
}
