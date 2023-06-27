package week01_part02;

public class BoundedBox <Type extends Number>
{
    private Type data;

    public void setData(Type obj)
    {   this.data = obj;  }

    public Type getData()
    {   return this.data;  }

    public boolean isOdd()
    {   return data.intValue() % 2 != 0; }

    @Override
    public String toString()
    {
        return "" + data.longValue();
    }
}
