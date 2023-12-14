package pattern.builder;

/**
 * @program: Maven_Project
 * @ClassName Bike
 * @description:Product Obj
 * @author: Zhenwei Dai
 * @create: 2023-12-13 23:14
 * @Version 1.0
 **/
public class Bike {
    private String frame;

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    private String seat;
}