package test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.entity.SourceZm;
import com.zs.service.SourceZmSer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class ServiceTest extends AbstractJUnit4SpringContextTests{

	@Resource
	private SourceZmSer sourceZmSer;
	
	@Test
	public void getLast() {
		SourceZm zm=sourceZmSer.last("6000014092181");
		System.out.println(zm);
	}
	
}
