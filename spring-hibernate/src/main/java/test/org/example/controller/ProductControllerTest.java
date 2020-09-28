package test.org.example.controller; 

import org.aspectj.lang.annotation.Before;
import org.example.ApplicationHibernateExample;
import org.junit.Test;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/** 
* ProductController Tester. 
* 
* @author <Kelly Guo>
* @since <pre>Sep. 28, 2020</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationHibernateExample.class)
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Resource
    private MockMvc mockMvc;
    @Resource
    private WebApplicationContext webApplicationContext;
    @BeforeEach
    public void before() throws Exception {
        //此种方式可通过spring上下文来自动配置一个或多个controller
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        //此种方式，手工指定想要的controller
        //mockMvc = MockMvcBuilders.standaloneSetup(new Controller1(), new Controller2()).build();

    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: get(@PathVariable("id") long id)
    *
    */
    @Test
    public void testGet() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: add(@RequestBody Product product)
    *
    */
    @Test
    public void testAdd() throws Exception {


    }

    /**
    *
    * Method: list()
    *
    */
    @Test
    public void testList() throws Exception {
        RequestBuilder request = null;
        //构造请求
        request = MockMvcRequestBuilders.get("/product/list");
        //执行请求
        mockMvc.perform(request)
                .andExpect(status().isOk())//返回HTTP状态为200
//                .andExpect(jsonPath("$.status", not("E")))//使用jsonPath解析JSON返回值，判断具体的内容, 此处不希望status返回E
//                .andExpect(content().string(containsString("选择浏览器打开即可")))//返回值为字符串，字符串包含比较，也可以字符串相等等比较，content()表示返回的结果
                .andDo(print());//打印结果
        //.andReturn();//想要返回结果，使用此方法
    }


} 
