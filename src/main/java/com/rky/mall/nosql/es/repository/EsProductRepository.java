package com.rky.mall.nosql.es.repository;

import com.rky.mall.nosql.es.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 商品ES操作类
 * @date 2022/4/15
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {

    /**
     * elasticsearch可以自定义搜索查询方法，如下面的方法，不用自己写实现，使用方法名即可
     */

    /**
     * 搜索查询
     * @param name 商品名称
     * @param subTitle 商品标题
     * @param pageable 分页信息
     * @return 商品信息
     */
    Page<EsProduct> findByNameOrSubTitle(String name, String subTitle, Pageable pageable);
}
