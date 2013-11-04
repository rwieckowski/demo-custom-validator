package pl.rawie.demo.customValidator;

public interface Errors {
    void reject(String message);

    void reject(String property, String message);

    boolean isEmpty();
}
