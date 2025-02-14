package Entetys;

import Security.AES;
import jakarta.persistence.*;
import org.mindrot.jbcrypt.BCrypt;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String address;
    @Column
    private String privateKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrivateKey() {
        try {
            return AES.decrypt(this.privateKey);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setPrivateKey(String privateKey) {
        try {
            this.privateKey = AES.encrypt(privateKey);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
