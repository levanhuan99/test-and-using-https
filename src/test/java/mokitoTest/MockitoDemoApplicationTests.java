//package mokitoTest;
//
//import com.example.demo.models.Product;
//import com.example.demo.services.impl.ProductService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.ArrayList;
//import java.util.List;
//import static org.junit.Assert.assertTrue;
//
//@SpringBootTest
//@ActiveProfiles("test")
//public class MockitoDemoApplicationTests {
//
//    @Autowired
//    private ProductService productService;
//
//    @Test
//    public void getAllProducts(){
//        List<Product> productList=new ArrayList<>();
//        Mockito.when(productList=productService.findAll()).thenReturn(productList);
//        assertTrue(productList.size() > 0);
//    }
//}
