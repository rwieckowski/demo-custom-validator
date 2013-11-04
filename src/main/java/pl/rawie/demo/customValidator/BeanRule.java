package pl.rawie.demo.customValidator;

public class BeanRule implements Rule<Bean> {
    @Override
    public void check(Bean object, Errors errors) {
        if (object.getStart() > object.getEnd())
            errors.reject("end", "invalid.range");
    }
}
