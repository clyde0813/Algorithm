import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int enrollCount = enroll.length;
        int[] answer = new int[enrollCount];
        Map<String, Node> dict = new HashMap<>();
        for(int i=0; i<enrollCount; i++){
            Node parentNode = referral[i].equals("-") ? null : dict.get(referral[i]);
            Node node = new Node(enroll[i], parentNode);
            dict.put(enroll[i], node);
        }
        for(int i=0; i<seller.length; i++){
            Node sellerNode = dict.get(seller[i]);
            int sellerProfit = amount[i] * 100;
            while(sellerNode != null){
                sellerNode.profit += sellerProfit - (int) (sellerProfit * 0.1);
                sellerProfit = (int) (sellerProfit * 0.1);
                sellerNode = sellerNode.parent;
            }
        }
        for(int i=0; i<enrollCount; i++){
            answer[i] = dict.get(enroll[i]).profit;
        }
        return answer;
    }
    
    static class Node {
        private String name;
        private Node parent;
        private int profit;
        public Node(String name, Node parent){
            this.name = name;
            this.parent = parent;
            this.profit = 0;
        }
    }
}