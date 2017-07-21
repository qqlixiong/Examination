package com.shlw.cloudclassroom.mvp.iview;

import java.util.List;

/**
 * Created by lixiong on 16/11/10.
 */

public interface IView<T> {
    void showLoading();

    void showData(List<T> list);
}
