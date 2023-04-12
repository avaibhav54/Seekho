package com.seekho.seekho.exception;


public class SeekhoException extends RuntimeException{
    String fieldName;
    String errorMessage;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public SeekhoException(String fieldName, String errorMessage)
    {
        super(String.format("%s error %s",fieldName,errorMessage));
        this.fieldName=fieldName;
        this.errorMessage=errorMessage;
    }

}
