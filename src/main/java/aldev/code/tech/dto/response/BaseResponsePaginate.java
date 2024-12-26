package aldev.code.tech.dto.response;

import java.util.List;

public class BaseResponsePaginate<T> {


    public BaseResponsePaginate(String code, String message, List<T> data, Integer page, Integer size, Long totalData) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.page = page;
        this.size = size;
        this.totalData = totalData;
    }

    private String code;

    private String message;

    private List<T> data;

    private Integer page;

    private Integer size;

    private Long totalData;

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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotalData() {
        return totalData;
    }

    public void setTotalData(Long totalData) {
        this.totalData = totalData;
    }
}
