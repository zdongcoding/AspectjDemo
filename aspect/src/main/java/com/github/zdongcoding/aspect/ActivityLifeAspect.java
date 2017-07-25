//package com.github.zdongcoding.aspect;
//
//import android.content.Context;
//import android.util.Log;
//import android.widget.Toast;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//
///**
// * Created by zoudong on 2017/7/17.
// */
//@Aspect
//public class ActivityLifeAspect {
//
//    private static final String TAG = ActivityLifeAspect.class.getSimpleName();
//
//    @Before("execution (* com.github.zdongcoding.aspectjdemo.MainActivity.onCreate(..))")
//    public void adviceOnCreateBefore(JoinPoint joinPoint) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Toast.makeText((Context) joinPoint.getTarget(), "Before" + signature.toShortString(), Toast.LENGTH_SHORT).show();
//        Log.e(TAG, "" + joinPoint.getSourceLocation() + "Before" + signature.toShortString());
//    }
//
//    @After("execution (* com.github.zdongcoding.aspectjdemo.MainActivity.onCreate(..))")
//    public void adviceOnCreateAfter(JoinPoint joinPoint) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Toast.makeText((Context) joinPoint.getTarget(), "After" + signature.toShortString(), Toast.LENGTH_SHORT).show();
//        Log.e(TAG, "" + joinPoint.getSourceLocation() + "After" + signature.toShortString());
//    }
//
//    @Around("execution (* com.github.zdongcoding.aspectjdemo.MainActivity.onDdd())")
//    public void adviceOnDDAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        Log.e("zoudong", "adviceOnDDAround====" + "joinPoint1 = [" + joinPoint.getSignature() + "]");
//        joinPoint.proceed();
//        Log.e("zoudong", "adviceOnDDAround====" + "joinPoint2 = [" + joinPoint.getSignature() + "]");
//    }
//
//    @Around("call (* com.github.zdongcoding.aspectjdemo.MainActivity.onDdd())")
//    public void adviceOnDDAroundCall(ProceedingJoinPoint joinPoint) throws Throwable {
//        Log.e("zoudong", "adviceOnDDAroundCall====" + "joinPoint1 = [" + joinPoint.getSignature() + "]");
//        joinPoint.proceed();
//        Log.e("zoudong", "adviceOnDDAroundCall====" + "joinPoint2 = [" + joinPoint.getSignature() + "]");
//    }
//
//    /**
//     * 只能修改当前类有的方法（子类方法必须重写）
//     * v
//     *
//     * @param joinPoint
//     * @throws Throwable
//     */
////    @Before("execution(* android.app.Activity.on**(..))")
////    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable {
////        Log.e(TAG, "onActivityMethodBefore:------ start");
////        Log.e(TAG, joinPoint.getTarget().getClass().getSimpleName()+"-------------"+joinPoint.getSourceLocation().toString());
////        Log.e(TAG, "method   ->  " + joinPoint.getSignature().getName());
////
////    }
//    @AfterThrowing(pointcut = "execution(* com.github.zdongcoding.aspectjdemo.MainActivity.throwNullPoint(..))", throwing = "exception")
//    public void throwNullPoint(Exception exception) {
//        Log.e("zoudong", "throwNullPoint====" + " exception = [" + exception.toString() + "]");
//    }
//
//    @Pointcut(value = "execution(* com.github.zdongcoding.aspectjdemo.MainActivity.AfterReturning(..)) && args(a)", argNames = "a")
//    private void argName(String a) {
//    }
//
//    @AfterReturning(pointcut = "argName(a)", argNames = "a", returning = "name")
//    public void AfterReturning(JoinPoint joinPoint, String a, int name) {
//        Log.e(TAG, "joinPoint.getArgs():" + joinPoint.getArgs()[0]);
//        Log.e("zoudong", "AfterReturning====" + "joinPoint = [" + joinPoint + "],return name = [" + name + "]arg=" + a);
//    }
//    @Pointcut("get(int com.github.zdongcoding.aspectjdemo.MainActivity.base)")
//    public void fieldget() {
//    }
//
////    @Around("fieldget()")
////    public int  fieldget(ProceedingJoinPoint thisJoinPoint) throws Throwable {
//////        Object proceed = thisJoinPoint.proceed();
//////        Log.e("zoudong", "Around fieldget proceed="+proceed);
////        Log.e("zoudong", "fieldget====" + "thisJoinPoint = [" + thisJoinPoint + "]");
////        return 111;
////    }
//
//    @AfterReturning(pointcut = "fieldget()", returning = "base")
//    public void fieldget2(JoinPoint joinPoint, int base) {
//        Log.e("zoudong", "fieldget2====" + "joinPoint = [" + joinPoint + "], base = [" + base + "]");
//    }
////    @After(value = "fieldget() && args(base)",argNames = "base")
////    public void fieldget3(JoinPoint joinPoint,int base) {
////        Log.e("zoudong", "fieldget3====" + "joinPoint = [" + joinPoint + "]"+base);
////    }
////    @Before(value = "fieldget()")
////    public void fieldget4(JoinPoint joinPoint) {
////        Log.e("zoudong", "fieldget4====" + "joinPoint = [" + "]"+joinPoint.toLongString());
////    }
//    @Pointcut("set(int com.github.zdongcoding.aspectjdemo.MainActivity.base)")
//    public void fieldset() {}
////    @Around("fieldset()")
////    public void  fieldset(ProceedingJoinPoint joinPoint) throws Throwable {
////        Log.e(TAG, "around->" + joinPoint.getTarget().toString() + "#" + joinPoint.getArgs()[0]);
////        joinPoint.proceed(new Integer[]{100000});
////    }
//
////    @After("fieldset()")
////    public void  afterfieldset(JoinPoint joinPoint) throws Throwable {
////        Log.e(TAG, " @After(\"fieldset()\")->" + "#" + joinPoint.getArgs()[0]);
////    }
////    @Before("fieldset()")
////    public void  beforefieldset(JoinPoint joinPoint) throws Throwable {
////        Log.e(TAG, "  @Before(\"fieldset()\")->" + "#" + joinPoint.getArgs()[0]);
////    }
//
//    @Around("fieldset()")
//    public  void   aroundfieldset(ProceedingJoinPoint joinPoint) throws Throwable {
//        Log.e(TAG, "  @Around(\"fieldset()\")->" + "#" + joinPoint.getArgs()[0]+"--->");
//        joinPoint.proceed(new Integer[]{1001});
//    }
//    public static final String invokeonDdd = "withincode(* com.github.zdongcoding.aspectjdemo.MainActivity.onDdd(..))";
//    public static final String test01 = "call(* com.github.zdongcoding.aspectjdemo.MainActivity.test01(..))";
//
//    @Pointcut(invokeonDdd)
//    public void invokeOnDdd() {
//
//    }
//
//    @Pointcut(test01)
//    public void invoketest01() {
//
//    }
//
//    @Pointcut("invokeOnDdd()&&invoketest01()")
//    public void invoketest01OnlyOnDdd() {
//
//    }
//
//    @Before("invoketest01OnlyOnDdd()")
//    public void invoketest01OnlyOnDddBefore(JoinPoint joinPoint) {
//        Log.e("zoudong", "invoketest01OnlyOnDddBefore====" + "joinPoint = [" + joinPoint.getSourceLocation() + "]");
//    }
//
//    @After("invoketest01()&&invokeOnDdd()")
//    public void invoketest01OnlyOnDddAfter(JoinPoint joinPoint) {
//        Log.e("zoudong", "invoketest01OnlyOnDddAfter====" + "joinPoint = [" + joinPoint.getSourceLocation() + "]");
//    }
//}
