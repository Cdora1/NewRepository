
public class AsciiValue {

    public static void main(String[] args) {

        char ch = 'a';
        int ascii = ch;
        // You can also cast char to int
        int castAscii = (int) ch;
        
        castAscii = castAscii +1;
        
        char c = (char)castAscii;
        
        Long l = 8L;
        long l1=8L;
        System.out.println(l==l1);

        Long l2 = new Long(8L);
        Long l3= new Long(8L);
        System.out.println(l2==l3);
        System.out.println(l2.equals(l3));
        System.out.println("The ASCII value of " + ch + " is: " + ascii);
        System.out.println("The ASCII value of " + ch + " is: " + castAscii);
    }
}