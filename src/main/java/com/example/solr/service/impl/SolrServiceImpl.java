package com.example.solr.service.impl;


import com.example.solr.entity.Product;
import com.example.solr.service.SolrService;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("solrService")
public class SolrServiceImpl implements SolrService {

    @Resource
    private SolrTemplate solrTemplate;

    private final String INDEX_LIBRARY_NAME="my_solr_core";

    @Override
    public void updateSolr(Product solrInventoryEntity) {
        solrTemplate.saveBean(INDEX_LIBRARY_NAME,solrInventoryEntity);
        solrTemplate.commit(INDEX_LIBRARY_NAME);
    }

    @Override
    public void updateSolrs(List<Product> solrInventoryEntitys) {
        solrTemplate.saveBeans(INDEX_LIBRARY_NAME ,solrInventoryEntitys);
        solrTemplate.commit(INDEX_LIBRARY_NAME);
    }

    @Override
    public void delete(List<String> ids) {
         solrTemplate.deleteByIds(INDEX_LIBRARY_NAME ,ids);
    }

    @Override
    public List<Product> queryList(String productName) {
        // 通用条件模板
        Criteria criteria = Criteria.where("productName").is(productName);
        Query query = Query.query(criteria);
        query.addSort(Sort.by(Sort.Direction.DESC, "id"));
        ScoredPage<Product> page =    solrTemplate.query(INDEX_LIBRARY_NAME,query,Product.class);
        return page.getContent();
    }
}
