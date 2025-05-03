class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int c1l = cards1.length;
        int c2l = cards2.length;
        int pt1 = 0;
        int pt2 = 0;
        for(String g : goal){
            if(pt1 < c1l && g.equals(cards1[pt1])) pt1++;
            else if(pt2 < c2l && g.equals(cards2[pt2])) pt2++;
            else return "No";
        }
        return "Yes";
    }
}