package be.ehb.catalogus.controller;

import be.ehb.catalogus.model.Product;
import be.ehb.catalogus.model.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "products")
public class ProductController {

    ProductDao mProductDao;

    @Autowired
    public ProductController(ProductDao mProductDao) {
        this.mProductDao = mProductDao;
    }

    @GetMapping
    @ResponseBody
    public List<Product> getAllProducts(){
        List<Product> results = new ArrayList<>();
        for(Product p : mProductDao.findAll())
            results.add(p);

        //sinds java 8 via streams
        //mProductDao.findAll().forEach(results::add);

        return results;
    }

    @PostMapping
    @ResponseBody
    public HttpStatus insertProduct(@RequestParam(name = "name") String name,
                                    @RequestParam(name = "description")String description,
                                    @RequestParam(name = "price")float price){

        Product nProduct = new Product();
        nProduct.setName(name);
        nProduct.setDescription(description);
        nProduct.setPrice(price);

        mProductDao.save(nProduct);

        return HttpStatus.OK;
    }

}
