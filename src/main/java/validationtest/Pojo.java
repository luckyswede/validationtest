package validationtest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Pojo {
    @NotNull
    @NotBlank
    private String text;

    public Pojo() {}

    public Pojo(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
