package pl.rawie.demo.customValidator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Target({ TYPE, METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = RuleValidator.class)
@Documented
public @interface Satisfied {
    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    Class<? extends Rule> value();
    String property() default "";

    @Target({ TYPE, METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Satisfied[] value();
    }
}
