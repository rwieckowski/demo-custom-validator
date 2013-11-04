package pl.rawie.demo.customValidator;

import javax.validation.ConstraintDefinitionException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RuleValidator implements ConstraintValidator<Satisfied, Object>
{
    private String property;
    private Rule rule;

    @Override
    public void initialize(Satisfied constraintAnnotation) {
        try {
            this.rule = constraintAnnotation.value().newInstance();
        } catch (InstantiationException e) {
            throw new ConstraintDefinitionException(e);
        } catch (IllegalAccessException e) {
            throw new ConstraintDefinitionException(e);
        }
        this.property = constraintAnnotation.property();
    }

    @Override
    @SuppressWarnings("unckecked")
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        ContextErrors errors = new ContextErrors(context);
        rule.check(value, errors);
        return errors.isEmpty();
    }

    private static class ContextErrors implements Errors {
        private ConstraintValidatorContext context;
        private boolean empty = true;

        private ContextErrors(ConstraintValidatorContext context) {
            this.context = context;
            this.context.disableDefaultConstraintViolation();
        }

        @Override
        public void reject(String message) {
            System.out.println("reject: " + message);
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            empty = false;
        }

        @Override
        public void reject(String property, String message) {
            System.out.println("reject: " + message + " @ " + property);
            context.buildConstraintViolationWithTemplate(message).addPropertyNode(property).addConstraintViolation();
            empty = false;
        }

        @Override
        public boolean isEmpty() {
            return empty;
        }
    }
}
