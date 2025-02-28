package web3J;

import Entities.User;
import Entities.Wallet;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.ipc.IpcService;

import java.nio.file.Paths;

public class BlockchainCommunication {
    private String ipcPath = "placeholder";
    IpcService ipcService = new IpcService(Paths.get(ipcPath).isAbsolute());
    Web3j web3j = Web3j.build(ipcService);

    public void createNewWallet(User user) {
        try {
            // Generiere ein neues Keypair
            ECKeyPair keyPair = Keys.createEcKeyPair();

            // Erstelle Adresse und Private Key
            String address = "0x" + Keys.getAddress(keyPair);
            String privateKey = keyPair.getPrivateKey().toString(16); // Hexadezimales Format

            Wallet wallet = new Wallet(address, privateKey);
            user.setWallet(wallet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
