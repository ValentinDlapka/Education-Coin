package web3J;

import Entetys.User;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.ipc.IpcService;

import java.nio.file.Paths;

public class BlockchainCommunication {
    private String ipcPath = "placeholder";
    IpcService ipcService = new IpcService(Paths.get(ipcPath).isAbsolute());
    Web3j web3j = Web3j.build(ipcService);

    public void createNewWallet(User user) {

    }
}
