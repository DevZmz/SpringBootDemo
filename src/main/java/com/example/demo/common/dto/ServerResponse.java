package com.example.demo.common.dto;

import com.example.demo.common.emuns.ResponseCode;

import java.io.Serializable;

/**
 * 服务响应类
 * <pre>
 *     统一响应返回数据格式
 * </pre>
 * TODO： 添加响应服务类
 * @author zhangmz
 * @create 2017/6/16
 */
//保证序列化json的时候,如果是null的对象,key也会消失
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {

  /*状态码*/
  private int status;

  /*返回消息*/
  private String msg;

  /*泛型数据*/
  private T data;

  private ServerResponse(int status) {
    this.status = status;
  }

  private ServerResponse(int status, T data) {
    this.status = status;
    this.data = data;
  }

  private ServerResponse(int status, String msg, T data) {
    this.status = status;
    this.msg = msg;
    this.data = data;
  }

  private ServerResponse(int status, String msg) {
    this.status = status;
    this.msg = msg;
  }

  /**
   * 创建响应成功
   *
   * @return ServerResponse
   */
  public static <T> ServerResponse<T> createBySuccess() {
    return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
  }

  /**
   * 创建响应成功
   *
   * @param msg 返回消息
   * @return ServerResponse
   */
  public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
    return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
  }

  /**
   * 创建响应成功
   *
   * @param data 数据包
   * @return ServerResponse
   */
  public static <T> ServerResponse<T> createBySuccess(T data) {
    return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
  }

  /**
   * 创建响应成功
   *
   * @param msg 消息
   * @param data 数据包
   * @return ServerResponse
   */
  public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
    return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
  }

  /**
   * 创建响应失败
   *
   * @return ServerResponse
   */
  public static <T> ServerResponse<T> createByError() {
    return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
  }

  /**
   * 创建响应失败
   *
   * @param errorMessage 消息
   * @return ServerResponse
   */
  public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
    return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
  }

  /**
   * 创建响应失败
   *
   * @param errorCode 状态码
   * @param errorMessage 消息
   * @return ServerResponse
   */
  public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
    return new ServerResponse<T>(errorCode, errorMessage);
  }

  //使之不在json序列化结果当中
//  @JsonIgnore
  public boolean isSuccess() {
    return this.status == ResponseCode.SUCCESS.getCode();
  }

  public int getStatus() {
    return status;
  }

  public T getData() {
    return data;
  }

  public String getMsg() {
    return msg;
  }


}
