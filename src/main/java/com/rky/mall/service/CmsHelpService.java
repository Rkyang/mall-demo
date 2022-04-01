package com.rky.mall.service;

import com.rky.mall.mbg.model.CmsHelp;

import java.util.List;

public interface CmsHelpService {
    List<CmsHelp> listAllHelp();

    int createHelp(CmsHelp help);

    int updateHelp(CmsHelp help);

    int deleteHelp(Long id);

    List<CmsHelp> listHelp(int pageNum, int pageSize);

    CmsHelp getHelp(Long id);
}
