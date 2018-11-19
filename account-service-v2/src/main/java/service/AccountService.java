
package service;

import domain.Account;
import domain.User;

public interface AccountService {

	String findByName(String accountName);

	Account create(User user);

	void saveChanges(String name, Account update);
}

