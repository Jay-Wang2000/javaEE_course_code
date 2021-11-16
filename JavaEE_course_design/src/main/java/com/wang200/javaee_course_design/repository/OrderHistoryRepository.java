package com.wang200.javaee_course_design.repository;

import com.wang200.javaee_course_design.bean.OrderHistory;
import org.springframework.data.repository.CrudRepository;

public interface OrderHistoryRepository extends CrudRepository<OrderHistory, String>{

}
