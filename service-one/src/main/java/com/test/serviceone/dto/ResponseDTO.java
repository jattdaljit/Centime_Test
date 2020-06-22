package com.test.serviceone.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Response DTO")
public class ResponseDTO {

    @ApiModelProperty(value = "this field will contain actual response message")
    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
