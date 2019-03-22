package com.fkit.model;

import java.util.List;

/**
 * Description:
 * Program Name:
 * author :dujianjun
 * Date:2018-03-28  14:27  星期三
 * version 1.0
 */
public class DataGridResult {

    public DataGridResult() {
    }

    public DataGridResult(int total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    private int total;
    private List<?> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
