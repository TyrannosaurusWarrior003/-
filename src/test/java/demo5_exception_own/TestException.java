package demo5_exception_own;

import lombok.Data;


public class TestException {
    public static void main(String[] args) {
        Student student = new Student();
        try {
            student.setAge(6);
        } catch (AgeOutOfException e) {
            e.printStackTrace();
        }
    }
}
