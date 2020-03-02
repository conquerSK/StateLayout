package com.shenkai.statelayout.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.shenkai.statelayout.utils.ViewUtils;
import com.itheima.googleplay.view.LoadingPage.LoadResult;

import java.util.List;

public abstract class BaseFragment extends Fragment {

    private com.itheima.googleplay.view.LoadingPage loadingPage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (loadingPage == null) {  // 之前的frameLayout 已经记录了一个爹了  爹是之前的ViewPager
            loadingPage = new com.itheima.googleplay.view.LoadingPage(getActivity()) {

                @Override
                public View createSuccessView() {
                    return BaseFragment.this.createSuccessView();
                }

                @Override
                protected LoadResult load() {
                    return BaseFragment.this.load();
                }
            };
        } else {
            ViewUtils.removeParent(loadingPage);// 移除frameLayout之前的爹
        }

        return loadingPage;  //  拿到当前viewPager 添加这个framelayout
    }

    /***
     *  创建成功的界面
     * @return
     */
    public abstract View createSuccessView();

    /**
     * 请求服务器
     *
     * @return
     */
    protected abstract LoadResult load();

    public void show() {
        if (loadingPage != null) {
            loadingPage.show();
        }
    }


    /**
     * 校验数据
     */
    public LoadResult checkData(List datas) {
        if (datas == null) {
            return LoadResult.error;//  请求服务器失败
        } else {
            if (datas.size() == 0) {
                return LoadResult.empty;
            } else {
                return LoadResult.success;
            }
        }

    }


}