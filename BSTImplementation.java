class Node {

    int data;
    Node left;
    Node right;

    Node(int value) {

        data = value;
        left = null;
        right = null;
    }
}

class BinarySearchTree {

    Node root;

    // Insert Node
    Node insert(Node root, int value) {

        if (root == null) {

            return new Node(value);
        }

        if (value < root.data) {

            root.left = insert(root.left, value);

        } else if (value > root.data) {

            root.right = insert(root.right, value);
        }

        return root;
    }

    // Search Node
    boolean search(Node root, int value) {

        if (root == null) {

            return false;
        }

        if (root.data == value) {

            return true;
        }

        if (value < root.data) {

            return search(root.left, value);

        } else {

            return search(root.right, value);
        }
    }

    // Find Minimum Value
    Node findMin(Node root) {

        while (root.left != null) {

            root = root.left;
        }

        return root;
    }

    // Delete Node
    Node delete(Node root, int value) {

        if (root == null) {

            return null;
        }

        if (value < root.data) {

            root.left = delete(root.left, value);

        } else if (value > root.data) {

            root.right = delete(root.right, value);

        } else {

            // Node with one child or no child
            if (root.left == null) {

                return root.right;

            } else if (root.right == null) {

                return root.left;
            }

            // Node with two children
            Node temp = findMin(root.right);

            root.data = temp.data;

            root.right = delete(root.right, temp.data);
        }

        return root;
    }

    // Inorder Traversal
    void inorder(Node root) {

        if (root != null) {

            inorder(root.left);

            System.out.print(root.data + " ");

            inorder(root.right);
        }
    }

    // Preorder Traversal
    void preorder(Node root) {

        if (root != null) {

            System.out.print(root.data + " ");

            preorder(root.left);

            preorder(root.right);
        }
    }

    // Postorder Traversal
    void postorder(Node root) {

        if (root != null) {

            postorder(root.left);

            postorder(root.right);

            System.out.print(root.data + " ");
        }
    }
}

public class BSTImplementation {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        // Insert Nodes
        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 20);
        bst.insert(bst.root, 40);
        bst.insert(bst.root, 60);
        bst.insert(bst.root, 80);

        System.out.println("==================================");
        System.out.println(" BINARY SEARCH TREE IMPLEMENTATION");
        System.out.println("==================================");

        // Inorder Traversal
        System.out.println("\nInorder Traversal:");
        bst.inorder(bst.root);

        // Preorder Traversal
        System.out.println("\n\nPreorder Traversal:");
        bst.preorder(bst.root);

        // Postorder Traversal
        System.out.println("\n\nPostorder Traversal:");
        bst.postorder(bst.root);

        // Search Operation
        int searchValue = 40;

        System.out.println("\n");

        if (bst.search(bst.root, searchValue)) {

            System.out.println(searchValue + " Found in BST");

        } else {

            System.out.println(searchValue + " Not Found in BST");
        }

        // Delete Operation
        bst.root = bst.delete(bst.root, 20);

        System.out.println("\nAfter Deleting 20:");
        bst.inorder(bst.root);

        System.out.println("\n\n==================================");
        System.out.println(" Program Executed Successfully");
        System.out.println("==================================");
    }
}