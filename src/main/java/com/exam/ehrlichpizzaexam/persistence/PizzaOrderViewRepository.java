/**
 * This services provides database transactions for PizzaOrderView
 * via Jpa Repository
 *
 * @author  Christian Montifar
 * @version 1.0
 * @since   2022-12-02
 */
package com.exam.ehrlichpizzaexam.persistence;

import com.exam.ehrlichpizzaexam.model.Order;
import com.exam.ehrlichpizzaexam.model.OrderDetail;
import com.exam.ehrlichpizzaexam.model.PizzaOrdersView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PizzaOrderViewRepository extends JpaRepository<PizzaOrdersView,Long> {
    @Query(value="SELECT po FROM PizzaOrdersView po WHERE po.date =:date")
    List<PizzaOrdersView> getPopularByDate(@Param("date") LocalDate date);
}
