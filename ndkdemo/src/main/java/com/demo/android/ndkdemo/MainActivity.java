package com.demo.android.ndkdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 *
 * ndkdemo
 * 1.在buildgradle中配置so名，指定生成体系结构的so库
 * 2.在gradle.properties中配置android.useDeprecatedNdk=true
 * 3.添加依赖：compile 'com.android.tools.build:gradle-experimental:0.7.0'用于自动生成jni方法
 * 4.新建TestNdk类，声明native接口
 * 5.在native方法上alt+enter 回车则可自动在jni文件夹下生成.c文件，重写.c里面的方法
 * 6.注释刚才添加的依赖，若不注释掉run的时候会报错
 * 7.默认下是不支持ndk调试，右键module->open module settings->buildTypes->jni debuggable 设置为true
 * 8.配置android native-debugger :run->edit configurations->android native下xx-native->debugger->debug type= native
 * 9.生成的.so文件在build/intermediates/ndk/debug/lib下
 */
public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("testjni");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.tv_jni)).setText(new TestNdk().getMessage());

    }
}
