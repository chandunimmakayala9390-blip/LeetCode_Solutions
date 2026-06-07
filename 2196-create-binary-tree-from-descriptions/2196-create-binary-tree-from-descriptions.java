/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 import java.util.*;
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        int root_val=0;
        Set<Integer>child = new HashSet<>();
        Set<Integer>parent = new HashSet<>();
        HashMap<Integer,List<int []>>map = new HashMap<>();
        for(int arr[] : descriptions){
            child.add(arr[1]);
            parent.add(arr[0]);
            int temp[]=new int[2];
            temp[0]=arr[1];
            temp[1]=arr[2];
            if(!map.containsKey(arr[0])){
                map.put(arr[0],new ArrayList<>());
            }
            map.get(arr[0]).add(temp);
        }
        for(int x : parent){
            if(!child.contains(x)){
                root_val=x;
            }
        }
        Queue<TreeNode>q=new LinkedList<>();
        TreeNode root=new TreeNode(root_val);
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp==null)continue;
            if(map.containsKey(temp.val)){
                TreeNode left=null;
                TreeNode right=null;
                List<int[]>lis=map.get(temp.val);
                for(int i=0;i<lis.size();i++){
                    if(lis.get(i)[1]==1){
                        left=new TreeNode(lis.get(i)[0]);
                    }
                    else{
                        right=new TreeNode(lis.get(i)[0]);
                    }
                }
                temp.left=left;
                temp.right=right;
                q.offer(left);
                q.offer(right);
            }
            else{
                continue;
            }
        }
        return root;
    }
}