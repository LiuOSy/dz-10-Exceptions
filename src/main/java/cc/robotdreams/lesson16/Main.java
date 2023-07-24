package cc.robotdreams.lesson16;

import cc.robotdreams.lesson16.bank.BankApplication;
import cc.robotdreams.lesson16.exceptions.WrongAccountException;
import cc.robotdreams.lesson16.exceptions.WrongCurrencyException;
import cc.robotdreams.lesson16.exceptions.WrongOperationException;

public class Main
{
    // Поле BankApplication
    static private BankApplication testBankApplication = new BankApplication();

    // Метод processWrapper(String, int, String)
    static private void processWrapper(String accountId, int amount, String currency){
        try {
            testBankApplication.process(accountId, amount, currency);
        } catch (WrongAccountException e) {
            System.err.println(String.format("Aкаунт ID # %s не існує!",accountId));
        } catch (WrongCurrencyException e) {
            System.err.println(String.format("Введена валюта '%s' не співпадає з валютою акаунта!", currency));
        } catch (WrongOperationException e) {
            System.err.println("Акаунт не має достатньо коштів!");
        } catch (Exception e) {
            System.err.println("Сталася помилка при процесінгу, спробуйте ще раз");
        }
        finally {
            System.out.println("Дякуємо, що скористалися нашим сервісом");
        }
    }

    static public void main(String[] args){

        /*
            Викликати метод processWrapper з наступними параметрами:
            id = accountId000, amount 50, currency USD
            id = accountId003, amount 250, currency HRV
            id = accountId001, amount 50, currency EUR
            id = accountId001, amount 50, currency USD
            id = accountId001, amount 50, currency USD
         */

        Main.processWrapper("accountId000", 50, "USD");
        Main.processWrapper("accountId003",  550, "HRV");
        Main.processWrapper("accountId001",  50, "EUR");
        Main.processWrapper("accountId001",  50, "USD");
        Main.processWrapper("accountId001",  50, "USD");
    }



}
