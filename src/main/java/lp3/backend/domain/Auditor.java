
package lp3.backend.domain;


import java.util.UUID;

public class Auditor extends User{

    public Auditor(UUID id, String username, String email, String type, String organization) {
        super(id, username, email, "Auditor", organization);
    }

}

