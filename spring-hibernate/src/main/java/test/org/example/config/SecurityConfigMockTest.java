package test.org.example.config;

import org.example.ApplicationHibernateExample;
import org.example.config.IgnoreUrlsConfig;
import org.example.entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;


/**
 * ProductController Tester.
 *
 * @author <Kelly Guo>
 * @since <pre>Sep. 28, 2020</pre>
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationHibernateExample.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class SecurityConfigMockTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

//    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Before
    public void before() throws Exception {
        System.out.println("ProductControllerTest Begins...");
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


    }

    /**
     *
     * Method: list()
     *
     */
    @Test
    public void testList() throws Exception {
        System.out.println("1.Test Correct Username and Password");
        String username = "admin";
        String password = "123";
        ResponseEntity<Product[]> responseEntity =  this.testRestTemplate.withBasicAuth(username, password).getForEntity("/product/list", Product[].class);
        Product[] products = responseEntity.getBody();
        MediaType contentType = responseEntity.getHeaders().getContentType();
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println(statusCode);
        ignoreUrlsConfig = new IgnoreUrlsConfig();
        this.ignoreUrlsConfig.getUrls().stream().forEach(s ->System.out.println(s.trim()));
    }


}
