import java.util.*;

class Solution {
    static class Node{
        public int x, y, idx;
        public Node left, right;
        
        public Node(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        
        for(int i=0; i<nodeinfo.length; i++){
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
        }
        
        Arrays.sort(nodes, (o1, o2) -> o2.y - o1.y);
        
        Node root = nodes[0];
        
        for(int i=1; i<nodes.length; i++){
            insertNode(root, nodes[i]);
        }
        
        return new int[][]{
            preorder(root).stream().mapToInt(i -> i).toArray(),
            postorder(root).stream().mapToInt(i -> i).toArray()
        };
    }
    
    private void insertNode(Node parent, Node child){
        if(parent.x > child.x){
            if(parent.left==null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if(parent.right==null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
    
    private List<Integer> preorder(Node node){
        List<Integer> order = new ArrayList<>();
        order.add(node.idx);
        if(node.left!=null) order.addAll(preorder(node.left));
        if(node.right!=null) order.addAll(preorder(node.right));
        return order;
    }
    
    private List<Integer> postorder(Node node){
        List<Integer> order = new ArrayList<>();
        if(node.left!=null) order.addAll(postorder(node.left));
        if(node.right!=null) order.addAll(postorder(node.right));
        order.add(node.idx);
        return order;
    }
}