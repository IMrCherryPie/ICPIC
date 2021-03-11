package com.dstu.dao;

import java.util.List;

public interface DAO<Entity, Key> {
    void create(Entity entity);
    Entity findById(Key key);
    List<Entity> findAll();
    void update(Entity entity);
    void save(Entity entity);
    void delete(Entity entity);
}
