package com.trkj.system.manpower_java_system;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class a {
    @Test
    public void a(){
        String format = new SimpleDateFormat("yyyy-MM").format(new Date());
        System.out.println("=========================="+format);
    }
}
