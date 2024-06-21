import java.io.*;
import java.util.*;

public class RangeUpdateSegment {
    static class SegmentTree {
        int[] tree;
        int[] lazy;
        boolean[] isSingleDigit;
        int n;

        public SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            lazy = new int[4 * n];
            isSingleDigit = new boolean[4 * n];
            build(arr, 0, n - 1, 0);
        }

        private void build(int[] arr, int start, int end, int node) {
            if (start == end) {
                tree[node] = arr[start];
                isSingleDigit[node] = (arr[start] < 10);
            } else {
                int mid = (start + end) / 2;
                build(arr, start, mid, 2 * node + 1);
                build(arr, mid + 1, end, 2 * node + 2);
                tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
                isSingleDigit[node] = isSingleDigit[2 * node + 1] && isSingleDigit[2 * node + 2];
            }
        }

        public void updateRange(int l, int r) {
            updateRange(0, n - 1, l, r, 0);
        }

        private void updateRange(int start, int end, int l, int r, int node) {
            if (lazy[node] != 0) {
                applyLazy(node, start, end);
            }
            if (start > end || start > r || end < l) {
                return;
            }
            if (start >= l && end <= r && isSingleDigit[node]) {
                return;
            }
            if (start == end) {
                tree[node] = sumOfDigits(tree[node]);
                isSingleDigit[node] = (tree[node] < 10);
            } else {
                int mid = (start + end) / 2;
                updateRange(start, mid, l, r, 2 * node + 1);
                updateRange(mid + 1, end, l, r, 2 * node + 2);
                tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
                isSingleDigit[node] = isSingleDigit[2 * node + 1] && isSingleDigit[2 * node + 2];
            }
        }

        private void applyLazy(int node, int start, int end) {
            if (start != end) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            tree[node] += lazy[node];
            lazy[node] = 0;
        }

        public int query(int idx) {
            return query(0, n - 1, idx, 0);
        }

        private int query(int start, int end, int idx, int node) {
            if (lazy[node] != 0) {
                applyLazy(node, start, end);
            }
            if (start == end) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            if (idx <= mid) {
                return query(start, mid, idx, 2 * node + 1);
            } else {
                return query(mid + 1, end, idx, 2 * node + 2);
            }
        }
    }

    private static int sumOfDigits(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            String[] nq = br.readLine().split(" ");
            int n = Integer.parseInt(nq[0]);
            int q = Integer.parseInt(nq[1]);

            String[] arrStr = br.readLine().split(" ");
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }

            SegmentTree segTree = new SegmentTree(arr);

            for (int query = 0; query < q; query++) {
                String[] queryParts = br.readLine().split(" ");
                int type = Integer.parseInt(queryParts[0]);

                if (type == 1) {
                    int l = Integer.parseInt(queryParts[1]) - 1;
                    int r = Integer.parseInt(queryParts[2]) - 1;
                    segTree.updateRange(l, r);
                } else if (type == 2) {
                    int x = Integer.parseInt(queryParts[1]) - 1;
                    output.append(segTree.query(x)).append("\n");
                }
            }
        }

        System.out.print(output.toString());
    }
}