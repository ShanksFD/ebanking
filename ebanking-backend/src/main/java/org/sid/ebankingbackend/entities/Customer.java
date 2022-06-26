package org.sid.ebankingbackend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "customer") // bidirectional relation -> already existing attribute in bankAccount named "customer" that uses relation ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // To ignore the list below
    private List<BankAccount> bankAccountList;
}
