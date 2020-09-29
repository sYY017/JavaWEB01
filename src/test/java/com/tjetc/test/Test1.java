package com.tjetc.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tjetc.domain.Emp;
import com.tjetc.service.EmpService;
import com.tjetc.service.impl.EmpServiceImpl;
import org.junit.Test;

import java.util.List;

public class Test1 {
    private EmpService service=new EmpServiceImpl();
    @Test
    public void a(){
        Emp emp=service.getEmpByNameAndPost("李晓明",1);
        String json=JSON.toJSONString(emp, SerializerFeature.PrettyFormat);
        System.out.println(json);
    }

    @Test
    public void b(){
        
    }
}
