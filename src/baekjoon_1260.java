import java.util.*;

public class baekjoon_1260 {
    public static int N; // 노드의 갯수
    public static int M; // 간선의 갯수
    public static int V; // 시작 정점
    public static int node1,node2; // 간산의 정보를 나타낸다.
    public static Scanner input; // input 받을 객체
    public static boolean dupFlag[]; // 방문했는가 여부를 담는 배열
    public static LinkedList<Integer> Graph[]; // 그래프
    public static Vector<String> VisitedNode;
    public static Deque<Integer> queueForBFS;
    public static String resultDFS;
    public static String resultBFS;

    public static void DFS(int Start){
        if(dupFlag[Start-1]==true){
            return;
        }
        VisitedNode.add(Integer.toString(Start)+" ");
        dupFlag[Start-1]=true;
        for(int i:Graph[Start-1]){
            DFS(i);
        }
    }

    public static void BFS(int Start){
        queueForBFS.offer(Start);
        while(!queueForBFS.isEmpty()){
            Start = queueForBFS.poll();
            if(dupFlag[Start-1]==true)continue;
            dupFlag[Start-1]=true;
            VisitedNode.add(Start+" ");
            for(int NextNode:Graph[Start-1]){
                queueForBFS.add(NextNode);
            }
        }
    }

    public static void main(String[] args){
        queueForBFS = new LinkedList<Integer>();
        VisitedNode = new Vector<String>();
        input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();
        V = input.nextInt();
        resultDFS="";
        resultBFS="";

        Graph = new LinkedList[N];// 노드 수 만큼 초기화
        dupFlag = new boolean[N];
        for(int i=0;i<N;i++){
            Graph[i] = new LinkedList<Integer>();
            dupFlag[i] = false;
        }

        for(int i=0;i<M;i++){
            node1 = input.nextInt();
            node2 = input.nextInt();
            Graph[node1-1].add(node2);
            Graph[node2-1].add(node1);
            Collections.sort(Graph[node1-1]);
            Collections.sort(Graph[node2-1]);
        }

        DFS(V);
        for(int i=0;i<VisitedNode.size();i++){
            resultDFS+=VisitedNode.get(i);
        }
        resultDFS=resultDFS.substring(0,resultDFS.length()-1);
        System.out.println(resultDFS);

        for(int i=0;i<N;i++){
            dupFlag[i]=false;
        }
        VisitedNode.clear();
        BFS(V);
        for(int i=0;i<VisitedNode.size();i++){
            resultBFS+=VisitedNode.get(i);
        }
        resultBFS=resultBFS.substring(0,resultBFS.length()-1);
        System.out.println(resultBFS);
    }
}
