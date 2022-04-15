package com.rky.mall.dao;

import com.rky.mall.nosql.es.document.EsProduct;

import java.util.List;

/**
 * 搜索系统中的商品管理自定义DAO
 * @date 2022/4/15
 */
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(Long id);
}
