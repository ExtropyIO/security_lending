package sample;

import java.io.File;
import java.io.IOException;

import okhttp3.OkHttpClient;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.ipc.UnixIpcService;
import org.web3j.quorum.Quorum;
import org.web3j.quorum.UnixDomainSocketFactory;
import org.web3j.quorum.enclave.Enclave;
import org.web3j.quorum.enclave.Tessera;
import org.web3j.quorum.enclave.protocol.EnclaveService;

import org.web3j.tx.ClientTransactionManager;

import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

public class App {

  public static void main(String[] args) {
    // String walletAddress = "0x6b1d8562836aca8750a919271fccf9ea4a7165d2";

    Credentials credentials;
    try {
      credentials = WalletUtils.loadCredentials("", "network/network/3nodes-bash-raft-tess1/resources/key1/key");

      Web3j web3j = Web3j.build(new HttpService()); // defaults to http://localhost:8545/
      Web3ClientVersion web3ClientVersion;

      // web3ClientVersion = web3j.web3ClientVersion().send();

      // String clientVersion = web3ClientVersion.getWeb3ClientVersion();

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

      contract = Assets.deploy(quorum, credentials, contractGasProvider).send();

      // deploy(
      // quorum, transactionManager, 1, 1000000).send();

      System.out.println("Contract address:" + contract.getContractAddress());
      System.out.println(contract.getTransactionReceipt());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
// wallet addressed created via Epirus
//
