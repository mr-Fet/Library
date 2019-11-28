package Services;

import com.sun.security.ntlm.Client;

import java.util.Map;

public interface ReturnAllClients {
    Map<Integer, Client> returnAllClients();
}
