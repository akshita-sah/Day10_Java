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

    /* To create a hash map using a linked list, we use string as the key and frquency as its value.
    We check if head = null we assign the new node else we traverse the list and add value after that.
     */
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

    int findFrequency(String word)
    {
        MyMapNode temp = head;
        while(temp!=null)
        {
            if(temp.key.equals(word))
                return temp.value;
            temp = temp.next;
        }
        return -1;
    }

    void removeWord(String word)
    {
        MyMapNode temp = head;
        MyMapNode prev = null;
        while(temp!=null)
        {
            if(temp.key.equals(word)){
                if(prev == null)
                {
                    head = temp.next;
                }
                else {
                    prev.next = temp.next;
                }
                break;
            }
            prev = temp;
            temp = temp.next;
        }

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
