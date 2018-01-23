package com.zkhr.elasticjob.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * @program: springboot-cloud-demo
 * @description: Foo
 * @author: DI CHENG
 * @create: 2018-01-19 10:44
 **/
@JsonSerialize
public class Foo implements Serializable{

    private static final long serialVersionUID = 2345458730555604713L;

    private final long id;
    private final String location;
    private Status status;

    public Foo(long id, String location, Status status) {
        this.id = id;
        this.location = location;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", status=" + status +
                '}';
    }

    public enum Status{
        TODO,
        COMPLETED
    }
}
