package pl.rawie.demo.customValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        validate(new Bean("foo", 1, 2));
        validate(new Bean("foo", 3, 2));
    }

    private static void validate(Bean bean) {
        System.out.println(bean);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Bean>> constraintViolations = validator.validate(bean);
        System.out.println(constraintViolations);
    }
}
