package com.waper.dataanalysis.repository;

import com.waper.dataanalysis.entity.Props;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName ItemRepository
 * @Description 武器
 * @Author wangpeng
 * @Date 2021/6/21 23:12
 */
public interface ItemRepository extends JpaRepository<Props,Long> {
}
