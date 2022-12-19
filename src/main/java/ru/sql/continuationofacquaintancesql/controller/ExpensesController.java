package ru.sql.continuationofacquaintancesql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sql.continuationofacquaintancesql.entity.Expense;
import ru.sql.continuationofacquaintancesql.entity.ExpenseByCategories;
import ru.sql.continuationofacquaintancesql.service.ExpenseService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    ExpenseService expenseService;

    public ExpensesController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpense() {
        List<Expense> expenses =  expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    @PostMapping
    public ResponseEntity<Void> creatyExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delateExpense(@PathVariable("id") Integer id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/expenseByCategories")
    public ResponseEntity<List<ExpenseByCategories>> getExpenseByCategories() {
        List<ExpenseByCategories> expenseByCategories =  expenseService.getExpensesByCategory();
        return ResponseEntity.ok(expenseByCategories);
    }

}
