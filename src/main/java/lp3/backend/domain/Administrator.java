
 package lp3.backend.domain;

 import jakarta.persistence.Entity;

 import java.util.UUID;


 public class Administrator extends User{

     public Administrator(UUID id, String username, String email, String type, String organization) {
         super(id, username, email, "Administrator", organization);
     }
 }

