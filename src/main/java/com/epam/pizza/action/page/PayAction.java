package com.epam.pizza.action.page;

import com.epam.pizza.action.Action;
import com.epam.pizza.action.ActionResult;
import com.epam.pizza.dao.BankAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PayAction implements Action {

    private ActionResult result;

    public PayAction(String page) {
        result = new ActionResult(page);
    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Hi!!!!");
        BankAccount bankAccount = new BankAccount();
        bankAccount.setNumber(req.getParameter("number"));
        bankAccount.setTime(req.getParameter("time"));
        bankAccount.setCvv(req.getParameter("cvv"));

        BankAccount account = bankAccount.findBankAccountAccount(bankAccount);

        if (bankAccount.equals(account)) {
            System.out.println(account.getMoney().getAmount());
        }



        return result;
    }
}
