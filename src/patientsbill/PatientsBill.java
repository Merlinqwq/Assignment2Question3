
package patientsbill;
import java.io.*;
/**
 *
 * @author Merlin
 */
public class PatientsBill {

  
    public static void main(String[] args) throws IOException{
        String strin;
        File data=new File("data.txt");
        File outcome=new File("outcome.txt");
        BufferedReader BR=new BufferedReader(new FileReader("data.txt"));
        FileWriter FW=new FileWriter("outcome.txt");
        PrintWriter PW=new PrintWriter(FW);
        strin=BR.readLine();
        PW.print("PatientID   Days   Room   Nurse   TV   Phone    Bill");
        while(strin!=null){
            String[] tokens=strin.split("[ ]+");
            int patientID=Integer.parseInt(tokens[0]);
            char RoomType=tokens[1].charAt(0);
            int Days=Integer.parseInt(tokens[2]);
            char Nurse=tokens[3].charAt(0);
            char TVandPhone=tokens[4].charAt(0);
            int TotalBill=0;
            int RoomBill=0;
            int NurseBill=0;
            int TVBill=0;
            int PhoneBill=0;
            if(RoomType=='I'){RoomBill=Days*395;}
            if(RoomType=='D'){RoomBill=Days*310;}
            if(RoomType=='P'){RoomBill=Days*350;}
            if(Nurse=='X'){NurseBill=0;}
            if(Nurse=='S'){NurseBill=Days*250;}
            if(Nurse=='N'){NurseBill=Days*275;}
            if(TVandPhone=='V'){TVBill=Days*40;
            PhoneBill=0;}
            if(TVandPhone=='T'){PhoneBill=Days*15;
            TVBill=0;}
            if(TVandPhone=='X'){TVBill=0;
            PhoneBill=0;}
            TotalBill=RoomBill+NurseBill+TVBill+PhoneBill;
            strin=BR.readLine();
            PW.printf("%d\t    %d\t   %d\t  %d\t  %d\t%d\t%d",patientID,Days,RoomBill,NurseBill,TVBill,PhoneBill,TotalBill);
        }
        PW.close();
        System.out.println("check outcome in the outcome file");
    }
    
}
