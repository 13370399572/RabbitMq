package com.example.solr.service;

import com.example.solr.entity.Product;

import java.util.List;

public interface SolrService {

    void updateSolr(Product solrInventoryEntity);

    void updateSolrs(List<Product> solrInventoryEntitys);

    void delete(List<String> ids);

    List<Product> queryList(String productName);

   // IPage<Product> queryHighlightList(Integer pageIndex, Integer pageSize, String drugname);
}
