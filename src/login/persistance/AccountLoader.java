package login.persistance;

import login.model.Account;

public interface AccountLoader {

    Account[] read();
    
}
