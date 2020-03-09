package com.eric.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author eric.li
 * @date 2020/3/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    /**
     *在data可能不存在时的构造器
     * @param code
     * @param message
     */
    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
}
