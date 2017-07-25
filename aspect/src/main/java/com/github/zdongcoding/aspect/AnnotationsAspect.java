package com.github.zdongcoding.aspect;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by zoudong on 2017/7/25.
 */

@Aspect
public class AnnotationsAspect {
     @Pointcut("get(@com.github.zdongcoding.aspectjdemo.Runtime * *)")
     void fieldAnnotition(){}
     @Pointcut("execution(@com.github.zdongcoding.aspectjdemo.Runtime !synthetic * *(..))")
     void methodAnnotition(){}

    //     @AfterReturning(pointcut = "fieldAnnotition()",returning = "field")
//     public void fieldAspect(Field field){
//         Log.e("zoudong", "fieldAspect====" + "field = [" + field + "]");
//     }
    @Pointcut("within(@com.github.zdongcoding.aspectjdemo.Runtime *)")
    void  withinclass(){}

    @After("methodAnnotition()&&withinclass()")
    public void MethodAspect(JoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("-----------------")
                .append("\nclass=")
                .append(joinPoint.getTarget().getClass().getName())
                .append("\n")
                .append(signature.getReturnType().getSimpleName())
                .append("  ")
                .append(signature.getName()).append("(");
        for (int i = 0; i < signature.getParameterTypes().length; i++) {
            stringBuffer.append(signature.getParameterTypes()[i].getName())
                    .append("  ")
                    .append(signature.getParameterNames()[i])
                    .append("=")
                    .append(joinPoint.getArgs()[i])
                    .append(",");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1)
                .append(")")
                .append("\n-----------------\n");
        Log.e("zoudong", stringBuffer.toString());
    }

    @AfterReturning(value = "fieldAnnotition()&&withinclass()",returning = "data")
    public void FieldAspect(JoinPoint joinPoint,Object data) throws Throwable {
        Log.e("zoudong", "FieldAspect====" + "joinPoint = [" + joinPoint + "], data = [" + data + "]");
    }
}
