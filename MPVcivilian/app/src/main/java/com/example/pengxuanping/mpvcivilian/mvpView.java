package com.example.pengxuanping.mpvcivilian;

import com.example.pengxuanping.mpvcivilian.base.BaseView;

/* interface_view be impled on cls_activity, call by cls_presenter, as a bridge */
public interface mvpView extends BaseView {
    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(String data);
}
