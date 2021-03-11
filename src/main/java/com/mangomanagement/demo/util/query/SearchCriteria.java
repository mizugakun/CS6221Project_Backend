package com.mangomanagement.demo.util.query;

public class SearchCriteria {
    // the field name
    private final String key;

    // the operation
    private final String operation;

    // the field value
    private final Object value;

    public SearchCriteria(String key, String operation, String value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getOperation() {
        return operation;
    }

    public Object getValue() {
        return value;
    }
}
