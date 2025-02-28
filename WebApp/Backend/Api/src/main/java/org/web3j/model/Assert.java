package org.web3j.model;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
public class Assert extends Contract {
    public static final String BINARY = "61231d610026600b82828239805160001a60731461001957fe5b30600052607381538281f3fe73000000000000000000000000000000000000000030146080604052600436106101415760003560e01c806377c6d463116100c2578063aea8895211610086578063aea8895214610d70578063b8f2853114610e2d578063bfba5dd614610ef7578063e8c2cb1614610fc1578063ea79dd791461117c578063f5bae6b61461123957610141565b806377c6d463146109bf5780638c45cb9714610a7c5780639c0b433614610b39578063a079f1a314610bf6578063abcd796014610cb357610141565b806349f979391161010957806349f979391461050c5780634e3e4035146106c7578063556fe56214610784578063561015e214610841578063767392b3146108fe57610141565b80630897e4c71461014657806318211bfb1461021757806339df137f146102d457806344781a001461038e57806344b7f2481461044f575b600080fd5b81801561015257600080fd5b506102036004803603606081101561016957600080fd5b813591602081013591810190606081016040820135600160201b81111561018f57600080fd5b8201836020820111156101a157600080fd5b803590602001918460018302840111600160201b831117156101c257600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506112f6945050505050565b604080519115158252519081900360200190f35b81801561022357600080fd5b506102036004803603606081101561023a57600080fd5b813591602081013591810190606081016040820135600160201b81111561026057600080fd5b82018360208201111561027257600080fd5b803590602001918460018302840111600160201b8311171561029357600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506113ea945050505050565b8180156102e057600080fd5b50610203600480360360408110156102f757600080fd5b813515159190810190604081016020820135600160201b81111561031a57600080fd5b82018360208201111561032c57600080fd5b803590602001918460018302840111600160201b8311171561034d57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506114dd945050505050565b81801561039a57600080fd5b50610203600480360360608110156103b157600080fd5b81351515916020810135151591810190606081016040820135600160201b8111156103db57600080fd5b8201836020820111156103ed57600080fd5b803590602001918460018302840111600160201b8311171561040e57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506115a5945050505050565b81801561045b57600080fd5b506102036004803603606081101561047257600080fd5b813591602081013591810190606081016040820135600160201b81111561049857600080fd5b8201836020820111156104aa57600080fd5b803590602001918460018302840111600160201b831117156104cb57600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955061168f945050505050565b81801561051857600080fd5b506102036004803603606081101561052f57600080fd5b810190602081018135600160201b81111561054957600080fd5b82018360208201111561055b57600080fd5b803590602001918460018302840111600160201b8311171561057c57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b8111156105ce57600080fd5b8201836020820111156105e057600080fd5b803590602001918460018302840111600160201b8311171561060157600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561065357600080fd5b82018360208201111561066557600080fd5b803590602001918460018302840111600160201b8311171561068657600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506116fd945050505050565b8180156106d357600080fd5b50610203600480360360608110156106ea57600080fd5b813591602081013591810190606081016040820135600160201b81111561071057600080fd5b82018360208201111561072257600080fd5b803590602001918460018302840111600160201b8311171561074357600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955061197e945050505050565b81801561079057600080fd5b50610203600480360360608110156107a757600080fd5b813591602081013591810190606081016040820135600160201b8111156107cd57600080fd5b8201836020820111156107df57600080fd5b803590602001918460018302840111600160201b8311171561080057600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506119ed945050505050565b81801561084d57600080fd5b506102036004803603606081101561086457600080fd5b813591602081013591810190606081016040820135600160201b81111561088a57600080fd5b82018360208201111561089c57600080fd5b803590602001918460018302840111600160201b831117156108bd57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611a6e945050505050565b81801561090a57600080fd5b506102036004803603606081101561092157600080fd5b81351515916020810135151591810190606081016040820135600160201b81111561094b57600080fd5b82018360208201111561095d57600080fd5b803590602001918460018302840111600160201b8311171561097e57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611add945050505050565b8180156109cb57600080fd5b50610203600480360360608110156109e257600080fd5b813591602081013591810190606081016040820135600160201b811115610a0857600080fd5b820183602082011115610a1a57600080fd5b803590602001918460018302840111600160201b83111715610a3b57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611bc3945050505050565b818015610a8857600080fd5b5061020360048036036060811015610a9f57600080fd5b813591602081013591810190606081016040820135600160201b811115610ac557600080fd5b820183602082011115610ad757600080fd5b803590602001918460018302840111600160201b83111715610af857600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611c53945050505050565b818015610b4557600080fd5b5061020360048036036060811015610b5c57600080fd5b813591602081013591810190606081016040820135600160201b811115610b8257600080fd5b820183602082011115610b9457600080fd5b803590602001918460018302840111600160201b83111715610bb557600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611ce3945050505050565b818015610c0257600080fd5b5061020360048036036060811015610c1957600080fd5b813591602081013591810190606081016040820135600160201b811115610c3f57600080fd5b820183602082011115610c5157600080fd5b803590602001918460018302840111600160201b83111715610c7257600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611d51945050505050565b818015610cbf57600080fd5b5061020360048036036060811015610cd657600080fd5b813591602081013591810190606081016040820135600160201b811115610cfc57600080fd5b820183602082011115610d0e57600080fd5b803590602001918460018302840111600160201b83111715610d2f57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611dbf945050505050565b818015610d7c57600080fd5b5061020360048036036060811015610d9357600080fd5b813591602081013591810190606081016040820135600160201b811115610db957600080fd5b820183602082011115610dcb57600080fd5b803590602001918460018302840111600160201b83111715610dec57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611e2d945050505050565b818015610e3957600080fd5b5061020360048036036060811015610e5057600080fd5b6001600160a01b038235811692602081013590911691810190606081016040820135600160201b811115610e8357600080fd5b820183602082011115610e9557600080fd5b803590602001918460018302840111600160201b83111715610eb657600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611e9b945050505050565b818015610f0357600080fd5b5061020360048036036060811015610f1a57600080fd5b6001600160a01b038235811692602081013590911691810190606081016040820135600160201b811115610f4d57600080fd5b820183602082011115610f5f57600080fd5b803590602001918460018302840111600160201b83111715610f8057600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611f40945050505050565b818015610fcd57600080fd5b5061020360048036036060811015610fe457600080fd5b810190602081018135600160201b811115610ffe57600080fd5b82018360208201111561101057600080fd5b803590602001918460018302840111600160201b8311171561103157600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561108357600080fd5b82018360208201111561109557600080fd5b803590602001918460018302840111600160201b831117156110b657600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561110857600080fd5b82018360208201111561111a57600080fd5b803590602001918460018302840111600160201b8311171561113b57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611fe4945050505050565b81801561118857600080fd5b506102036004803603606081101561119f57600080fd5b813591602081013591810190606081016040820135600160201b8111156111c557600080fd5b8201836020820111156111d757600080fd5b803590602001918460018302840111600160201b831117156111f857600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506121b9945050505050565b81801561124557600080fd5b506102036004803603606081101561125c57600080fd5b813591602081013591810190606081016040820135600160201b81111561128257600080fd5b82018360208201111561129457600080fd5b803590602001918460018302840111600160201b831117156112b557600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550612239945050505050565b6000808412156113085750600061130d565b508183115b7f1aee88e0b11c6f778ee0be69b5a108735a20e3d68f5729c851f81e10fb0357e2818386866040518085151581526020018060200180602001858152602001848152602001838103835286818151815260200191508051906020019080838360005b8381101561138757818101518382015260200161136f565b50505050905090810190601f1680156113b45780820380516001836020036101000a031916815260200191505b50928303905250600b81526a33b932b0ba32b92a3430b760a91b6020820152604080519182900301945092505050a19392505050565b6000808312156113fc57506000611401565b508183105b7f14bc841bf51d20c0dc7caa87b92cc8ffff7a0427ab3f16c1800f89f1cd14afe8818386866040518085151581526020018060200180602001858152602001848152602001838103835286818151815260200191508051906020019080838360005b8381101561147b578181015183820152602001611463565b50505050905090810190601f1680156114a85780820380516001836020036101000a031916815260200191505b50928303905250600a8152693632b9b9b2b92a3430b760b11b6020820152604080519182900301945092505050a19392505050565b60008290507fbbf85d637d70ccacc5b8edb602351ba3dec7bc069d69235c3529ef3f453d01f181836040518083151581526020018060200180602001838103835284818151815260200191508051906020019080838360005b8381101561154e578181015183820152602001611536565b50505050905090810190601f16801561157b5780820380516001836020036101000a031916815260200191505b5092830390525060028152616f6b60f01b602082015260408051918290030192509050a192915050565b6000821515841515141590507ff7b49aa0711ceec1ded951e7e1e0f5068e1b494431e8aafd4afd3c5fce1bcea581838686604051808515158152602001806020018060200185151581526020018415158152602001838103835286818151815260200191508051906020019080838360005b8381101561162f578181015183820152602001611617565b50505050905090810190601f16801561165c5780820380516001836020036101000a031916815260200191505b5092830390525060088152671b9bdd115c5d585b60c21b6020820152604080519182900301945092505050a19392505050565b600082841290506000805160206122a8833981519152818386866040518085151581526020018060200180602001858152602001848152602001838103835286818151815260200191508051906020019080838360008381101561147b578181015183820152602001611463565b6000826040516020018082805190602001908083835b602083106117325780518252601f199092019160209182019101611713565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405160208183030381529060405280519060200120846040516020018082805190602001908083835b602083106117a05780518252601f199092019160209182019101611781565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405160208183030381529060405280519060200120141590507f772eb34cc47d8c18199f27c5bfdb20838544f0058ef8afdd2debec5f6edb455f8183868660405180851515815260200180602001806020018060200180602001858103855288818151815260200191508051906020019080838360005b8381101561185557818101518382015260200161183d565b50505050905090810190601f1680156118825780820380516001836020036101000a031916815260200191505b5085810384526008815260200180671b9bdd115c5d585b60c21b815250602001858103835287818151815260200191508051906020019080838360005b838110156118d75781810151838201526020016118bf565b50505050905090810190601f1680156119045780820380516001836020036101000a031916815260200191505b50858103825286518152865160209182019188019080838360005b8381101561193757818101518382015260200161191f565b50505050905090810190601f1680156119645780820380516001836020036101000a031916815260200191505b509850505050505050505060405180910390a19392505050565b60008284141590506000805160206122a8833981519152818386866040518085151581526020018060200180602001858152602001848152602001838103835286818151815260200191508051906020019080838360008381101561162f578181015183820152602001611617565b60008284141590507f80ccaff7f7d9b95ab49ddd43778ee01cfda842a6269bed42e4e37929bc57fd28818386866040518085151581526020018060200180602001858152602001848152602001838103835286818151815260200191508051906020019080838360008381101561162f578181015183820152602001611617565b60008284141590506000805160206122c8833981519152818386866040518085151581526020018060200180602001858152602001848152602001838103835286818151815260200191508051906020019080838360008381101561162f578181015183820152602001611617565b60008215158415151490507ff7b49aa0711ceec1ded951e7e1e0f5068e1b494431e8aafd4afd3c5fce1bcea581838686604051808515158152602001806020018060200185151581526020018415158152602001838103835286818151815260200191508051906020019080838360005b83811015611b66578181015183820152602001611b4e565b50505050905090810190601f168015611b935780820380516001836020036101000a031916815260200191505b509283039052506005815264195c5d585b60da1b6020820152604080519182900301945092505050a19392505050565b600080841215611bd557506001611bda565b508183105b7f1aee88e0b11c6f778ee0be69b5a108735a20e3d68f5729c851f81e10fb0357e2818386866040518085151581526020018060200180602001858152602001848152602001838103835286818151815260200191508051906020019080838360008381101561147b578181015183820152602001611463565b600080831215611c6557506001611c6a565b508183115b7f14bc841bf51d20c0dc7caa87b92cc8ffff7a0427ab3f16c1800f89f1cd14afe8818386866040518085151581526020018060200180602001858152602001848152602001838103835286818151815260200191508051906020019080838360008381101561138757818101518382015260200161136f565b600082841390506000805160206122a8833981519152818386866040518085151581526020018060200180602001858152602001848152602001838103835286818151815260200191508051906020019080838360008381101561138757818101518382015260200161136f565b600082841190506000805160206122c8833981519152818386866040518085151581526020018060200180602001858152602001848152602001838103835286818151815260200191508051906020019080838360008381101561138757818101518382015260200161136f565b600082841490506000805160206122c88339815191528183868660405180851515815260200180602001806020018581526020018481526020018381038352868181518152602001915080519060200190808383600083811015611b66578181015183820152602001611b4e565b600082841090506000805160206122c8833981519152818386866040518085151581526020018060200180602001858152602001848152602001838103835286818151815260200191508051906020019080838360008381101561147b578181015183820152602001611463565b6000826001600160a01b0316846001600160a01b0316141590507fac36fadfa7a97083276a489f3e00cb5d4fcd13bbfdb3a78a0014fd48d4b46d9b818386866040518085151581526020018060200180602001856001600160a01b03168152602001846001600160a01b03168152602001838103835286818151815260200191508051906020019080838360008381101561162f578181015183820152602001611617565b6000826001600160a01b0316846001600160a01b03161490507fac36fadfa7a97083276a489f3e00cb5d4fcd13bbfdb3a78a0014fd48d4b46d9b818386866040518085151581526020018060200180602001856001600160a01b03168152602001846001600160a01b031681526020018381038352868181518152602001915080519060200190808383600083811015611b66578181015183820152602001611b4e565b6000826040516020018082805190602001908083835b602083106120195780518252601f199092019160209182019101611ffa565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405160208183030381529060405280519060200120846040516020018082805190602001908083835b602083106120875780518252601f199092019160209182019101612068565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051602081830303815290604052805190602001201490507f772eb34cc47d8c18199f27c5bfdb20838544f0058ef8afdd2debec5f6edb455f8183868660405180851515815260200180602001806020018060200180602001858103855288818151815260200191508051906020019080838360005b8381101561213b578181015183820152602001612123565b50505050905090810190601f1680156121685780820380516001836020036101000a031916815260200191505b508581038452600581526020018064195c5d585b60da1b81525060200185810383528781815181526020019150805190602001908083836000838110156118d75781810151838201526020016118bf565b600082841490507f80ccaff7f7d9b95ab49ddd43778ee01cfda842a6269bed42e4e37929bc57fd288183868660405180851515815260200180602001806020018581526020018481526020018381038352868181518152602001915080519060200190808383600083811015611b66578181015183820152602001611b4e565b600082841490506000805160206122a88339815191528183868660405180851515815260200180602001806020018581526020018481526020018381038352868181518152602001915080519060200190808383600083811015611b66578181015183820152602001611b4e56fe06c5fd13661d229189d43a6a38e86721af51ed7065a4b6f43da4bd8cd1b18151968b7a5d7c5bcc2e8f9f583456a62c310b1b4e509906c1c1bb1a5aff86cc1e1aa26469706673582212209858cf8ceb3aa5e6a05028f793ac144aaf9b2aa086616cf34191a47fac21bba264736f6c63430007060033";

    private static String librariesLinkedBinary;

    public static final Event ASSERTIONEVENT_EVENT = new Event("AssertionEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event ASSERTIONEVENTADDRESS_EVENT = new Event("AssertionEventAddress", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event ASSERTIONEVENTBOOL_EVENT = new Event("AssertionEventBool", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}));
    ;

    public static final Event ASSERTIONEVENTBYTES32_EVENT = new Event("AssertionEventBytes32", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
    ;

    public static final Event ASSERTIONEVENTINT_EVENT = new Event("AssertionEventInt", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}));
    ;

    public static final Event ASSERTIONEVENTINTUINT_EVENT = new Event("AssertionEventIntUint", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event ASSERTIONEVENTSTRING_EVENT = new Event("AssertionEventString", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event ASSERTIONEVENTUINT_EVENT = new Event("AssertionEventUint", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event ASSERTIONEVENTUINTINT_EVENT = new Event("AssertionEventUintInt", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Int256>() {}));
    ;

    @Deprecated
    protected Assert(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Assert(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Assert(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Assert(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<AssertionEventEventResponse> getAssertionEventEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ASSERTIONEVENT_EVENT, transactionReceipt);
        ArrayList<AssertionEventEventResponse> responses = new ArrayList<AssertionEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AssertionEventEventResponse typedResponse = new AssertionEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static AssertionEventEventResponse getAssertionEventEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ASSERTIONEVENT_EVENT, log);
        AssertionEventEventResponse typedResponse = new AssertionEventEventResponse();
        typedResponse.log = log;
        typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<AssertionEventEventResponse> assertionEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getAssertionEventEventFromLog(log));
    }

    public Flowable<AssertionEventEventResponse> assertionEventEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ASSERTIONEVENT_EVENT));
        return assertionEventEventFlowable(filter);
    }

    public static List<AssertionEventAddressEventResponse> getAssertionEventAddressEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ASSERTIONEVENTADDRESS_EVENT, transactionReceipt);
        ArrayList<AssertionEventAddressEventResponse> responses = new ArrayList<AssertionEventAddressEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AssertionEventAddressEventResponse typedResponse = new AssertionEventAddressEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.returned = (String) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.expected = (String) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static AssertionEventAddressEventResponse getAssertionEventAddressEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ASSERTIONEVENTADDRESS_EVENT, log);
        AssertionEventAddressEventResponse typedResponse = new AssertionEventAddressEventResponse();
        typedResponse.log = log;
        typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.returned = (String) eventValues.getNonIndexedValues().get(3).getValue();
        typedResponse.expected = (String) eventValues.getNonIndexedValues().get(4).getValue();
        return typedResponse;
    }

    public Flowable<AssertionEventAddressEventResponse> assertionEventAddressEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getAssertionEventAddressEventFromLog(log));
    }

    public Flowable<AssertionEventAddressEventResponse> assertionEventAddressEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ASSERTIONEVENTADDRESS_EVENT));
        return assertionEventAddressEventFlowable(filter);
    }

    public static List<AssertionEventBoolEventResponse> getAssertionEventBoolEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ASSERTIONEVENTBOOL_EVENT, transactionReceipt);
        ArrayList<AssertionEventBoolEventResponse> responses = new ArrayList<AssertionEventBoolEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AssertionEventBoolEventResponse typedResponse = new AssertionEventBoolEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.returned = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.expected = (Boolean) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static AssertionEventBoolEventResponse getAssertionEventBoolEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ASSERTIONEVENTBOOL_EVENT, log);
        AssertionEventBoolEventResponse typedResponse = new AssertionEventBoolEventResponse();
        typedResponse.log = log;
        typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.returned = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
        typedResponse.expected = (Boolean) eventValues.getNonIndexedValues().get(4).getValue();
        return typedResponse;
    }

    public Flowable<AssertionEventBoolEventResponse> assertionEventBoolEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getAssertionEventBoolEventFromLog(log));
    }

    public Flowable<AssertionEventBoolEventResponse> assertionEventBoolEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ASSERTIONEVENTBOOL_EVENT));
        return assertionEventBoolEventFlowable(filter);
    }

    public static List<AssertionEventBytes32EventResponse> getAssertionEventBytes32Events(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ASSERTIONEVENTBYTES32_EVENT, transactionReceipt);
        ArrayList<AssertionEventBytes32EventResponse> responses = new ArrayList<AssertionEventBytes32EventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AssertionEventBytes32EventResponse typedResponse = new AssertionEventBytes32EventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.returned = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.expected = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static AssertionEventBytes32EventResponse getAssertionEventBytes32EventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ASSERTIONEVENTBYTES32_EVENT, log);
        AssertionEventBytes32EventResponse typedResponse = new AssertionEventBytes32EventResponse();
        typedResponse.log = log;
        typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.returned = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
        typedResponse.expected = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
        return typedResponse;
    }

    public Flowable<AssertionEventBytes32EventResponse> assertionEventBytes32EventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getAssertionEventBytes32EventFromLog(log));
    }

    public Flowable<AssertionEventBytes32EventResponse> assertionEventBytes32EventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ASSERTIONEVENTBYTES32_EVENT));
        return assertionEventBytes32EventFlowable(filter);
    }

    public static List<AssertionEventIntEventResponse> getAssertionEventIntEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ASSERTIONEVENTINT_EVENT, transactionReceipt);
        ArrayList<AssertionEventIntEventResponse> responses = new ArrayList<AssertionEventIntEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AssertionEventIntEventResponse typedResponse = new AssertionEventIntEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.returned = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.expected = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static AssertionEventIntEventResponse getAssertionEventIntEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ASSERTIONEVENTINT_EVENT, log);
        AssertionEventIntEventResponse typedResponse = new AssertionEventIntEventResponse();
        typedResponse.log = log;
        typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.returned = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
        typedResponse.expected = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
        return typedResponse;
    }

    public Flowable<AssertionEventIntEventResponse> assertionEventIntEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getAssertionEventIntEventFromLog(log));
    }

    public Flowable<AssertionEventIntEventResponse> assertionEventIntEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ASSERTIONEVENTINT_EVENT));
        return assertionEventIntEventFlowable(filter);
    }

    public static List<AssertionEventIntUintEventResponse> getAssertionEventIntUintEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ASSERTIONEVENTINTUINT_EVENT, transactionReceipt);
        ArrayList<AssertionEventIntUintEventResponse> responses = new ArrayList<AssertionEventIntUintEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AssertionEventIntUintEventResponse typedResponse = new AssertionEventIntUintEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.returned = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.expected = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static AssertionEventIntUintEventResponse getAssertionEventIntUintEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ASSERTIONEVENTINTUINT_EVENT, log);
        AssertionEventIntUintEventResponse typedResponse = new AssertionEventIntUintEventResponse();
        typedResponse.log = log;
        typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.returned = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
        typedResponse.expected = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
        return typedResponse;
    }

    public Flowable<AssertionEventIntUintEventResponse> assertionEventIntUintEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getAssertionEventIntUintEventFromLog(log));
    }

    public Flowable<AssertionEventIntUintEventResponse> assertionEventIntUintEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ASSERTIONEVENTINTUINT_EVENT));
        return assertionEventIntUintEventFlowable(filter);
    }

    public static List<AssertionEventStringEventResponse> getAssertionEventStringEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ASSERTIONEVENTSTRING_EVENT, transactionReceipt);
        ArrayList<AssertionEventStringEventResponse> responses = new ArrayList<AssertionEventStringEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AssertionEventStringEventResponse typedResponse = new AssertionEventStringEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.returned = (String) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.expected = (String) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static AssertionEventStringEventResponse getAssertionEventStringEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ASSERTIONEVENTSTRING_EVENT, log);
        AssertionEventStringEventResponse typedResponse = new AssertionEventStringEventResponse();
        typedResponse.log = log;
        typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.returned = (String) eventValues.getNonIndexedValues().get(3).getValue();
        typedResponse.expected = (String) eventValues.getNonIndexedValues().get(4).getValue();
        return typedResponse;
    }

    public Flowable<AssertionEventStringEventResponse> assertionEventStringEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getAssertionEventStringEventFromLog(log));
    }

    public Flowable<AssertionEventStringEventResponse> assertionEventStringEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ASSERTIONEVENTSTRING_EVENT));
        return assertionEventStringEventFlowable(filter);
    }

    public static List<AssertionEventUintEventResponse> getAssertionEventUintEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ASSERTIONEVENTUINT_EVENT, transactionReceipt);
        ArrayList<AssertionEventUintEventResponse> responses = new ArrayList<AssertionEventUintEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AssertionEventUintEventResponse typedResponse = new AssertionEventUintEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.returned = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.expected = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static AssertionEventUintEventResponse getAssertionEventUintEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ASSERTIONEVENTUINT_EVENT, log);
        AssertionEventUintEventResponse typedResponse = new AssertionEventUintEventResponse();
        typedResponse.log = log;
        typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.returned = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
        typedResponse.expected = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
        return typedResponse;
    }

    public Flowable<AssertionEventUintEventResponse> assertionEventUintEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getAssertionEventUintEventFromLog(log));
    }

    public Flowable<AssertionEventUintEventResponse> assertionEventUintEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ASSERTIONEVENTUINT_EVENT));
        return assertionEventUintEventFlowable(filter);
    }

    public static List<AssertionEventUintIntEventResponse> getAssertionEventUintIntEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ASSERTIONEVENTUINTINT_EVENT, transactionReceipt);
        ArrayList<AssertionEventUintIntEventResponse> responses = new ArrayList<AssertionEventUintIntEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AssertionEventUintIntEventResponse typedResponse = new AssertionEventUintIntEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.returned = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.expected = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static AssertionEventUintIntEventResponse getAssertionEventUintIntEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ASSERTIONEVENTUINTINT_EVENT, log);
        AssertionEventUintIntEventResponse typedResponse = new AssertionEventUintIntEventResponse();
        typedResponse.log = log;
        typedResponse.passed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.methodName = (String) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.returned = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
        typedResponse.expected = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
        return typedResponse;
    }

    public Flowable<AssertionEventUintIntEventResponse> assertionEventUintIntEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getAssertionEventUintIntEventFromLog(log));
    }

    public Flowable<AssertionEventUintIntEventResponse> assertionEventUintIntEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ASSERTIONEVENTUINTINT_EVENT));
        return assertionEventUintIntEventFlowable(filter);
    }

    @Deprecated
    public static Assert load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new Assert(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Assert load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Assert(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Assert load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new Assert(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Assert load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Assert(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Assert> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Assert.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Assert> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Assert.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<Assert> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Assert.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Assert> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Assert.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
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

    public static class AssertionEventEventResponse extends BaseEventResponse {
        public Boolean passed;

        public String message;

        public String methodName;
    }

    public static class AssertionEventAddressEventResponse extends BaseEventResponse {
        public Boolean passed;

        public String message;

        public String methodName;

        public String returned;

        public String expected;
    }

    public static class AssertionEventBoolEventResponse extends BaseEventResponse {
        public Boolean passed;

        public String message;

        public String methodName;

        public Boolean returned;

        public Boolean expected;
    }

    public static class AssertionEventBytes32EventResponse extends BaseEventResponse {
        public Boolean passed;

        public String message;

        public String methodName;

        public byte[] returned;

        public byte[] expected;
    }

    public static class AssertionEventIntEventResponse extends BaseEventResponse {
        public Boolean passed;

        public String message;

        public String methodName;

        public BigInteger returned;

        public BigInteger expected;
    }

    public static class AssertionEventIntUintEventResponse extends BaseEventResponse {
        public Boolean passed;

        public String message;

        public String methodName;

        public BigInteger returned;

        public BigInteger expected;
    }

    public static class AssertionEventStringEventResponse extends BaseEventResponse {
        public Boolean passed;

        public String message;

        public String methodName;

        public String returned;

        public String expected;
    }

    public static class AssertionEventUintEventResponse extends BaseEventResponse {
        public Boolean passed;

        public String message;

        public String methodName;

        public BigInteger returned;

        public BigInteger expected;
    }

    public static class AssertionEventUintIntEventResponse extends BaseEventResponse {
        public Boolean passed;

        public String message;

        public String methodName;

        public BigInteger returned;

        public BigInteger expected;
    }
}
