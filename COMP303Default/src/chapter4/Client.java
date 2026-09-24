package chapter4;

public class Client {
    public static void main(String[] args) {
        String hello = "Hello";
        String hello2 = "Hello";
        String hello3 = "Hel" + "lo";
        String hello4 = new String("Hello");
        String hello5 = "XHello".substring(1);

        Integer int1 = 1;
        Integer int2 = 1;
        Integer int3 = Integer.valueOf(1);
        Integer int4 = Integer.parseInt("1");
        Integer int5 = 2 - int1;
        Integer int6 = Integer.compare(2,1);

        Integer a = 1;

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (Integer.valueOf(i) != Integer.valueOf(i)) {
                IO.println(i);
                break;
            }
        }
    }
}
