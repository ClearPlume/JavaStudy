package top.fallenangel.springtransaction.service;

public interface IAccountService {
    void transfer(String outName, String inName, int amount);
}