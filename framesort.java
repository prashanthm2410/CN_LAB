import java.util.*;
class Frame{
    int sqno,data;
    Frame(int sqno, int data)
    {
        this.sqno=sqno;
        this.data=data;
    }
}
public class framesort {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter the size of the data");
        Scanner sc = new Scanner(System.in);
        int total=sc.nextInt();
        System.out.println("Enter the size of each data packet");
        int size=sc.nextInt();
        n=total/size;

        List <Integer> seqList = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            seqList.add(i);
        }

        List<Frame> frames= new ArrayList<>();
        for(int seqno : seqList)
        {   
            System.out.println("Enter the data for frame "+seqno);
            int data = sc.nextInt();
            frames.add(new Frame(seqno,data));
        }
        Collections.shuffle(frames);

        System.out.println("Frames before shuffelling");
        for (Frame frame : frames)
        {
            System.out.println("Frame "+frame.sqno+":"+frame.data+"\n");
        }

        
        Collections.sort(frames,(f1,f2)->Integer.compare(f1.sqno,f2.sqno));

        System.out.println("After Sorting");
        for(Frame frame:frames){
            System.out.println("Frame "+frame.sqno+":"+frame.data+"\n");
        }
        sc.close();
    }
}
