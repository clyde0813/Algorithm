import java.util.*;

class Solution {
    private static int n;
    
    public int[][] solution(int[][] nodeinfo) {
        this.n = nodeinfo.length;
        
        List<Node> nodeList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int[] node = nodeinfo[i];
            nodeList.add(new Node(node[0], node[1], i+1));
        }
        
        nodeList.sort((n1, n2) -> {
            if(n1.y==n2.y) return n1.x - n2.x;
            return n2.y - n1.y;
        });

        Node parent = nodeList.get(0);
        for(int i=1; i<n; i++) {
            buildTree(parent, nodeList.get(i));
        }

        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        preorder(parent, pre);
        postorder(parent, post);
        
        return new int[][]{pre.stream().mapToInt(i->i).toArray(), post.stream().mapToInt(i->i).toArray()};
    }
    
    private void buildTree(Node parent, Node child) {
        if(parent.x>child.x) {
            if(parent.left==null) parent.left = child;
            else buildTree(parent.left, child);
        }
        else {
            if(parent.right==null) parent.right = child;
            else buildTree(parent.right, child);
        }
    }
    
    private void preorder(Node node, List<Integer> list) {
    	list.add(node.idx);
        if(node.left!=null) preorder(node.left, list);
        if(node.right!=null) preorder(node.right, list);
    }
    
	private void postorder(Node node, List<Integer> list) {
        if(node.left!=null) postorder(node.left, list);
        if(node.right!=null) postorder(node.right, list);
        list.add(node.idx);
    }
    
    private static class Node {
        int x, y, idx;
        Node left, right;
        
        public Node (int x, int y, int idx) {
        	this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
}