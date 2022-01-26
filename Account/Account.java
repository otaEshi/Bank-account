package Account;

import Tools.Tools;

import java.util.ArrayList;
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
    private Tools tools;

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
        this.tools = new Tools();
    }

    public ArrayList GetTransactionHistory(){
        return transactionHistory;
    }

    public Tools GetTools(){
        return tools;
    }

    //set username
    public String SetUserName(String insertUserName){
        this.userName = insertUserName;
        return userName;
    }

    //get balance
    public double GetBalance(){
        return balance;
    }

    //Set balance
    public void SetBalance(double insertBalance){
        this.balance = insertBalance;
    }

    public void setBalance(double balance) {
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
    public void AddTransactionH() {
        transactionHistory.add(transactionContent);
    }

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
}
