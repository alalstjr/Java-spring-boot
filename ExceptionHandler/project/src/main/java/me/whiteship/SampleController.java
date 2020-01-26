package me.whiteship;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @GetMapping("/hello")
    public String hello() {
        throw new SampleExcepion();
    }

    @ResponseBody
    @ExceptionHandler(SampleExcepion.class)
    public AppError sampleError(SampleExcepion e) {
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReason("NONE");
        return appError;
    }
}
