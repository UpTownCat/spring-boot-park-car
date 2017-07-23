package com.example.dto;

/**
 * Created by Administrator on 2017/7/7.
 */
public class StateDto {
    private boolean state;
    private String message;

    public StateDto(boolean state, String message) {
        this.state = state;
        this.message = message;
    }

    public StateDto() {
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
