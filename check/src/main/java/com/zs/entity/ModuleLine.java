package com.zs.entity;

import java.util.Date;

public class ModuleLine {
    private String id;

    private String moduleName;

    private String title;

    private String lineField;

    private String lineWidth;

    private String formatter;

    private Date createTime;

    private String sortable;

    private String rowspan;

    private String colspan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getLineField() {
        return lineField;
    }

    public void setLineField(String lineField) {
        this.lineField = lineField == null ? null : lineField.trim();
    }

    public String getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(String lineWidth) {
        this.lineWidth = lineWidth == null ? null : lineWidth.trim();
    }

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter == null ? null : formatter.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSortable() {
        return sortable;
    }

    public void setSortable(String sortable) {
        this.sortable = sortable == null ? null : sortable.trim();
    }

    public String getRowspan() {
        return rowspan;
    }

    public void setRowspan(String rowspan) {
        this.rowspan = rowspan == null ? null : rowspan.trim();
    }

    public String getColspan() {
        return colspan;
    }

    public void setColspan(String colspan) {
        this.colspan = colspan == null ? null : colspan.trim();
    }
}