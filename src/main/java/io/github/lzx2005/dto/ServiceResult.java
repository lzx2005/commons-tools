package io.github.lzx2005.dto;

public class ServiceResult {

    private int code;
    private String msg;
    private Object data;

    private ServiceResult() {
    }

    public static ServiceResultBuilder builder() {
        return new ServiceResultBuilder();
    }

    public static class ServiceResultBuilder {
        private int code;
        private String msg;
        private Object data;

        private ServiceResultBuilder() {
        }

        public ServiceResult build() {
            ServiceResult serviceResult = new ServiceResult();
            serviceResult.setCode(this.code);
            serviceResult.setMsg(this.msg);
            serviceResult.setData(this.data);
            return serviceResult;
        }

        public ServiceResultBuilder code(int code) {
            this.code = code;
            return this;
        }

        public ServiceResultBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public ServiceResultBuilder data(Object data) {
            this.data = data;
            return this;
        }
    }

    public int getCode() {
        return code;
    }

    public ServiceResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ServiceResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ServiceResult setData(Object data) {
        this.data = data;
        return this;
    }
}
