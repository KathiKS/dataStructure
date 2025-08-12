package nonlinear;

class Bstn {
    int data;
    Bstn left, right;

    public Bstn(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Bst {
    static Bstn root;

    public static void insert(int data) {
        Bstn node = new Bstn(data);
        if (root == null)
            root = node;
        else {
            Bstn current = root;
            while (true) {
                if (data > current.data) {
                    if (current.right == null) {
                        current.right = node;
                        break;
                    } else {
                        current = current.right;
                    }
                } else {
                    if (current.left == null) {
                        current.left = node;
                        break;
                    } else {
                        current = current.left;
                    }
                }
            }
        }
    }

    public static void inOrder(Bstn node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void preOrder(Bstn node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Post-order Traversal: Left -> Right -> Root
    public static void postOrder(Bstn node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        insert(45);
        insert(50);
        insert(55);
        insert(30);
        insert(47);
        insert(54);
        insert(52);
        insert(34);

        System.out.println("In-order Traversal:");
        inOrder(root);
        System.out.println();

        System.out.println("Pre-order Traversal:");
        preOrder(root); 
        System.out.println();

        System.out.println("Post-order Traversal:");
        postOrder(root); 
        System.out.println();
    }
}
