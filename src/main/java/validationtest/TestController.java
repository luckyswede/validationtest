package validationtest;

import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.reactivex.Single;

import javax.validation.Valid;

@Validated
@Controller("/")
public class TestController {
    @Get("/asyncok")
    @Valid
    public Single<Pojo> asyncok() {
        return Single.just(validate(new Pojo("")));
    }

    @Get("/asyncnotok")
    @Valid
    public Single<Pojo> asyncnotok() {
        return Single.just(new Pojo(""));
    }

    @Get("/syncok")
    @Valid
    public Pojo syncok() {
        return validate(new Pojo(""));
    }

    @Get("/syncnotok")
    @Valid
    public Pojo syncnotok() {
        return new Pojo("");
    }

    public <T> T validate(@Valid T t) {
        return t;
    }
}
