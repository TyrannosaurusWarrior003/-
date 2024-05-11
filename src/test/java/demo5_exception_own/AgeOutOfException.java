package demo5_exception_own;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AgeOutOfException extends Exception{
    public AgeOutOfException(String msg) {
        super(msg);
    }
}
