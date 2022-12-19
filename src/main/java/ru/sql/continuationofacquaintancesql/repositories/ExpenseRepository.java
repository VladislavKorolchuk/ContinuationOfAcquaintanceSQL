package ru.sql.continuationofacquaintancesql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.sql.continuationofacquaintancesql.entity.Expense;
import ru.sql.continuationofacquaintancesql.entity.ExpenseByCategories;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    @Query (value ="SELECT  category, SUM(amount) as amount FROM  expenses GROUP BY category", nativeQuery = true)
    List<ExpenseByCategories> getExpensesByCategory();
}
