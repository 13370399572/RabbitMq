package com.example.controller.solr;


import com.example.solr.entity.Product;
import com.example.solr.service.SolrService;
import com.rabbitmq.client.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/solr")
public class ProductController {

    @Autowired
    private SolrService solrService;

    @RequestMapping("/querylist/{productName}")
    public List<Product> queryList(@PathVariable("productName") String productName){
      return solrService.queryList(productName);
    }

}
