package validationtest;

import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.reactivex.Single;

import javax.validation.Valid;

@Validated
@Controller("/")
public class TestController {
    @Get("/asyncok")
    Single<Pojo> asyncok() {
        return Single.just(validate(new Pojo("")));
    }

    @Get("/asyncnotok")
    Single<Pojo> asyncnotok() {
        return Single.just(new Pojo(""));
    }

    @Get("/syncok")
    Pojo syncok() {
        return validate(new Pojo(""));
    }

    @Get("/syncnotok")
    Pojo syncnotok() {
        return new Pojo("");
    }

    public <T> T validate(@Valid T t) {
        return t;
    }
}
