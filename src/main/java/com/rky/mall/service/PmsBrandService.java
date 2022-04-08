package com.rky.mall.service;

import com.rky.mall.mbg.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand pmsBrand);

    int updateBrand(PmsBrand pmsBrand);

    int deleteBrand(long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(long id);
}
