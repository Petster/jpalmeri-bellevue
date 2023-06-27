package week01_part02;

public class BoundedComparableBox<Type extends Comparable>
{
    private Type data;

    public BoundedComparableBox(Type newData)
    {   this.data = newData;  }

    public void setData(Type obj)
    {   this.data = obj;  }

    public Type getData()
    {   return this.data;  }

    public boolean amILarger(BoundedComparableBox other)
    {
        if (this.data.compareTo(other.data) > 1)
            return true;
        return false;
    }

    public String toString()
    {   return data.toString(); }
}