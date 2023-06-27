package week01_part02;

public class StorageBox<T extends BoundedBox<? super Number>>
{
    private T volume;

    public StorageBox(T volume)
    {
        this.volume = volume;
    }

    public double divideBox()
    {
        if (volume.isOdd())
        {
            System.err.println("Cannot evenly divide " + volume);
        }
        return volume.getData().doubleValue()  / 2;
    }
}
