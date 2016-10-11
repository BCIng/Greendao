package baochen.greendao;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/9/30.
 */
public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        GreenDaoManager.getInstance();
    }

    public static Context getContext() {
        return mContext;
    }
}
