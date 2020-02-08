package com.buy.fish.common.pojo;

/**
 * @ClassName ResultUtil
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/8 17:10
 */
public class ResultUtil<T> {
    private Result<T> result ;

    public ResultUtil(){
        result=new Result<T>();
        result.setSuccess(true);
        result.setMessage("success");
        result.setCode(200);
    }

    public Result<T> setData(T t){
        this.result.setResult(t);
        this.result.setCode(200);
        return this.result;
    }

    public Result<T> setData(T t, String msg){
        this.result.setResult(t);
        this.result.setCode(200);
        this.result.setMessage(msg);
        return this.result;
    }

    public Result<T> setErrorMsg(String msg){
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(500);
        return this.result;
    }
}
