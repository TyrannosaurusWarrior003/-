package demo5_exception_own;

class Student {
    private Integer age;

    public Integer getAge() {
        return age;
    }

    //只要调用这个方法就会用抛出异常来提醒你，要特别注意
    public void setAge(Integer age) throws AgeOutOfException {
        if (age < 0) {
            throw new AgeOutOfException();
        }
    }
}
