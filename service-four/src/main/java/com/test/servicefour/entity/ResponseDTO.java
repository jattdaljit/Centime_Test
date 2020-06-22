package com.test.servicefour.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class ResponseDTO {

    @JsonIgnore
    private Integer id;

    @JsonIgnore
    private Integer parentId;
    private String name;
    private String color;
    private List<ResponseDTO> subclasses;

    public ResponseDTO() {
        this.subclasses = new ArrayList<ResponseDTO>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ResponseDTO> getSubclasses() {
        return subclasses;
    }

    public void setSubclasses(List<ResponseDTO> subclasses) {
        this.subclasses = subclasses;
    }

    public void setChild(ResponseDTO responseDTO) {
        if (!subclasses.contains(responseDTO)) {
            subclasses.add(responseDTO);
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
