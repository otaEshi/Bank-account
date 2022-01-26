import Account.Account;
//import Tools.Tools;

import java.util.ArrayList;

public class Launcher {
    public static void main(String[] args){
        AccountList accountList = new AccountList();
        ArrayList<Account> list = accountList.CreateAccountList();
        Account account1 = new Account(Account.accountNumber,"Nam","123456","27/12/2333","0965481356","sadas","asdas",
                "021654",565);
//        System.out.println(account1.SetUserName("Hoang"));
        account1.GetTransactionHistory().add("Tài khoản 1 ăn cướp 20000000 đô của tài khoản 2");
        account1.GetTransactionHistory().add("tét 2");
        System.out.println(account1.GetTransactionHistory());
        System.out.println("check 12");
        System.out.println(account1.accountNumber);
        System.out.println("check 14");
        Account account2 = new Account(Account.accountNumber,"nguoi dung 2","3","ádas","21321513","dá","dá","ád",200);
        Account account3 = new Account(Account.accountNumber,"nguoi dung 3","2","ádas","21389713","dá","dá","ád",200);
        list.add(account1);
        list.add(account2);
        list.add(account3);
        System.out.println("check 24");
//        account1.SetUserName("Le Hoang Nam");
        System.out.println(account1.GetUserName());
        System.out.println("check 27");
        accountList.PasswordCheck(list,"0","1");
        System.out.println(accountList.GetCurrentIndex());
        System.out.println(accountList.PasswordCheck(list,"0965481356","123456"));
        System.out.println("check 32");
        int currentIndex = accountList.GetCurrentIndex();
        list.remove(currentIndex);
        System.out.println(list.get(0).GetPhoneNumber());
    }
}
