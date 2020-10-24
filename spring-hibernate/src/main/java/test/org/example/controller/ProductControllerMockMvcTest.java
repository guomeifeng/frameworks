package test.org.example.controller; 

import com.google.gson.Gson;
import org.example.ApplicationHibernateExample;
import org.example.entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

import javax.annotation.Resource;
import javax.transaction.Transactional;

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
//@AutoConfigureMockMvc
public class ProductControllerMockMvcTest {
//    @Resource
    private MockMvc mockMvc;
    @Resource
    private WebApplicationContext webApplicationContext;
    @Before
    public void before() throws Exception {
        System.out.println("ProductControllerTest Begins...");
        // Also can autowired mockMvc by setting AutoConfigureMockMvc. Here create from MockMvcBuilders manually
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void after() throws Exception {
        System.out.println("ProductControllerTest Ended...");
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
    @Transactional
    @Rollback
    public void testAdd() throws Exception {
        RequestBuilder request = null;
        Product product = new Product();
        product.setProductName("nameb");
        product.setProductDesc("Test from MockMvc");
        Gson gson = new Gson();
        String json = gson.toJson(product);
        request = MockMvcRequestBuilders
                .post("/product/add")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isOk())//返回HTTP状态为200
//                .andExpect(jsonPath("$.status", not("E")))//使用jsonPath解析JSON返回值，判断具体的内容, 此处不希望status返回E
//                .andExpect(content().string(containsString("选择浏览器打开即可")))//返回值为字符串，字符串包含比较，也可以字符串相等等比较，content()表示返回的结果
                .andDo(print());//打印结果
        //.andReturn();//想要返回结果，使用此方法

    }

    /**
    *
    * Test getting products list with an invalid user and role
    *
    */
    @Test(expected = NestedServletException.class)
    @WithMockUser(username = "enjoy", password = "123", roles = {"ADMIN"})
    public void testInvalidRole() throws Exception {
        RequestBuilder request = null;

        request = MockMvcRequestBuilders.get("/product/list");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }
    /**
     *
     * Test getting product list using valid username role and password
     *
     */
    @Test
    @WithMockUser(username = "enjoy", password = "123", roles = {"USER"})
    public void testValidUserAndRole() throws Exception {
        RequestBuilder request = null;

        request = MockMvcRequestBuilders.get("/product/list");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

} 
