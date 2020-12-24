package Web3App.src.main.java.epirus;

// package sample;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import okhttp3.OkHttpClient;
import org.web3j.*;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.ipc.UnixIpcService;
import org.web3j.quorum.*;
import org.web3j.quorum.Quorum;
import org.web3j.quorum.enclave.Enclave;
import org.web3j.quorum.enclave.Tessera;
import org.web3j.quorum.enclave.protocol.EnclaveService;
import org.web3j.quorum.tx.QuorumTransactionManager;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import io.epirus.generated.contracts.*;

public class Web3App {

  public static void main(String[] args) {

    String contractAddress = "0x1D0F5B7d26366787dab8E594A5a95BEcd0b82f04";
    // contract address obtained from Ganache
    String publicKey = "0x430C969FcE880194B4053463E4B334F216fe6030";
    String privateKey = "27376f740eae233c7b39bdcb566c361e5022c897420a5cda5d79cc2573481911";
    // priv key obtained from accounts[0]

    // public static void main(String[] args) {
    String walletAddress = "af3b3261b3c718473bae81cd9c473a673cee7a03";
    // Generated from Epirus

    Credentials credentials;
    try {
      credentials = WalletUtils.loadCredentials("", "network/network/3nodes-bash-raft-tess1/resources/key1/key");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (CipherException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    Web3j web3j = Web3j.build(new HttpService()); // defaults to http://localhost:8545/
    Web3ClientVersion web3ClientVersion;
    try {
      web3ClientVersion = web3j.web3ClientVersion().send();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    String clientVersion = web3ClientVersion.getWeb3ClientVersion();

    // connect to quorum node via http or ipc as described above
    Quorum quorum = Quorum.build(new UnixIpcService("network/network/3nodes-bash-raft-tess1/qdata/dd1/geth.ipc"));

    // build http client that supports ipc connection
    UnixDomainSocketFactory socketFactory = new UnixDomainSocketFactory(new File("TESSERA_IPC_PATH"));
    OkHttpClient client = new OkHttpClient.Builder().socketFactory(socketFactory).build();

    EnclaveService enclaveService = new EnclaveService("http://localhost", 1981, client);
    Enclave enclave = new Tessera(enclaveService, quorum);

    // QuorumTransactionManager qrtxm = new QuorumTransactionManager(
    // quorum, credentials, TM_FROM_KEY, Arrays.asList(TM_TO_KEY_ARRAY),
    // enclave,
    // 30, // Retry times
    // 2000); // Sleep

    // Quorum quorum = Quorum.build(new
    // UnixIpcService("network/network/3nodes-bash-raft-tess1/qdata/dd1/geth.ipc"));
    // // path to ipc socket file

    ClientTransactionManager transactionManager = new ClientTransactionManager(web3j,
        "0x6b1d8562836aca8750a919271fccf9ea4a7165d2", 20, 1000);
    // // address generated from Epirus

    // class QuorumTransactionManager(
    // val web3j: Quorum,

    ContractGasProvider contractGasProvider = new DefaultGasProvider();

    Assets contract;
    try {
      contract = Assets.deploy(quorum, credentials, contractGasProvider).send();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // deploy(
    // quorum, transactionManager, 1, 1000000).send();

    System.out.println("Contract address:" + contract.getContractAddress());
    System.out.println(contract.getTransactionReceipt());
  }
}
// }

// }
