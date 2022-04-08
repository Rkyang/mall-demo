package com.rky.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.rky.mall.mbg.mapper.PmsBrandMapper;
import com.rky.mall.mbg.model.PmsBrand;
import com.rky.mall.mbg.model.PmsBrandExample;
import com.rky.mall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand pmsBrand) {
        return pmsBrandMapper.insert(pmsBrand);
    }

    @Override
    public int updateBrand(PmsBrand pmsBrand) {
        return pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    @Override
    public int deleteBrand(long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }
}
