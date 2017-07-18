package com.github.zdongcoding.aspect;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by zoudong on 2017/7/17.
 */
@Aspect
public class ActivityLifeAspect {

    private static final String TAG = ActivityLifeAspect.class.getSimpleName();

    @Before("execution (* com.github.zdongcoding.aspectjdemo.MainActivity.*(..))")
    public void adviceOnCreateBefore(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Toast.makeText((Context) joinPoint.getTarget(), "Before" + signature.toShortString(), Toast.LENGTH_SHORT).show();
        Log.e(TAG, "" + joinPoint.getSourceLocation() + "Before" + signature.toShortString());
    }

    @After("execution (* com.github.zdongcoding.aspectjdemo.MainActivity.*(..))")
    public void adviceOnCreateAfter(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Toast.makeText((Context) joinPoint.getTarget(), "After" + signature.toShortString(), Toast.LENGTH_SHORT).show();
        Log.e(TAG, "" + joinPoint.getSourceLocation() + "After" + signature.toShortString());
    }

    /**
     * 只能修改当前类有的方法（子类方法必须重写）
     *v
     * @param joinPoint
     * @throws Throwable
     */
    @Before("execution(* android.app.Activity.on**(..))")
    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable {
        Log.e(TAG, "onActivityMethodBefore:------ start");
        Log.e(TAG, joinPoint.getTarget().getClass().getSimpleName()+"-------------"+joinPoint.getSourceLocation().toString());
        Log.e(TAG, "method   ->  " + joinPoint.getSignature().getName());

    }
}
