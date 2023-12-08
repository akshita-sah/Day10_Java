class MyMapNode{
    String key;
    int value;
    MyMapNode next;
    MyMapNode(String s)
    {
        key = s;
        value = 1;
        next = null;
    }
}
public class LinkedHashMap {
    MyMapNode head;
    void addNode(String word)
    {
        if(head == null)
        {
            MyMapNode newNode = new MyMapNode(word);
            head = newNode;
            return;
        }
        MyMapNode temp = head;
        while(temp.next!=null)
        {
            if(temp.key.equals(word))
            {
                temp.value++;
                return;
            }
            temp=temp.next;
        }
        if(temp.key.equals(word))
        {
            temp.value++;
            return;
        }
        MyMapNode newNode = new MyMapNode(word);
        temp.next = newNode;
    }
    
    void display()
    {
        System.out.println("The elements of the hash map are: ");
        MyMapNode temp = head;
        while(temp!=null)
        {
            System.out.println(temp.key+" "+temp.value);
            temp = temp.next;
        }
    }
    public static void main(String[] args)
    {
        LinkedHashMap wordMap = new LinkedHashMap();
        String str = "To be or not to be";
        String s = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves " +
                "deliberately into paranoid avoidable situations";
        s = s.toLowerCase();
        String words[] = s.split(" ");
        for(String word:words)
        {
            wordMap.addNode(word);
        }
        wordMap.display();
        int frequency = wordMap.findFrequency("paranoid");
        if(frequency == -1)
            System.out.println("The word does not exist");
        else
            System.out.println("The frequency of the word is: "+frequency);
        wordMap.removeWord("avoidable");
        wordMap.display();
    }
}
