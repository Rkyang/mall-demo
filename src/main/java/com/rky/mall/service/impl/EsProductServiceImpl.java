package com.rky.mall.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.rky.mall.dao.EsProductDao;
import com.rky.mall.nosql.es.document.EsProduct;
import com.rky.mall.nosql.es.repository.EsProductRepository;
import com.rky.mall.service.EsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * 商品搜索管理Service的实现类
 *
 * @date 2022/4/15
 */
@Service
public class EsProductServiceImpl implements EsProductService {

    @Autowired
    private EsProductDao productDao;
    @Autowired
    private EsProductRepository productRepository;

    @Override
    public int importAll() {
        List<EsProduct> allEsProductList = productDao.getAllEsProductList(null);
        Iterable<EsProduct> esProducts = productRepository.saveAll(allEsProductList);
        Iterator<EsProduct> iterator = esProducts.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public EsProduct create(Long id) {
        EsProduct result = null;
        List<EsProduct> allEsProductList = productDao.getAllEsProductList(id);
        if (allEsProductList.size() > 0) {
            EsProduct product = allEsProductList.get(0);
            result = productRepository.save(product);
        }
        return result;
    }

    @Override
    public void delete(List<Long> id) {
        if (CollectionUtil.isNotEmpty(id)) {
            productRepository.deleteAllById(id);
        }
    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return productRepository.findByNameOrSubTitle(keyword, keyword, pageable);
    }
}
