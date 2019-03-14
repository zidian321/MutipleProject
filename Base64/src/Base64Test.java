import it.sauronsoftware.base64.Base64;

public class Base64Test {
	public static void main(String [] args){
	String encoded = Base64.encode("Hello, world!");
	   
   // String类型 进行Base64解码
    String decoded = Base64.decode(encoded);
    System.out.println(decoded);
    //指定字符编码方式
   // String encoded = Base64.encode("Hello, world!", "UTF-8");   
   // String decoded = Base64.decode(encoded, "UTF-8");    
    }
}
