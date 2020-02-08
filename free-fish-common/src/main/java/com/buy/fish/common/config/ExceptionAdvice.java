package com.buy.fish.common.config;

import com.buy.fish.common.pojo.Result;
import com.buy.fish.common.pojo.ResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName ExceptionAdvice
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/8 18:30
 */
@RestControllerAdvice
public class ExceptionAdvice {
    //    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @ExceptionHandler
    public Result exception(Exception e) {
//        logger.error("错误信息{}", e.getStackTrace());
        return new ResultUtil().setErrorMsg("内部错误");
    }
}
