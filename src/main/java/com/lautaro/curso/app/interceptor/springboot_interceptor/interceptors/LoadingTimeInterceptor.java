package com.lautaro.curso.app.interceptor.springboot_interceptor.interceptors;

import java.util.Random;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor{

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
                HandlerMethod controllerHandlerMethod = (HandlerMethod) handler;
        logger.info("Loading time interceptor: preHandler executing " + controllerHandlerMethod.getMethod().getName() + "...");

        long start = System.currentTimeMillis();
        request.setAttribute("startTime", start);

        Random random = new Random();
        int delay = random.nextInt(500);
        Thread.sleep(delay);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        HandlerMethod controllerHandlerMethod = (HandlerMethod) handler;

        long end = System.currentTimeMillis();
        long start = (Long) request.getAttribute("startTime");
        long loadingTime = end - start;
        logger.info("Loading time interceptor: postHandler quiting " + controllerHandlerMethod.getMethod().getName() + "...");
        logger.info("Loading time: " + loadingTime + " ms");
        logger.info("Tiempo transcurrido " + loadingTime);
    }




}
