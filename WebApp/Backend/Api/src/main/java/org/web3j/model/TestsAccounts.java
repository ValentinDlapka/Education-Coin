package org.web3j.model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/hyperledger/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.12.1.
 */
@SuppressWarnings("rawtypes")
public class TestsAccounts extends Contract {
    public static final String BINARY = "610274610026600b82828239805160001a60731461001957fe5b30600052607381538281f3fe73000000000000000000000000000000000000000030146080604052600436106100355760003560e01c8063ce88b1451461003a575b600080fd5b6100576004803603602081101561005057600080fd5b5035610073565b604080516001600160a01b039092168252519081900360200190f35b600061007d61021f565b735b38da6a701c568545dcfcb03fcb875f56beddc4815273ab8483f64d9c6d1ecf9b849ae677dd3315835cb26020820152734b20993bc481177ec7e8f571cecae8a9e22c02db60408201527378731d3ca6b7e34ac0f824c42a7cc18a495cabab606082015273617f2e2fd72fd9d5503197092ac168c91465e7f260808201527317f6ad8ef982297579c203069c1dbffe4348c37260a0820152735c6b0f7bf3e7ce046039bd8fabdfd3f9f502167860c08201527303c6fced478cbbc9a4fab34ef9f40767739d1ff760e0820152731ae0ea34a72d944a8c7603ffb3ec30a6669e454c610100820152730a098eda01ce92ff4a4ccb7a4fffb5a43ebc70dc61012082015273ca35b7d915458ef540ade6068dfe2f44e8fa733c6101408201527314723a09acff6d2a60dcdf7aa4aff308fddc160c610160820152734b0897b0513fdc7c541b6d9d7e929c4e5364d2db61018082015273583031d1113ad414f02576bd6afabfb3021402256101a082015273dd870fa1b7c4700f2bd7f44238821c26f73921486101c08201528083600f811061021357fe5b60200201519392505050565b604051806101e00160405280600f90602082028036833750919291505056fea264697066735822122061fd273490da28be5825f96c265c9bddeb2d57c78407c37493f20898ef72f5f264736f6c63430007060033";

    private static String librariesLinkedBinary;

    public static final String FUNC_GETACCOUNT = "getAccount";

    @Deprecated
    protected TestsAccounts(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TestsAccounts(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TestsAccounts(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TestsAccounts(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> getAccount(BigInteger index) {
        final Function function = new Function(FUNC_GETACCOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static TestsAccounts load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new TestsAccounts(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TestsAccounts load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestsAccounts(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TestsAccounts load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new TestsAccounts(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TestsAccounts load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TestsAccounts(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TestsAccounts> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TestsAccounts.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<TestsAccounts> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TestsAccounts.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<TestsAccounts> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TestsAccounts.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<TestsAccounts> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TestsAccounts.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }
}
