
package lp3.backend.domain;


import java.util.UUID;

public class FowardAgent extends User{

    public FowardAgent(UUID id, String username, String email, String type, String organization) {
        super(id, username, email, "FowardAgent", organization);
    }

}