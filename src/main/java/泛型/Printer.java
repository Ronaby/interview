package 泛型;

/**
 * @Description:
 * @Author
 * @Date 2024/1/15
 * @Version 1.0
 */
public class Printer<T> {
    private T content;

    public Printer(T content){
        this.content = content;
    }

    public void printf(){
        System.out.println(content);
    }
}
