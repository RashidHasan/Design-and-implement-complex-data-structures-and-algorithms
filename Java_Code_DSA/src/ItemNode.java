public class ItemNode {
    protected Item value;
    protected ItemNode next;  //self comopsition
    protected ItemNode prev;

    public ItemNode(Item v){
        value = v;
        next = null;
        prev = null;
    }


}
