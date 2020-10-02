//package mokitoTest;
//
//import com.example.demo.models.Product;
//import com.example.demo.repos.ProductRepo;
//import com.example.demo.services.impl.ProductService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ProductServiceTest {
//
//    @MockBean
//    private ProductRepo productRepo;
//
//    @Autowired
//    private ProductService productService;
//
//
//    @Test
//    public void When_get_users_it_should_return_user_list() {
//        List<Product> data = new ArrayList<>();
//
//        Product product = new Product();
//        product.setName("name");
//        product.setEmail("name@gmail.com");
//
//        Product product1 = new Product();
//        product1.setName("name1");
//        product.setEmail("name1@gmail.com");
//
//        data.add(product);
//        data.add(product1);
//
//        Mockito.when(productRepo.findAll()).thenReturn(data);
//        assertThat(productService.findAll()).isEqualTo(data);
//    }
//
//}
