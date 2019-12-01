package com.dao;

import com.entity.TextsEntity;

import java.util.List;

/**
 * @author XJs
 */
public interface TextsDao {

    List<TextsEntity> getAll();

    int insert(List<TextsEntity> list);
}
