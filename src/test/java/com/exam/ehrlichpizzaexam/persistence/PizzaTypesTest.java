package com.exam.ehrlichpizzaexam.persistence;

import com.exam.ehrlichpizzaexam.model.PizzaTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PizzaTypesTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PizzaTypeRepository repository;

    @Test
    public void should_find_no_pizzaTypes_if_repository_is_empty() {
        Iterable pizzaTypes = repository.findAll();
        assertThat(pizzaTypes).isEmpty();
    }

    @Test
    public void should_store_a_pizzaType() {
        PizzaTypes pizzaTypes = repository.save(new PizzaTypes(1,"bbq_ckn","The Barbecue Chicken Pizza","Chicken","Barbecued Chicken, Red Peppers, Green Peppers, Tomatoes, Red Onions, Barbecue Sauce"));

        assertThat(pizzaTypes).hasFieldOrPropertyWithValue("pizzaType", "bbq_ckn");
        assertThat(pizzaTypes).hasFieldOrPropertyWithValue("name", "The Barbecue Chicken Pizza");
        assertThat(pizzaTypes).hasFieldOrPropertyWithValue("category", "Chicken");
        assertThat(pizzaTypes).hasFieldOrPropertyWithValue("ingredients", "Barbecued Chicken, Red Peppers, Green Peppers, Tomatoes, Red Onions, Barbecue Sauce");
    }

    @Test
    public void should_find_all_pizzaTypes() {
        PizzaTypes pizzaType1 = new PizzaTypes(1, "bbq_ckn1", "Barbecue Chicken1","Chicken","Barbecued Chicken, Red Peppers");
        entityManager.persist(pizzaType1);

        PizzaTypes pizzaType2 = new PizzaTypes(2, "bbq_ckn2", "Barbecue Chicken2","Chicken","Barbecued Chicken, Red Peppers");
        entityManager.persist(pizzaType2);

        PizzaTypes pizzaType3 = new PizzaTypes(3, "bbq_ckn3", "Barbecue Chicken3","Chicken","Barbecued Chicken, Red Peppers");
        entityManager.persist(pizzaType3);

        Iterable pizzaTypes = repository.findAll();

        assertThat(pizzaTypes).hasSize(3).contains("bbq_ckn1", "bbq_ckn2", "bbq_ckn3");
    }

    @Test
    public void should_find_pizzaType_by_id() { }

    @Test
    public void should_update_pizzaType_by_id() { }

    @Test
    public void should_delete_pizzaType_by_id() { }

    @Test
    public void should_delete_all_pizzaTypes() { }

}
