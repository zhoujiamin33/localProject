package com.trkj.thirdproject.aspect;

import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.Opjournal;
import com.trkj.thirdproject.service.OpjournalService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class Logging {
    @Autowired
    private OpjournalService opjournalService;
    //3.环绕通知  指定切入点表达式   不定义返回值类型  在此路径下的 所有包 所有类 所有方法 不限制参数
    @Pointcut("@annotation(com.trkj.thirdproject.aspect.aop.LogginAnnotation)")
    public void x(){

    }
    @Around("x()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.debug(">>>>>>>>>>>>>>>>>>>>>>>>即将进入到{}类的{}方法"
                ,joinPoint.getTarget().getClass().getName()
                ,joinPoint.getSignature());
        Object obj=joinPoint.proceed();
//        Object[] args=joinPoint.getArgs();
        String name1=joinPoint.getSignature().getName().substring(0,3);
        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
//       Class cla=args[0].getClass();
        //获取操作
        LogginAnnotation myLog = method.getAnnotation(LogginAnnotation.class);
        log.debug("ddg"+myLog);
//
        if (name1.equals("add")) {
            String value = myLog.message();
            Opjournal opjournal=new Opjournal();
            opjournal.setEmpId(1);
            opjournal.setOpcontent(value);   //保存获取的操作
            opjournalService.addopjournal(opjournal);
            log.debug("开始新增");
        }
        if (name1.equals("upd")) {
            String value = myLog.message();
            Opjournal opjournal=new Opjournal();
            opjournal.setEmpId(1);
            opjournal.setOpcontent(value);   //保存获取的操作
            opjournalService.addopjournal(opjournal);
            log.debug("开始修改");
        }
        if (name1.equals("del")) {
            String value = myLog.message();
            Opjournal opjournal=new Opjournal();
            opjournal.setEmpId(1);
            opjournal.setOpcontent(value);   //保存获取的操作
            opjournalService.addopjournal(opjournal);
            log.debug("开始删除");
        }


        log.debug("<<<<<<<<<<<<<<<<<<<<<<<<完成{}类的{}方法的执行"
                ,joinPoint.getTarget().getClass().getName()
                ,joinPoint.getSignature());
        return obj;
    }

}
