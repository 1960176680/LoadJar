package com.test.dynamic;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class MainActivity extends Activity {
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String libPath = Environment.getExternalStorageDirectory()+ File.separator + "dynamic.jar"; // 要动态加载的jar
                File file=new File(libPath);
                boolean b = file.exists();
                File dexDir = getDir("dex", MODE_PRIVATE); // 优化后dex的路径
                /**
                 * 进行动态加载，利用java的反射调用com.test.dynamic.MyClass的方法
                 */
                DexClassLoader classLoader = new DexClassLoader(libPath, dexDir.getAbsolutePath(), null, getClassLoader());
                try {
                    Class<Object> cls = (Class<Object>) classLoader.loadClass("com.test.dynamic.MyClass");
                    Object object = cls.newInstance();
                    Method method = cls.getMethod("doSomething", null);
                    method.invoke(object, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
