package com.comtrade.proxy.logovanje;

import java.io.IOException;

import com.comtrade.domen.User;

public interface IProxy {
	public void login(User user) throws ClassNotFoundException, IOException;
}
