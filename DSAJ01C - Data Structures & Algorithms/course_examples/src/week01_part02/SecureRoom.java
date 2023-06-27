package week01_part02;

public class SecureRoom
{
	private String name;
	private boolean isUnlocked;

	public SecureRoom(String name)
	{   this.name = name;  }

	// parameterized method
	public <T extends Number> boolean setLock(T newCombination)
	{  
		isUnlocked = decode(newCombination);
		return isUnlocked;
	}

	private <T extends Number> boolean decode(T newCombination)
	{
		// Note: Trivial interpretation of decoding a lock
		if (newCombination != null)
			return true;
		return false;
	}

	public String toString()
	{   return name + "'s room is unlocked? " + this.isUnlocked;  }
}

