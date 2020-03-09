import java.util.Random;

public class drawcards 
{
	//=====================================================================================//
    public static String[] deck() 
    {
        String[] deckofcards=new String[52];
        String[] suits={"Hearts","Diamonds","Spades","Clubs"};
        String[] ranks={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        //--------------------------------------------------------------//
        for (int i = 0; i <52 ; i++) 
        {
        	//--------------------------------------------------------------//
            if(i<13)
            {
                deckofcards[i]=ranks[i]+" of "+suits[0];
            }
            //--------------------------------------------------------------//
            else if(i>=13 && i<26)
            {
                deckofcards[i]=ranks[i-13]+" of "+suits[1];
            }
            //--------------------------------------------------------------//
            else if(i>=26 && i<39)
            {
                deckofcards[i]=ranks[i-26]+" of "+suits[2];
            }
            //--------------------------------------------------------------//
            else if(i>=39)
            {
                deckofcards[i]=ranks[i-39]+" of "+suits[3];
            }
            //--------------------------------------------------------------//
        }
        return deckofcards;
    }
	//=====================================================================================//    
    public static String[] choose_cards(int n) 
    {
        String[] newdeck=deck();
        String[] hand=new String[n];
        Random random = new Random();
        //--------------------------------------------------------------//
        for (int i = 0; i < n; i++) 
        {
            hand[i]=newdeck[random.nextInt(52)];
        }
        return hand;   
    }
	//=====================================================================================//    
    public static String[] draw_cards(int n) 
    {
        //--------------------------------------------------------------//
        String[] shuffle=deck();
        Random random = new Random();
        
        for (int i = 0; i < shuffle.length; i++) 
        {
            int index1=random.nextInt(52);
            int index2=random.nextInt(52);
            String temp="";
            temp=shuffle[index1];
            shuffle[index1]=shuffle[index2];
            shuffle[index2]=temp;
        }
        //--------------------------------------------------------------//        
        String[] drawncards=new String[n];
        for (int i = 0; i < drawncards.length; i++) 
        {
            drawncards[i]=shuffle[i];
        }
        return drawncards;
    }
	//=====================================================================================//    
    public static int[] suit_count(String[] hand) 
    {
        int spades=0;
        int hearts=0;
        int diamonds=0;
        int clubs=0;
        //--------------------------------------------------------------//
        for (int i = 0; i < hand.length; i++) 
        {
            //--------------------------------------------------------------//
            if(hand[i].contains("Hearts"))
            {
                hearts+=1;
            }
            //--------------------------------------------------------------//
            else if(hand[i].contains("Spades"))
            {
                spades+=1;
            }
            //--------------------------------------------------------------//
            else if(hand[i].contains("Clubs"))
            {
                clubs+=1;
            }
            //--------------------------------------------------------------//
            else if(hand[i].contains("Diamonds"))
            {
                diamonds+=1;
            }
            //--------------------------------------------------------------//
        }
        int[] stats={spades,hearts,diamonds,clubs};
        return stats;
    }
	//=====================================================================================//
    public static void main(String[] args) 
    {
        //--------------------------------------------------------------//
    	System.out.println("==========================================");
    	System.out.println("Choosing 12 cards with replacement: ");
        String[] choose=choose_cards(12);
        int[] count_rep=suit_count(choose);
        
        for (int i = 0; i < choose.length; i++) 
        {
            System.out.println(choose[i]);
        }
        //--------------------------------------------------------------//
        System.out.println("==========================================");
        System.out.println("Counting the respective deck's suit: ");
        
        for (int i = 0; i < count_rep.length; i++) 
        {
            System.out.println(count_rep[i]);
        }
        //--------------------------------------------------------------//
        System.out.println("==========================================");
        System.out.println("Choosing 12 cards without replacement: ");
        String[] draw=draw_cards(12);
        int[] count_no_rep=suit_count(draw);
        
        for (int i = 0; i < draw.length; i++) 
        {
            System.out.println(draw[i]);
        }
        //--------------------------------------------------------------//
        System.out.println("==========================================");
        System.out.println("Counting the respective deck's suit: ");
        
        for (int i = 0; i < count_no_rep.length; i++) 
        {
            System.out.println(count_no_rep[i]);
        }
        //--------------------------------------------------------------//
        System.out.println("==========================================");
    }
	//=====================================================================================//
}
