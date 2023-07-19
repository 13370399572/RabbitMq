package com.example.solr.entity;


import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.math.BigDecimal;

@Data
@SolrDocument(solrCoreName = "my_solr_core")
public class Product {


    @Id
    @Field
    private String pId;
    @Field("product_name")
    private String productName;

    @Field("product_catalog_name")
    private String productCatalogName;

    @Field("product_description")
    private String productDescription;

    @Field("product_picture")
    private String productPicture;

    @Field("product_price")
    private BigDecimal productPrice;

}
