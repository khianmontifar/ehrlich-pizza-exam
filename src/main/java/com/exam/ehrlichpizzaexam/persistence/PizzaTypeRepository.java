/**
 * This services provides database transactions for PizzaType
 * via Jpa Repository
 *
 * @author  Christian Montifar
 * @version 1.0
 * @since   2022-12-02
 */
package com.exam.ehrlichpizzaexam.persistence;

import com.exam.ehrlichpizzaexam.model.PizzaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaTypeRepository extends JpaRepository<PizzaType,Long> {
}
