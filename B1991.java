// 트리 순회
// 순회 순서대로 메서드를 호출하면 된다
import java.io.*;
import java.util.Scanner;
public class B1991 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] tree = new int[N][2]; // tree[0][0] >> A의 left child, tree[0][1] >> A의 right child
        for(int i=0; i<N;i++){
            String[] input = br.readLine().split(" ");
            int parent = input[0].charAt(0) - 'A';
            if(input[1].equals(".")){
                tree[parent][0] = -1; // No left child
            } else {
                tree[parent][0] = input[1].charAt(0) - 'A'; // Left child
            }
            if(input[2].equals(".")){
                tree[parent][1] = -1; // No right child
            } else {
                tree[parent][1] = input[2].charAt(0) - 'A'; // Right child
            }
        }
        StringBuilder preOrder = new StringBuilder();
        StringBuilder inOrder = new StringBuilder();
        StringBuilder postOrder = new StringBuilder();

        // 전위 순회
        preOrderTraversal(tree, 0, preOrder);
        // 중위 순회
        inOrderTraversal(tree, 0, inOrder);
        // 후위 순회
        postOrderTraversal(tree, 0, postOrder);
        bw.write(preOrder.toString() + "\n");
        bw.write(inOrder.toString() + "\n");
        bw.write(postOrder.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static void preOrderTraversal(int[][] tree, int node, StringBuilder order){
        if(node == -1) return;
        order.append((char)(node + 'A')); // 현재노드 방문
        preOrderTraversal(tree, tree[node][0], order); // 왼쪽 자식
        preOrderTraversal(tree, tree[node][1], order); // 오른쪽 자식
    }
    public static void inOrderTraversal(int[][] tree, int node, StringBuilder order){
        if(node == -1) return;
        inOrderTraversal(tree, tree[node][0], order); // 왼쪽 자식
        order.append((char)(node + 'A')); // 현재노드 방문
        inOrderTraversal(tree, tree[node][1], order); // 오른쪽 자식
    }
    public static void postOrderTraversal(int[][] tree, int node, StringBuilder order){
        if(node == -1) return;
        postOrderTraversal(tree, tree[node][0], order); // 왼쪽 자식
        postOrderTraversal(tree, tree[node][1], order); // 오른쪽 자식
        order.append((char)(node + 'A')); // 현재노드 방문
    }
}
