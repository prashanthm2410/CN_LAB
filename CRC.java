import java.util.*;
public class CRC {
    public static String crc (String data, String poly, Boolean errChk){
        String rem=data;
        if(!errChk){
            for(int i =0;i<poly.length()-1;i++)
            {
                rem += "0";
            }
        }
        for(int i=0;i<rem.length()-poly.length()+1;i++){
            if (rem.charAt(i)=='1'){
                for(int j=0; j<poly.length();j++){
                    //rem[i+j] = (rem[i+j]==poly[j]) ? '0': '1';
                    rem=rem.substring(0,i+j)+(rem.charAt(i+j)==poly.charAt(j)? '0':'1')+rem.substring(i+j+1);
                }
            }
        }
        return rem.substring(rem.length()-poly.length()+1);  
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String poly = "10000100010001010";
        System.out.println("Enter Data to be sent:");
        String data = sc.nextLine();

        String rem = crc(data,poly,false);
        String codeword = data+rem;

        System.out.println("Remainder:"+rem);
        System.out.println("Codeword:"+codeword);

        System.out.println("Enter the recieved code word");
        String recv=sc.nextLine();

        String recvrem = crc(recv,poly,true);
        if(Integer.parseInt(recvrem)==0)
        {
            System.out.println("No Error");
        }
        else{
            System.out.println("Error Detected Please Discard");
        }
        sc.close();
    }
}
