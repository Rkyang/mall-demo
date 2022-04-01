package com.rky.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.rky.mall.mbg.mapper.CmsHelpMapper;
import com.rky.mall.mbg.model.CmsHelp;
import com.rky.mall.mbg.model.CmsHelpExample;
import com.rky.mall.service.CmsHelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CmsHelpServiceImpl implements CmsHelpService {

    @Autowired
    private CmsHelpMapper cmsHelpMapper;

    @Override
    public List<CmsHelp> listAllHelp() {
        return cmsHelpMapper.selectByExample(new CmsHelpExample());
    }

    @Override
    public int createHelp(CmsHelp help) {
        return cmsHelpMapper.insert(help);
    }

    @Override
    public int updateHelp(CmsHelp help) {
        return cmsHelpMapper.updateByPrimaryKeySelective(help);
    }

    @Override
    public int deleteHelp(Long id) {
        return cmsHelpMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CmsHelp> listHelp(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return cmsHelpMapper.selectByExample(new CmsHelpExample());
    }

    @Override
    public CmsHelp getHelp(Long id) {
        return cmsHelpMapper.selectByPrimaryKey(id);
    }
}
