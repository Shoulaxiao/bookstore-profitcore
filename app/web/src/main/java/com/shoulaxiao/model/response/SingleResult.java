package com.shoulaxiao.model.response;

/**
 * @Author shoulaxiao
 * @Date 2021/3/3 19:37
 * @Description TODO 默认返回结果，返回单数据
 * @Version 1.0
 **/
public class SingleResult<T> extends BaseResult {
    private static final long serialVersionUID = 7859434115405298965L;

    private T data;

    public SingleResult(){
        super();
    }

    public SingleResult(T data){
        super();
        this.data=data;
    }

    public SingleResult(T data,String errorCode,String errorMessage){
        super(errorCode,errorMessage);
        this.data=data;
    }


    public SingleResult(T data,boolean success,String errorCode,String errorMessage){
        super(success,errorCode,errorMessage);
        this.data=data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString(){
        String str=super.toString();
        StringBuilder sb=new StringBuilder();
        sb.append(str).append(",").append(data);
        return sb.toString();
    }
}
