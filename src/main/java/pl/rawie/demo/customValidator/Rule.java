package pl.rawie.demo.customValidator;

public interface Rule<T> {
    void check(T object, Errors errors);
}
