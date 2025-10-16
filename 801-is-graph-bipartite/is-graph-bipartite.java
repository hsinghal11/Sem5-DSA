class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<BipartitePair> q = new LinkedList<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if(visited.containsKey(i)){
                continue;
            }
            q.add(new BipartitePair(i, 0));
            while(!q.isEmpty()){
                // remove
                BipartitePair bp = q.poll();

                // ignore
                if(visited.containsKey(bp.vtx)){
                    if(visited.get(bp.vtx) == bp.dis){
                        continue;
                    }else{
                        return false;
                    }
                }

                // marked visited
                visited.put(bp.vtx, bp.dis);
                // self work

                // add nbrs
                for(int nbrs: graph[bp.vtx]){
                    if(!visited.containsKey(nbrs)){
                        q.add(new BipartitePair(nbrs, bp.dis+1));
                    }
                }
            }
        }
        return true;
    }
}

class BipartitePair{
    int vtx;
    int dis;
    public BipartitePair(int vtx, int dis){
        this.dis = dis;
        this.vtx = vtx;
    }

}