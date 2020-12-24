package sample;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.quorum.tx.QuorumTransactionManager;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>
 * Auto generated code.
 * <p>
 * <strong>Do not modify!</strong>
 * <p>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j
 * command line tools</a>, or the
 * org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen
 * module</a> to update.
 *
 * <p>
 * Generated with web3j version 4.6.4.
 */
@SuppressWarnings("rawtypes")
public class Assets extends Contract {
  public static final String BINARY = "608060405234801561001057600080fd5b506104d3806100206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c80632aedd0eb14610046578063b5651c1d146100fe578063ce72fb73146101a8575b600080fd5b6100ec6004803603602081101561005c57600080fd5b81019060208101813564010000000081111561007757600080fd5b82018360208201111561008957600080fd5b803590602001918460018302840111640100000000831117156100ab57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610256945050505050565b60408051918252519081900360200190f35b6101a66004803603604081101561011457600080fd5b81019060208101813564010000000081111561012f57600080fd5b82018360208201111561014157600080fd5b8035906020019184600183028401116401000000008311171561016357600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955050913592506102c0915050565b005b6101a6600480360360608110156101be57600080fd5b8101906020810181356401000000008111156101d957600080fd5b8201836020820111156101eb57600080fd5b8035906020019184600183028401116401000000008311171561020d57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505060ff833516935050506020013561032b565b600080826040518082805190602001908083835b602083106102895780518252601f19909201916020918201910161026a565b51815160209384036101000a6000190180199092169116179052920194855250604051938490030190922060020154949350505050565b806000836040518082805190602001908083835b602083106102f35780518252601f1990920191602091820191016102d4565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092206002019290925550505050565b604051806060016040528084815260200183600181111561034857fe5b8152602001828152506000846040518082805190602001908083835b602083106103835780518252601f199092019160209182019101610364565b51815160209384036101000a60001901801990921691161790529201948552506040519384900381019093208451805191946103c4945085935001906103fc565b50602082015160018083018054909160ff199091169083818111156103e557fe5b021790555060408201518160020155905050505050565b828054600181600116156101000203166002900490600052602060002090601f0160209004810192826104325760008555610478565b82601f1061044b57805160ff1916838001178555610478565b82800160010185558215610478579182015b8281111561047857825182559160200191906001019061045d565b50610484929150610488565b5090565b5b80821115610484576000815560010161048956fea264697066735822122057f420aea2a5584e063b2fafb5569e2a952c69e5a05c40602de10f9ceadda03a64736f6c63430007050033";

  public static final String FUNC_ADDASSET = "addAsset";

  public static final String FUNC_GETASSETPRICE = "getAssetPrice";

  public static final String FUNC_MARKASSET = "markAsset";

  @Deprecated
  protected Assets(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice,
      BigInteger gasLimit) {
    super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
  }

  protected Assets(String contractAddress, Web3j web3j, Credentials credentials,
      ContractGasProvider contractGasProvider) {
    super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
  }

  @Deprecated
  protected Assets(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice,
      BigInteger gasLimit) {
    super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
  }

  protected Assets(String contractAddress, Web3j web3j, TransactionManager transactionManager,
      ContractGasProvider contractGasProvider) {
    super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
  }

  public RemoteFunctionCall<TransactionReceipt> addAsset(String _ID, BigInteger _assetType, BigInteger _value) {
    final Function function = new Function(FUNC_ADDASSET,
        Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_ID),
            new org.web3j.abi.datatypes.generated.Uint8(_assetType),
            new org.web3j.abi.datatypes.generated.Uint256(_value)),
        Collections.<TypeReference<?>>emptyList());
    return executeRemoteCallTransaction(function);
  }

  public RemoteFunctionCall<BigInteger> getAssetPrice(String _ID) {
    final Function function = new Function(FUNC_GETASSETPRICE,
        Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_ID)),
        Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
        }));
    return executeRemoteCallSingleValueReturn(function, BigInteger.class);
  }

  public RemoteFunctionCall<TransactionReceipt> markAsset(String _ID, BigInteger _price) {
    final Function function = new Function(FUNC_MARKASSET,
        Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_ID),
            new org.web3j.abi.datatypes.generated.Uint256(_price)),
        Collections.<TypeReference<?>>emptyList());
    return executeRemoteCallTransaction(function);
  }

  @Deprecated
  public static Assets load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice,
      BigInteger gasLimit) {
    return new Assets(contractAddress, web3j, credentials, gasPrice, gasLimit);
  }

  @Deprecated
  public static Assets load(String contractAddress, Web3j web3j, TransactionManager transactionManager,
      BigInteger gasPrice, BigInteger gasLimit) {
    return new Assets(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
  }

  public static Assets load(String contractAddress, Web3j web3j, Credentials credentials,
      ContractGasProvider contractGasProvider) {
    return new Assets(contractAddress, web3j, credentials, contractGasProvider);
  }

  public static Assets load(String contractAddress, Web3j web3j, TransactionManager transactionManager,
      ContractGasProvider contractGasProvider) {
    return new Assets(contractAddress, web3j, transactionManager, contractGasProvider);
  }

  public static RemoteCall<Assets> deploy(Web3j web3j, Credentials credentials,
      ContractGasProvider contractGasProvider) {
    return deployRemoteCall(Assets.class, web3j, credentials, contractGasProvider, BINARY, "");
  }

  // @Deprecated
  // public static RemoteCall<Assets> deploy(Web3j web3j, QuorumTransactionManager transactionManager, int i,
  //     int j) {
  //   return deployRemoteCall(Assets.class, web3j, transactionManager, i, j, BINARY, "");
  // }

  // public static RemoteCall<Assets> deploy(Web3j web3j, TransactionManager transactionManager,
  //     ContractGasProvider contractGasProvider) {
  //   return deployRemoteCall(Assets.class, web3j, transactionManager, contractGasProvider, BINARY, "");
  // }

  // @Deprecated
  // public static RemoteCall<Assets> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice,
  //     BigInteger gasLimit) {
  //   return deployRemoteCall(Assets.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
  // }
}
