package morsecodepackage;

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
    private TreeNode<String> root;

    public MorseCodeTree() {
        buildTree();
    }

    public TreeNode<String> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<String> newNode) {
        root = newNode;
    }

    public void insert(String code, String letter) {
        addNode(root, code, letter);
    }

    public void addNode(TreeNode<String> root, String code, String letter) {
        if (code.length() == 1) {
            if (code.equals(".")) root.setLeft(new TreeNode<>(letter));
            else root.setRight(new TreeNode<>(letter));
        } else {
            if (code.charAt(0) == '.') {
                if (root.getLeft() == null) root.setLeft(new TreeNode<>(""));
                addNode(root.getLeft(), code.substring(1), letter);
            } else {
                if (root.getRight() == null) root.setRight( new TreeNode<>(""));
                addNode(root.getRight(), code.substring(1), letter);
            }
        }
    }

    public String fetch(String code) {
        return fetchNode(root, code);
    }

    public String fetchNode(TreeNode<String> root, String code) {
        if (code.length() == 0) return root.getData();
        if (code.charAt(0) == '.') return fetchNode(root.getLeft(), code.substring(1));
        else return fetchNode(root.getRight(), code.substring(1));
    }

    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Deletion not supported.");
    }

    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Update not supported.");
    }

    public void buildTree() {
        root = new TreeNode<>("");
        insert(".", "e");
        insert("-", "t");
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");
    }

    public ArrayList<String> toArrayList() {
        ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(root, list);
        return list;
    }

    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
   	 if (root != null) {
   	        LNRoutputTraversal(root.getLeft(), list);
   	        list.add(root.getData() == null ? "" : root.getData());  
   	        LNRoutputTraversal(root.getRight(), list);
   	    }
   }
}

