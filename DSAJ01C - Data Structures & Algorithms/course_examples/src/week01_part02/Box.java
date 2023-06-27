package week01_part02;

/**
 * A generic box which can hold any Object type.
 * @author Foothill College, Bita M
 *
 * @param <SomeType>	Any child of the class Object.
 */
public class Box<SomeType>
{
	private SomeType data;
	
	public void setData(SomeType obj)
	{   this.data = obj;  }
	
	public SomeType getData()
	{   return this.data;  }
}
