package com.ratpack.downloadhound.data.repository;

import com.ratpack.downloadhound.data.entity.History;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {
}
