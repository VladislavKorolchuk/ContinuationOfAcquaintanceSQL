package ru.sql.continuationofacquaintancesql.service;

import org.springframework.stereotype.Service;
import ru.sql.continuationofacquaintancesql.entity.Expense;
import ru.sql.continuationofacquaintancesql.entity.ExpenseByCategories;
import ru.sql.continuationofacquaintancesql.repositories.ExpenseRepository;

import java.util.Collection;
import java.util.List;

@Service
public class ExpenseService {

    ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public void deleteExpense(Integer id) {
        expenseRepository.deleteById(id);
    }

    public List<ExpenseByCategories> getExpensesByCategory() {
        return expenseRepository.getExpensesByCategory();
    }

}
