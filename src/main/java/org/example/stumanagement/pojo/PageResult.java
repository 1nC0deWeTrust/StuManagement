package org.example.stumanagement.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private int total;
    private List<T> rows;
}
