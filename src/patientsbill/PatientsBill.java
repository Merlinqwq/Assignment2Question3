
package patientsbill;
import java.io.*;
/**
 *
 * @author Merlin
 */
public class PatientsBill {

  
    public static void main(String[] args) throws IOException{
        String strin;
        int TotalBill=0;
        int RoomBill=0;
        int NurseBill=0;
        int TVBill=0;
        int PhoneBill=0;
        final int RoomPriceI=395;
        final int RoomPriceD=310;
        final int RoomPriceP=350;
        final int NursePriceS=250;
        final int NursePriceN=275;
        final int TVPrice=40;
        final int PhonePrice=15;
        File data=new File("data.txt");
        File outcome=new File("outcome.txt");
        BufferedReader BR=new BufferedReader(new FileReader("data.txt"));
        FileWriter FW=new FileWriter("outcome.txt");
        PrintWriter PW=new PrintWriter(FW);
        strin=BR.readLine();
        PW.println("PatientID   Days   Room   Nurse   TV   Phone    Bill");
        while(strin!=null){
            String[] tokens=strin.split("[ ]+");
            int patientID=Integer.parseInt(tokens[0]);
            char RoomType=tokens[1].charAt(0);
            int Days=Integer.parseInt(tokens[2]);
            char Nurse=tokens[3].charAt(0);
            char TV=tokens[4].charAt(0);
            char Phone=tokens[4].charAt(0);
            if(RoomType=='I'){
                RoomBill=Days*RoomPriceI;
                PhoneBill=0;
                TVBill=0;
                if(Nurse=='S'){ NurseBill=Days*NursePriceS; }
                else if(Nurse=='N'){NurseBill=Days*NursePriceN;}
                else if(Nurse=='X'){NurseBill=0;}
            }
            else{
                if(RoomType=='P'){RoomBill=Days*RoomPriceP;}
                else{RoomBill=Days*RoomPriceD;}
                NurseBill=0;
                if(Phone=='T'){PhoneBill=Days*PhonePrice;}
                else{PhoneBill=0;}
                if(TV=='V'){TVBill=Days*TVPrice;}
                else{TVBill=0;}
            }
            TotalBill=RoomBill+NurseBill+TVBill+PhoneBill;
            strin=BR.readLine();
            PW.printf("%d\t    %d\t   %d\t  %d\t  %d\t%d\t%d\n",patientID,Days,RoomBill,NurseBill,TVBill,PhoneBill,TotalBill);
        }
        PW.close();
        System.out.println("check outcome in the outcome file");
    }
    
}
