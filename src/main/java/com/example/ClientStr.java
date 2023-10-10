package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientStr{
    String nomeServer = "localhost";
    int portaServer = 3000;
    Socket mioSocket;
    BufferedReader tastiera;
    String stringUtente;
    String stringRIcevutaDalServer;
    DataOutputStream outVersoServer;
    BufferedReader inDalServer;

    public Socket connetti(){
        try {
            tastiera = new BufferedReader(new InputStreamReader(System.in));

            mioSocket = new Socket(nomeServer,portaServer);

            outVersoServer = new DataOutputStream(mioSocket.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));


        } catch (Exception e) {
            System.out.println("errore di connesione");
        }


        return mioSocket;
    }

   
        public void comunica(){
            try{
                System.out.println("inserisci la stringa da trasmettere al server:");
                stringUtente = tastiera.readLine();
                System.out.println("invio la stringa al server e attendo");
                outVersoServer.writeBytes(stringUtente + '\n');
                stringRIcevutaDalServer = inDalServer.readLine();
                System.out.println("risposta dal server " + '\n' + stringRIcevutaDalServer);
                System.out.println("client: termina elaborazione e chiude connessione");
                mioSocket.close();

            } catch(Exception e){
                System.out.println("perro");
            }    
        } 
    
}