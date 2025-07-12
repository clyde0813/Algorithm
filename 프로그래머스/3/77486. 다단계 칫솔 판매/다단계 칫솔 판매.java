import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Node> tree = buildTree(enroll, referral);
        calculateAmount(tree, seller, amount);
        
        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++) answer[i] = tree.get(enroll[i]).amount;
        
        return answer;
    }
    
    private Map<String, Node> buildTree(String[] enroll, String[] referral) {
        Map<String, Node> result = new HashMap<>();
        
        for(int i=0; i<enroll.length; i++) {
            if(referral[i].equals("-")) result.put(enroll[i], new Node(0, null));
            else result.put(enroll[i], new Node(0, result.get(referral[i])));
        }
                        
        return result;
    }
    
    private void calculateAmount(Map<String, Node> tree, String[] seller, int[] amount) {
        for(int i=0; i<seller.length; i++) {
            Node current = tree.get(seller[i]);
            int curAmount = amount[i] * 100;
            while(current!=null && curAmount!=0) {
                int commission = curAmount / 10;
                current.amount += curAmount - commission;
                curAmount = commission;
                current = current.parent;
            }
        }
    }
    
    private static class Node {
        int amount;
        Node parent;
        
        public Node(int amount, Node parent) {
            this.amount = amount;
            this.parent = parent;
        }
    }
}