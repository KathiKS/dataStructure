package nonlinear;

class Anode {
    int data, height;
    Anode left, right;

    public Anode(int data) {
        this.data = data;
        height = 1;
        left = right = null;
    }
}

public class Avl {
    static Anode root;

    static Anode createnode(int data) {
        return new Anode(data);
    }

    static int height(Anode node) {
        if (node == null) return 0;
        return node.height;
    }

    static int balance(Anode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    static Anode rightRotate(Anode y) {
        Anode x = y.left;
        Anode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    static Anode leftRotate(Anode x) {
        Anode y = x.right;
        Anode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }
    public static void inorder(Anode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    public static Anode insert(Anode node, int data) {
        if (node == null)
            return createnode(data);

        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);
        else 
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int bal = balance(node);


        if (bal > 1 && data < node.left.data)
            return rightRotate(node);

        if (bal < -1 && data > node.right.data)
            return leftRotate(node);

        if (bal > 1 && data > node.left.data) {
            node.left = leftRotate(node.left); 
            return rightRotate(node);
        }

        if (bal < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public static void main(String[] args) {
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 10);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);
        inorder(root);
    }
}
