package demo5_exception_own;

public class TestRuntimeException {
    public static void main(String[] args) {

        if (true) {




            try {
                throw new AgeOutOfRuntimException("年龄超出范围!!!");
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println(e.toString());
                //e.printStackTrace();
            }



        }
    }
}
