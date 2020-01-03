package com.wzw.platform.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class ResponseWrapper<T> {

    private String status = ResponseStatus.OK.getValue();

    private String message = "success";

    private T data;

    public ResponseWrapper(ResponseStatus status, String message) {
        this.status = status.getValue();
        this.message = message;
    }

    public ResponseWrapper(ResponseStatus status, T data) {
        this.status = status.getValue();
        this.data = data;
    }

    public ResponseWrapper(ResponseStatus status, String message, T data) {
        this.status = status.getValue();
        this.message = message;
        this.data = data;
    }

    public ResponseWrapper(T data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status.getValue();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String returnString = "ResponseWrapper{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'';
        if (data instanceof List) {
            if(((List) data).size()>5){
                return returnString +
                        ", dataSize=" + ((List) data).size() +
                        '}';
            }
        } else if (data instanceof PageResult) {
            if (CollectionUtils.isEmpty(((PageResult) data).getData())) {
                return returnString +
                        ", totalCount=" + ((PageResult) data).getTotalCount() +
                        ", dataSize=" + 0 +
                        '}';
            }
            return returnString +
                    ", totalCount=" + ((PageResult) data).getTotalCount() +
                    ", dataSize=" + ((PageResult) data).getData().size() +
                    '}';
        }
        return "ResponseWrapper{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
