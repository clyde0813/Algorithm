import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[nodeinfo[0].length][nodeinfo.length];
        List<int[]> nodeList = new ArrayList<>(Arrays.asList(nodeinfo));
        Map<Integer, Integer> xIndexMap = new HashMap<>();
        Map<Integer, List<Integer>> xLevelMap = new HashMap<>();
        
        for(int i=0; i<nodeinfo.length; i++){
            xIndexMap.put(nodeinfo[i][0], i+1);
        }
        
        Collections.sort(nodeList, (o1, o2) -> o2[1] - o1[1]);
        
        for(int[] nodes : nodeList){
            xLevelMap.computeIfAbsent(nodes[1], o -> new ArrayList<>()).add(nodes[0]);
        }
        
        List<Integer> keySet = new ArrayList<>(xLevelMap.keySet());
        
        Collections.sort(keySet, Comparator.reverseOrder());
        
        Node node = new Node(nodeList.get(0)[0]);
        Node root = node;
        
        for(int i=1; i<keySet.size(); i++){
            Integer key = keySet.get(i);
            for(Integer v : xLevelMap.get(key)){
                node = root;
                while(true){
                    if(node.value<v&&node.right!=null){
                        node = node.right;
                    } 
                    else if(node.value<v&&node.right==null){
                        node.right = new Node(v);
                        break;
                    }
                    else if(node.value>v&&node.left!=null){
                        node = node.left;
                    }
                    else if(node.value>v&&node.left==null){
                        node.left = new Node(v);
                        break;
                    }
                }
            }
        }
        List<Integer> pre = preorder(root);
        List<Integer> post = postorder(root);
        
        for(int i=0; i<pre.size(); i++){
            answer[0][i] = xIndexMap.get(pre.get(i));
        }
        
        for(int i=0; i<post.size(); i++){
            answer[1][i] = xIndexMap.get(post.get(i));
        }
        
        return answer;
    }
    
    private List<Integer> preorder(Node node){
        List<Integer> order = new ArrayList<>();
        order.add(node.value);
        if(node.left!=null) order.addAll(preorder(node.left));
        if(node.right!=null) order.addAll(preorder(node.right));
        return order;
    }
    
    private List<Integer> postorder(Node node){
        List<Integer> order = new ArrayList<>();
        if(node.left!=null) order.addAll(postorder(node.left));
        if(node.right!=null) order.addAll(postorder(node.right));
        order.add(node.value);
        return order;
    }
    
    static class Node{
        public int value;
        public Node left;
        public Node right;
        
        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}