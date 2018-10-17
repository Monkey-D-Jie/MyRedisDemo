package com.jf.mydemo.myredis.jedis;

import com.jf.mydemo.myredis.utils.DateFormatKit;
import com.jf.mydemo.myredis.utils.RedisCacheUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2018-05-29 14:54
 * @Description: redis工具的测试类
 * To change this template use File | Settings | File and Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-redis.xml"})
public class myRedisTest {
    @Autowired
    private RedisCacheUtil redisCacheUtil;

    @Test
    public void cacheTest() {
        final int[] flag = {0};
        this.redisCacheUtil.setCacheObject("test1", "123456", 40);
        double a = (1.67 / 50) * 0.3;
        System.out.println("要付的钱倍率:" + a);
        System.out.println("配置文件设定的缓存时间超时时间为:30s");
        System.out.println("数据test1存入时间:" + DateFormatKit.convert(DateFormatKit.DATE_FORMAT, new Date())+"缓存时间为:40s");
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("放入放入redis中的test1已经有31s了!");
                System.out.println("当前时间:" + DateFormatKit.convert(DateFormatKit.DATE_FORMAT, new Date()));
            }
        }, 31000);
        while (true) {
        }
    }
}
