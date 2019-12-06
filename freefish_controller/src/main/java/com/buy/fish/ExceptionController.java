package com.buy.fish;

import com.buy.fish.result.BaseRusult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xinjiakun
 * @title: ExceptionController
 * @projectName Freefish
 * @description: TODO
 * @date 2019/12/3 17:47
 */
@ControllerAdvice(basePackages = "com.buy.fish.controller")
public class ExceptionController {

    @ExceptionHandler
    @ResponseBody
    public BaseRusult init(Exception e) {
        BaseRusult baseRusult = new BaseRusult();
        baseRusult.setCode(500);
        baseRusult.setSuccess(false);
        baseRusult.setMessage(e.getMessage());
        return baseRusult;
    }
}
