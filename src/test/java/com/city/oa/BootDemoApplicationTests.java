package com.city.oa;

import com.city.oa.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootDemoApplicationTests {

    @Test
    public void contextLoads() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        System.out.println(user);

    }

}
