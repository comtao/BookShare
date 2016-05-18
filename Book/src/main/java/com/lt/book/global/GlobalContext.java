package com.lt.book.global;

import android.app.Application;
import android.content.Context;

import com.lt.book.bean.User;
import com.lt.book.support.msg.ImMsgHandler;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import cn.bmob.newim.BmobIM;
import cn.bmob.v3.Bmob;

/**
 * Created by tao.lai on 2016/1/30 0030.
 */
public class GlobalContext extends Application {
    private static final String TAG = "GlobalContext";

    private static GlobalContext gCtx;

    public static GlobalContext getInstance(){
        return gCtx;
    }

    private User user;

    @Override
    public void onCreate() {
        super.onCreate();
        gCtx = this;
        //Bmob.initialize(this, Configs.BOMB_APP_ID);
        BmobIM.init(this);
        BmobIM.registerDefaultMessageHandler(new ImMsgHandler(this));  //注册消息接受器
        initImageLoader(this);
    }

    public static void initImageLoader(Context context) {
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPoolSize(3);
        config.memoryCache(new WeakMemoryCache());
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        //config.writeDebugLogs(); // Remove for release app
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }
}
