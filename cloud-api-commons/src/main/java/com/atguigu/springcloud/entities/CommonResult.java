package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hujf
 * @title: CommentResult
 * @date 2020/12/11 0011下午 5:33
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code , String message){
        this(code,message,null);
    }
}
