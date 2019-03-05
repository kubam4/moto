package com.machi.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {

    private String errorCode;
    private int statusCode;
    private String fieldName;
    private Object value;
    private String exceptionMessgee;

    public ErrorMessage() {
    }

    public ErrorMessage(@NotNull final String errorCode, @NotNull final HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.statusCode = httpStatus.value();
    }

    public void setExceptionMessgee(final String exceptionMessgee) {
        this.exceptionMessgee = exceptionMessgee;
    }

    public String getExceptionMessgee() {
        return exceptionMessgee;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ErrorMessage that = (ErrorMessage) o;
        return statusCode == that.statusCode
                && Objects.equals(errorCode, that.errorCode)
                && Objects.equals(fieldName, that.fieldName)
                && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, statusCode, fieldName, value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ErrorMessage{");
        sb.append("errorCode='").append(errorCode).append('\'');
        sb.append(", statusCode=").append(statusCode);

        if (!StringUtils.isEmpty(fieldName)) {
            sb.append(", fieldName='").append(fieldName).append('\'');
        }

        if (!StringUtils.isEmpty(value)) {
            sb.append(", fieldValue='").append(value).append('\'');
        }

        sb.append('}');
        return sb.toString();
    }
}
