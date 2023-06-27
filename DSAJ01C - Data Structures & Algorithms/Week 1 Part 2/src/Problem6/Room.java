package Problem6;

public class Room<T> {
    private int height;
    private int width;
    private T firstContainer;
    private T secondContainer;

    @Override
    public String toString() {
        return "Room{" +
                "height=" + height +
                ", width=" + width +
                ", firstContainer=" + firstContainer +
                ", secondContainer=" + secondContainer +
                '}';
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public T getFirstContainer() {
        return firstContainer;
    }

    public void setFirstContainer(T firstContainer) {
        this.firstContainer = firstContainer;
    }

    public T getSecondContainer() {
        return secondContainer;
    }

    public void setSecondContainer(T secondContainer) {
        this.secondContainer = secondContainer;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Room(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void setContents(T firstContainer, T secondContainer) {
        this.firstContainer = firstContainer;
        this.secondContainer = secondContainer;
    }
}
