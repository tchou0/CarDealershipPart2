package org.example.contract;

import java.io.BufferedWriter;
import java.io.FileWriter;


public class ContractFileManager {
    

//============ creating saleContract ===================
public void saveContract(Contract contract){
    

    String filename = "Contract.csv";
    try(
        BufferedWriter bufWriter = new BufferedWriter(new FileWriter(filename, true))){
            
            bufWriter.write(contract.saleString() + "\n");

            bufWriter.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

}


}
