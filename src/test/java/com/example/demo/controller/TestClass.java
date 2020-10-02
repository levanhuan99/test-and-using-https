package com.example.demo.controller;


import com.example.demo.models.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//Note: remember,importing the right lib


public class TestClass extends AbstractTest{

    @Before
    public void setUp() {
        super.setup();
    }

    @Test
    public void getProductList() throws Exception {
        String uri = "/products";
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
                        .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Product[] productlist = super.mapFromJson(content,
                Product[].class);
        assertTrue(productlist.length > 0);
    }
    @Test
    public void createProduct() throws Exception {
        String uri = "/products";
        Product newProduct=new Product();
        newProduct.setEmail("4@gmail.com");
        newProduct.setName("name4");
        String inputJson=super.mapToJson(newProduct);
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(inputJson)).andReturn();
        int status=mvcResult.getResponse().getStatus();
        assertEquals(200,status);
        String content=mvcResult.getResponse().getContentAsString();
        assertEquals(content,"Product is created successfully");
    }

    @Test
    public void updateProduct() throws Exception {
        String uri = "/products/2";
        Product product = new Product();
        product.setName("Lemon");
        product.setEmail("Lemon@gmail.com");
        String inputJson = super.mapToJson(product);
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Product is updated successfully");
    }

    @Test
    public void deleteProduct() throws Exception {
        String uri="/products/3";
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status=mvcResult.getResponse().getStatus();
        assertEquals(200,status);
        String content=mvcResult.getResponse().getContentAsString();
        assertEquals("Deleted a product",content);
    }


}
