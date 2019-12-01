package com.service;

import com.entity.TextsEntity;

import java.util.List;

/**
 * @author XJ
 */
public interface TextsService {
    List<TextsEntity> getAll();

    int insert(List<TextsEntity> list);
}
