package aldev.code.tech.dto.response;

import java.util.List;

public class BaseResponse<T> {

    public BaseResponse(String code, String message, List<T> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private String code;

    private String message;

    private List<T> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
