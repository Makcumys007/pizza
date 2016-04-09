package com.epam.pizza.action.page;

import com.epam.pizza.action.Action;
import com.epam.pizza.action.ActionResult;
import com.epam.pizza.connection.PizzaConnection;
import com.epam.pizza.dao.BankDAO;
import com.epam.pizza.entity.BankAccount;
import com.epam.pizza.entity.Order;
import org.joda.money.Money;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PayAction implements Action {

    private ActionResult result;
    public PayAction(String page) {
        result = new ActionResult(page);
    }


    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        Order order = (Order) req.getSession(false).getAttribute("order");
        BankDAO bankDAO = new BankDAO();
        BankAccount bankAccount = new BankAccount();
        bankAccount.setNumber(req.getParameter("number"));
        bankAccount.setTime(req.getParameter("time"));
        bankAccount.setCvv(req.getParameter("cvv"));

        BankAccount userAccount = bankDAO.findBankAccountAccount(bankAccount);

        BankAccount pizzaAccount = new BankAccount();
        pizzaAccount.setNumber("8888888888888888");
        pizzaAccount.setTime("0820");
        pizzaAccount.setCvv("888");

        pizzaAccount = bankDAO.findBankAccountAccount(pizzaAccount);


        if (userAccount.getMoney().getAmount().compareTo(order.getPrice().getAmount()) > 0) {
           bankDAO.transaction(userAccount, pizzaAccount, order);
        }
        bankDAO.close();



        return result;
    }
}
