package com.service.impl;

import com.dao.TextsDao;
import com.entity.TextsEntity;
import com.service.TextsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XJ
 */
@Service
public class TextsServiceImpl implements TextsService {
    @Autowired
    private TextsDao textsDao;

    @Override
    public List<TextsEntity> getAll() {
        return textsDao.getAll();
    }

    @Override
    public int insert(List<TextsEntity> list) {
        return textsDao.insert(list);
    }
}
