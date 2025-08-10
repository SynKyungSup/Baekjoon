import java.io.*;
public class B5639 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        Tree tree= new Tree();
        String input;
        int value;
        Node pointer;
        while((input = br.readLine()) != null && !input.isEmpty()){
            value = Integer.parseInt(input);
            pointer = new Node(value);
            insertNode(tree, pointer);    
        } // 트리 완성
        postOrder(tree.root, bw);
        bw.flush();
        bw.close();
        br.close();
    }
    public static void postOrder(Node root,BufferedWriter bw) throws IOException{
        if(root == null ) return;
        postOrder(root.left, bw);
        postOrder(root.right, bw);
        bw.write(String.valueOf(root.value));
        bw.newLine();
        
    }
    public static Node findLeft(Node root, Tree tree){
        Node ret = root;
        while(ret.left!=null){
            ret = ret.left;
        }
        return ret;
    }
    public static void insertNode(Tree tree, Node pointer){
        if(tree.root == null){
            tree.root = pointer;
            return;
        } else{
            Node leaf = tree.root;
            while(true){
                if(pointer.value<leaf.value){
                    if(leaf.left == null){
                        leaf.left = pointer;
                        return;
                    }
                    leaf= leaf.left;
                } else{
                    if(leaf.right == null){
                        leaf.right = pointer;
                        return;
                    }
                    leaf =leaf.right;
                }
            }
        }
    }
}

    

class Node {
    int value;
    Node left;
    Node right;
    public Node(int value){
        this.value = value;
        this.left =null;
        this.right =null;
    }
}
class Tree{
    Node root;
}