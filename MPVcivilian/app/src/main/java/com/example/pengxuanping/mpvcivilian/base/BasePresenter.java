package com.example.pengxuanping.mpvcivilian.base;

/* be extended by child_presenter, extract common mtd_x of presenter */
public class BasePresenter<V extends BaseView> {

    /* define member view */
    private V mvpView;

    /* 绑定view，一般在初始化中调用该方法, act impl view */
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    /* 断开view，一般在onDestroy中调用 */
    public void detachView() {
        this.mvpView = null;
    }

    /* 是否与View建立连接, avoid activity have been recycled lead to nullpointexception */
    public boolean isViewAttached() {
        return mvpView != null;
    }

    /* 获取view */
    public V getView() {
        return mvpView;
    }
}