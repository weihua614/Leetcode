import org.junit.Test;

import java.util.*;

public class canFinish {
    //https://leetcode.cn/problems/course-schedule/?favorite=2cktkvj
    ArrayList<ArrayList<Integer>> arrayLists;
    int[] ints;
    boolean flag=true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ints = new int[numCourses];
        arrayLists=new ArrayList<>();
        for (int i=0;i<numCourses;i++)
        {
            arrayLists.add(new ArrayList<Integer>());
        }
        for (int i=0;i<prerequisites.length;i++)
        {
            arrayLists.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for (int i=0;i<numCourses&&flag;i++)
        {
            if (ints[i]==0)
            {
                dfs(i);
            }
        }
        return flag;
    }
    public void dfs(int index)
    {
        ints[index]=1;
        ArrayList<Integer> list = arrayLists.get(index);
        for (int i=0;i<list.size();i++)
        {
            if (ints[list.get(i)]==0)
            {
                dfs(list.get(i));
                if (!flag) return;
            }
            else if (ints[list.get(i)]==1)
            {
                flag=false;
                return;
            }
        }
        ints[index]=2;
    }
    @Test
    public void test()
    {
        System.out.println(canFinish(5, new int[][]{{1,0},{2,1}}));
        /*

        5
[[1,4],[2,4],[3,1],[3,2]]     3,1   123
                              3,2
                              1,4
                              2,4
                             [[0,2],[1,2],[2,0]]
                             1,2
                             0,2
                             2,0

         */
    }

    class Solution {
        List<List<Integer>> edges;
        int[] visited;
        boolean valid = true;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<Integer>());
            }
            visited = new int[numCourses];
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
            }
            for (int i = 0; i < numCourses && valid; ++i) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            return valid;
        }

        public void dfs(int u) {
            visited[u] = 1;
            for (int v: edges.get(u)) {
                if (visited[v] == 0) {
                    dfs(v);
                    if (!valid) {
                        return;
                    }
                } else if (visited[v] == 1) {
                    valid = false;
                    return;
                }
            }
            visited[u] = 2;
        }
    }


    class Solution2 {
        List<List<Integer>> edges;
        int[] indeg;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<Integer>());
            }
            indeg = new int[numCourses];
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
                ++indeg[info[0]];
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            for (int i = 0; i < numCourses; ++i) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }

            int visited = 0;
            while (!queue.isEmpty()) {
                ++visited;
                int u = queue.poll();
                for (int v: edges.get(u)) {
                    --indeg[v];
                    if (indeg[v] == 0) {
                        queue.offer(v);
                    }
                }
            }

            return visited == numCourses;
        }
    }
}
