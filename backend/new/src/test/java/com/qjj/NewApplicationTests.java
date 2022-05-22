package com.qjj;

import com.qjj.dao.TrolleyDao;
import com.qjj.model.entity.TrolleyShow;
import com.qjj.service.TrolleyService;
import com.qjj.service.impl.TrolleyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NewApplicationTests {

    @Test
    void contextLoads() {
        TrolleyService service = new TrolleyServiceImpl();
        List<TrolleyShow> list = service.entry(1);
        System.out.println("----------------------" + list.toString());
    }

}
