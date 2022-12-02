/**
 * This services provides database transactions for Order Detail
 * via Jpa Repository
 *
 * @author  Christian Montifar
 * @version 1.0
 * @since   2022-12-02
 */
package com.exam.ehrlichpizzaexam.persistence;

import com.exam.ehrlichpizzaexam.model.OrderDetail;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {

    @Query(value="SELECT od" +
            " FROM Order o INNER JOIN OrderDetail od ON od.order_id = o.order_id" +
            " WHERE o.date =:date")
    List<OrderDetail> getPopularByDate(@Param("date") LocalDate date);
}
