package com.shlw.cloudclassroom.mvp.imode;

import java.util.List;

/**
 * Created by lixiong on 16/11/10.
 */

public interface IMode {
    void loadData(loadListener listener);

    interface loadListener<T>{
        void onComplete(List<T> list);
    }
}
