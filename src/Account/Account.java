package Account;

//import Tools.Tools;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Account {
    private String userName;                 //Tên chủ tài khoản
    private String password;                 //Mật khẩu
    private String dateOfBirth;              //Ngày sinh (ngày/tháng/năm)
    private String phoneNumber;              //số điện thoại
    private String address;                  //Địa chỉ
    private String email;                    //email
    private String cccd;                     //Căn cước công dân (tạo điều kiện nhập cccd là 12 số trong khi làm gui
    private ArrayList transactionHistory;    //Lịch sử giao dịch
    private String transactionContent;       //Nội dung giao dịch
    private double balance;                  //Số dư trong tài khoản
//    private Tools tools;

    //Biến dùng để đổi thông tin
    public String insertNewCCCD;
    public String insertNewUserName;
    public String insertNewEmail;
    public String insertNewAddress;
    public String insertNewPassword;        //Mật khẩu mới
    public String insertPassword;           //Xác nhận lại mật khẩu cũ
    public String insertNewDateOfBirth;

    static Random generator = new Random();
    public static int accountNumber = generator.nextInt((999999999 - 100000000) + 1) + 100000000;      //check trùng số tk

    public Account(int accountNumber, String userName, String password, String dateOfBirth, String phoneNumber, String address, String email, String cccd, double balance) {
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.cccd = cccd;
//        if (transactionHistory == null) {
//            this.transactionHistory = new ArrayList();   //add dữ liệu vào khi thực hiện các giao dịch
//        } else {
//            this.transactionHistory = transactionHistory;
//        }
        this.transactionHistory = new ArrayList();
        this.balance = balance;
        this.accountNumber1 = accountNumber;
//        this.tools = new Tools();
    }

    public ArrayList GetTransactionHistory(){
        return transactionHistory;
    }

//    public Tools GetTools(){
//        return tools;
//    }

    //set username
    public String SetUserName(String insertUserName){
        this.userName = insertUserName;
        return userName;
    }

    //get balance
    public double GetBalance(){
        return balance;
    }

    public void SetBalance(double balance) {
        this.balance = balance;
    }

    //get số tài khoản
    public int GetAccountNumber() {
        return accountNumber;
    }

    //get số điện thoại
    public String GetPhoneNumber() {
        return phoneNumber;
    }

    //get mật khẩu
    public String GetPassword() {
        return password;
    }

    //get tên chủ tài khoản
    public String GetUserName() {
        return userName;
    }

    //Tạo list lịch sử giao dịch (Khi tạo tài khoản)
    public ArrayList CreateTransHistory() {
        ArrayList<String> transactionHistory = new ArrayList();
        return transactionHistory;
    }

    //Thêm lịch sử giao dịch (Khi thực hiện giao dịch)
//    public void AddTransactionH() {
//        transactionHistory.add(transactionContent);
//    }

    //Đổi mật khẩu, nhập mật khẩu cũ và mật khẩu mới (Yêu cầu người dùng
    public String ChangePassword(String password, String insertPassword, String insertNewPassword) {       //password: mật khẩu lúc đầu của tài khoản
        if (password == insertPassword) {                                                                 //insertPassword: mật khẩu cần người dùng nhập vào để xác nhận
            password = insertNewPassword;                                                                 //newPassword: mật khẩu mới
        } else {
            System.out.println("Vui lòng nhập đúng mật khẩu cũ");
        }
        return password;
    }

    //get ngày sinh
    public String GetDateOfBirth(){
        return dateOfBirth;
    }

    //set ngày sinh
    public void ChangeDateOfBirth(String insertNewDateOfBirth) {
        this.dateOfBirth=insertNewDateOfBirth;
    }

    //set căn cước công dân
    public void ChangeCCCD(String insertNewCCCD) {
        this.cccd = insertNewCCCD;
    }

    //get cccd
    public String GetCCCC(){
        return cccd;
    }

    //get address
    public String GetAddress(){
        return address;
    }

    //set adress
    public void ChangeAddress(String insertNewAddress) {
        this.address = insertNewAddress;
    }

    //get email
    public String GetEmail(){
        return email;
    }

    //Set email
    public void ChangeEmail(String insertNewEmail) {
        this.email = insertNewEmail;
    }

    //Thiện
    public int accountNumber1;
    private  Saving saving;
    private Loan loan;

    public Saving GetSaving(){
        return saving;
    }

    public void SetSaving(Saving saving){
        this.saving = saving;
    }

    public Loan GetLoan() {
        return loan;
    }

    public void SetLoan(Loan loan) {
        this.loan = loan;
    }

    public int getAccountNumber1() {
        return accountNumber1;
    }

    public void setAccountNumber1(int accountNumber1) {
        this.accountNumber1 = accountNumber1;
    }

    public String inputMoney(double numbersOf, int accountNumber) throws ParseException {
        String s= "Account: "+accountNumber+" đã được nạp: "+numbersOf+" vnd vào lúc: "+convertLongToDate();
        SetBalance(balance+numbersOf);
        transactionHistory.add(s);
        return s;
    }

    public String convertLongToDate() throws ParseException {
        long longtime = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        Date date = new Date(longtime);
        return date+"";
    }

    public String withdrawal(double numbersOf, int accountNumber) throws ParseException {
        if(numbersOf>balance){
            return "Số dư không đủ để thực hiện giao dịch";
        }
        String s= "Account: "+accountNumber+" đã rút: "+numbersOf+" vnd vào lúc: "+convertLongToDate();
        SetBalance(balance-numbersOf);
        transactionHistory.add(s);
        return s;
    }

    public String transfer(double numbersOf, Account accountFrom, Account accountTo) throws ParseException {
        if(numbersOf>balance){
            return "Số dư không đủ để thực hiện giao dịch";
        }
        String s= "Account: "+accountFrom.getAccountNumber1()+" đã chuyển: "+numbersOf+" vnd vào lúc: "+convertLongToDate()+" "+
                "tới tài khoản: "+accountTo.getAccountNumber1();
        SetBalance(balance-numbersOf);
        accountTo.SetBalance(accountTo.GetBalance()+numbersOf);
        transactionHistory.add(s);
        String s2= "Account: "+accountTo.getAccountNumber1()+" đã nhận: "+numbersOf+" vnd vào lúc: "+convertLongToDate()+" "+
                "từ tài khoản: "+accountFrom.getAccountNumber1();
        accountTo.GetTransactionHistory().add(s2);
        return s;
    }

    public String saveMoney(Saving saving) throws ParseException {
        if(saving.getMoney()>balance){
            return "Số dư không đủ để thực hiện giao dịch";
        }
        if(saving.getTime()<1 || saving.getPercent()<0 || saving.getId()<0){
            return "Sổ tiết kiệm không khả thi";
        }
        SetBalance(balance-saving.getMoney());
        SetSaving(saving);
        double interest= (saving.getMoney()*saving.getPercent()/36000)*saving.getTime()*30;
        String s= "Account: "+accountNumber+" đã gửi tiết kiệm: "+saving.getMoney()+" vnd vào lúc: "+convertLongToDate()+
                " lãi suất: "+saving.getPercent()+"%"+" với kỳ hạn: "+saving.getTime()+". Số tiền lãi sau kỳ hạn: "+interest+"vnđ";
        transactionHistory.add(s);
        return s;
    }

    public String bankLoan(Loan loan) throws ParseException {
        if(loan.getMonth()<1 || loan.getPercent()<0 || loan.getId()<0){
            return "Sổ tiết kiệm không khả thi";
        }
        SetBalance(balance+loan.getMoney());
        SetLoan(loan);
        double interest = (loan.getMoney()*loan.getPercent()/36000)*loan.getMonth()*30;
        String s= "Account: "+accountNumber+" đã vay: "+loan.getMoney()+" vnd vào lúc: "+convertLongToDate()+
                " lãi suất: "+loan.getPercent()+"%"+" với kỳ hạn: "+loan.getMonth()+". Số tiền lãi phải trả sau kỳ hạn: "+interest+"vnđ";
        transactionHistory.add(s);
        return s;
    }

}

