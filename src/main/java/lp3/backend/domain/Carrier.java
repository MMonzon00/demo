
package lp3.backend.domain;


import java.util.UUID;

public class Carrier extends User{

    public Carrier(UUID id, String username, String email, String type, String organization) {
        super(id, username, email, "Carrier", organization);
    }

}
