package 泛型;

/**
 * @Description:
 * @Author
 * @Date 2024/1/15
 * @Version 1.0
 */
public class IntegerPrinter {
    private Integer content;

   public IntegerPrinter(Integer content){
       this.content = content;
   }
   public void printf(){
       System.out.println(content);
   }
}
