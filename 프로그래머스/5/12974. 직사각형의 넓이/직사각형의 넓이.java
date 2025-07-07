import java.util.*;

public class Solution {
    static class Event implements Comparable<Event> {
        int x, y1, y2, type;
        
        Event(int x, int y1, int y2, int type) {
            this.x = x; this.y1 = y1; this.y2 = y2; this.type = type;
        }
        
        public int compareTo(Event o) {
            return Integer.compare(this.x, o.x);
        }
    }
    
    static class SegTree {
        int n;
        int[] count;
        long[] length;
        int[] ys;
        
        SegTree(int size, int[] ys) {
            this.n = size;
            this.count = new int[4*size];
            this.length = new long[4*size];
            this.ys = ys;
        }
        
        void update(int node, int l, int r, int ql, int qr, int val) {
            if (qr < l || r < ql) return;
            
            if (ql <= l && r <= qr) {
                count[node] += val;
            } else {
                int mid = (l + r) >> 1;
                update(node*2, l, mid, ql, qr, val);
                update(node*2+1, mid+1, r, ql, qr, val);
            }
            
            if (count[node] > 0) {
                length[node] = ys[r+1] - ys[l];
            } else if (l == r) {
                length[node] = 0;
            } else {
                length[node] = length[node*2] + length[node*2+1];
            }
        }
    }

    public long solution(int[][] rectangles) {
        int n = rectangles.length;
        Event[] events = new Event[2*n];
        int[] yVals = new int[2*n];
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            int x1 = rectangles[i][0], y1 = rectangles[i][1];
            int x2 = rectangles[i][2], y2 = rectangles[i][3];
            
            events[idx]   = new Event(x1, y1, y2, +1);
            events[idx+1] = new Event(x2, y1, y2, -1);
            yVals[idx]   = y1;
            yVals[idx+1] = y2;
            
            idx += 2;
        }
        
        Arrays.sort(events);
        Arrays.sort(yVals);
        
        int m = 0;
        for (int i = 0; i < yVals.length; i++) {
            if (i == 0 || yVals[i] != yVals[i-1]) {
                yVals[m++] = yVals[i];
            }
        }
        
        int[] ys = Arrays.copyOf(yVals, m);
        SegTree st = new SegTree(m-1, ys);

        long area = 0;
        for (int i = 0; i < events.length - 1; i++) {
            int y1 = Arrays.binarySearch(ys, events[i].y1);
            int y2 = Arrays.binarySearch(ys, events[i].y2) - 1;
            
            st.update(1, 0, m-2, y1, y2, events[i].type);

            long dx = (long)events[i+1].x - events[i].x;
            area += st.length[1] * dx;
        }
        
        return area;
    }
}
