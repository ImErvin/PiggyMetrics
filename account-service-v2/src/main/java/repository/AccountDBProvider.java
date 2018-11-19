package repository;

import domain.Account;

public interface AccountDBProvider {

    Account findByName(String name);

}
