package demo5_exception_own;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AgeOutOfRuntimException extends RuntimeException{
    public AgeOutOfRuntimException (String msg) {
        super(msg);
    }
}

