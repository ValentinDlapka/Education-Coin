package web3J;

import Entities.User;
import Entities.Wallet;
import Repo.WalletRepo;

import at.contracts.EduCoin;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.ipc.IpcService;
import org.web3j.tx.FastRawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import java.math.BigInteger;
import java.nio.file.Paths;

@ApplicationScoped
public class BlockchainCommunication {
    private static final String CONTRACT_ADDRESS = "0xf63bcc9e8Faab989302a4267e4fAAEd329c00A6b";
    private static final BigInteger GAS_PRICE = BigInteger.valueOf(20_000_000_000L);
    private static final BigInteger GAS_LIMIT = BigInteger.valueOf(4_700_000);



    private String ipcPath = "\\\\.\\pipe\\geth.ipc";
    IpcService ipcService = new IpcService(Paths.get(ipcPath).isAbsolute());
    Web3j web3j = Web3j.build(ipcService);

    @Inject
    WalletRepo walletRepo;

    private final EduCoin contract;

    public BlockchainCommunication() {
        Credentials credentials = Credentials.create("28ba40636770dfa81003bb0e76724c3f91b5ef86fc9681cd492e7693cca0deac","69b0E7D732F97ac2617b25b6393eDBcBAbfE2a4e");
        ContractGasProvider gasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);
        contract = EduCoin.load(CONTRACT_ADDRESS,web3j,credentials,gasProvider);
    }

    public void createNewWallet(User user) {
        try {
            // Generiere ein neues Keypair
            ECKeyPair keyPair = Keys.createEcKeyPair();

            // Erstelle Adresse und Private Key
            String address = "0x" + Keys.getAddress(keyPair);
            String privateKey = keyPair.getPrivateKey().toString(16); // Hexadezimales Format

            Wallet wallet = new Wallet(address, privateKey);
            walletRepo.add(wallet);
            user.setWallet(wallet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BigInteger getBalance(String address) throws Exception {
        return contract.balanceOf(address).send();
    }

    public TransactionReceipt distributeTokens(String student, BigInteger amount, String testName, String grade) throws Exception {
        return contract.distributeTokens(student, amount, testName, grade).send();
    }

    public TransactionReceipt redeemTokens(BigInteger amount,String studentWallet) throws Exception {
        System.out.println(contract.getContractAddress());
        return contract.redeemTokens(studentWallet,amount).send();
    }

    public TransactionReceipt mintTokens(BigInteger amount) throws Exception {
        return contract.mint(amount).send();
    }

    public String getIpcPath() {
        return ipcPath;
    }

    public void setIpcPath(String ipcPath) {
        this.ipcPath = ipcPath;
    }

    public EduCoin getContract() {
        return contract;
    }

    public IpcService getIpcService() {
        return ipcService;
    }

    public void setIpcService(IpcService ipcService) {
        this.ipcService = ipcService;
    }

    public Web3j getWeb3j() {
        return web3j;
    }

    public void setWeb3j(Web3j web3j) {
        this.web3j = web3j;
    }

    public WalletRepo getWalletRepo() {
        return walletRepo;
    }

    public void setWalletRepo(WalletRepo walletRepo) {
        this.walletRepo = walletRepo;
    }
}
