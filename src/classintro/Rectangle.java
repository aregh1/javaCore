package classintro;

/**
 * Created by Areg on 2/26/2017.
 */
public class Rectangle {
    static final int DEFAULT_WIDTH = 30;
    static final int DEFAULT_HEIGHT = 20;

    private int width;
    private int height;

    public Rectangle() {
        this.width = DEFAULT_WIDTH;
        this.height = DEFAULT_HEIGHT;
    }

    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if(width < 0){
            return;
        }
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height < 0){
            return;
        }
        this.height = height;
    }

    int getPerimeter(){
        return 2 * (this.width + height);
    }

    int getArea(){
        return width * height;
    }
    double getDiagonal(){
        return Math.sqrt(width * width + height * height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
