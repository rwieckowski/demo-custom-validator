package pl.rawie.demo.customValidator;

import org.hibernate.validator.constraints.NotEmpty;

@Validation(value=BeanRule.class)
public class Bean {
    @NotEmpty
    private String name;
    private int start;
    private int end;

    public Bean(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
