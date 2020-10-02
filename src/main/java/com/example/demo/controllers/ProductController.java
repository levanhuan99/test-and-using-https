package com.example.demo.controllers;


import com.example.demo.models.Product;
import com.example.demo.services.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products")
    public ResponseEntity<List<Product>> getProductList() {
        List<Product> productList = this.productService.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        this.productService.save(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        Product product1 = this.productService.findOne(id);
        if (product1 == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        product1.setName(product.getName());
        product1.setEmail(product.getEmail());
        this.productService.save(product1);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }


    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        Product product = this.productService.findOne(id);
        this.productService.delete(product);
        return new ResponseEntity<>("Deleted a product", HttpStatus.OK);
    }


    //upload file

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        File convertFile = new File("C:\\Users\\VanHuan\\OneDrive\\Máy tính\\demo-uploadFile\\" + file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        System.out.println("uploaded");
        return "File is upload successfully";

    }

    //download file remember opening with tool that can open image
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadFile() throws FileNotFoundException {
        //this image will be downloaded
        String fileName = "C:\\Users\\VanHuan\\OneDrive\\Máy tính\\java\\info.png";
        File file = new File(fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", String.format("attachment; fileName=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache,no-store,must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        ResponseEntity<Object> responseEntity = ResponseEntity.ok().header(String.valueOf(headers)).contentLength(file.length()).contentType(MediaType.parseMediaType(("application/txt"))).body(resource);
        return responseEntity;
    }

}
