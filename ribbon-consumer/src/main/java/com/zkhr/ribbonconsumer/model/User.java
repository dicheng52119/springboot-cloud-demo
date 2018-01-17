package com.zkhr.ribbonconsumer.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * @program: springboot-cloud-demo
 * @description: User
 * @author: DI CHENG
 * @create: 2018-01-17 12:08
 **/
@JsonSerialize
public class User implements Serializable {

    private static final long serialVersionUID = 7591745763677911508L;

    private Integer id;

    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
