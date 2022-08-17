package code;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 */

public class binaryTreePaths_257 {
    LinkedList<Integer> xianlu=new LinkedList<>();
    LinkedList<String> result=new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePaths1(root);
        return result;
    }

    void binaryTreePaths1(TreeNode root) {
        if(root.left==null&&root.right==null)
        {
            xianlu.add(root.val);
            StringBuffer stringBuffer = new StringBuffer();
            for(int temp:xianlu)
            {
                stringBuffer.append(String.valueOf(temp));
                stringBuffer.append("->");
            }
            stringBuffer.delete(stringBuffer.length()-2,stringBuffer.length());
            result.add(stringBuffer.toString());
        }
        else
        {
            xianlu.add(root.val);
            if(root.left!=null)
            {
                binaryTreePaths1(root.left);
                xianlu.removeLast();
            }

            if (root.right!=null)
            {
                binaryTreePaths1(root.right);
                xianlu.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("01");
        stringBuffer.delete(stringBuffer.length()-2,stringBuffer.length());
        System.out.println(stringBuffer);
    }
}
