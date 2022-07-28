package programmers;

import java.util.*;

public class 카카오블라인드_실패율 {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        HashMap<Integer, Double> hm = new HashMap<Integer, Double>();

        for (int i = 0; i<N; i++){
            int failcnt = 0;
            int totcnt = 0;

            for (int j=0; j< stages.length; j++){
                if (i+1 < stages[j]){
                    totcnt++;
                } else if (i+1 == stages[j]){
                    totcnt++;
                    failcnt++;
                }
            }

            double failureRate = (double)failcnt / totcnt;

            if (Double.isNaN(failureRate)){
                failureRate =0;
            }

            hm.put(i+1, failureRate);

        }
        // Map.Entry 리스트 작성
        List<Map.Entry<Integer, Double>> list_entries = new ArrayList<Map.Entry<Integer, Double>>(hm.entrySet());

        // 비교함수 Comparator를 사용하여 오름차순으로 정렬
        Collections.sort(list_entries, new Comparator<Map.Entry<Integer, Double>>() {
            // compare로 값을 비교
            public int compare(Map.Entry<Integer, Double> obj1, Map.Entry<Integer, Double> obj2) {
                // 오름 차순 정렬
                // return obj1.getValue().compareTo(obj2.getValue());

                // 내림 차순 정렬
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });


       for (int k =0; k<N; k++){
           //answer[k] = ((Integer)((HashMap.Node)list_entries.get(k)).getKey()).value;
           answer[k] = list_entries.get(k).getKey().intValue();
       }


//        Object[] valueKey = hm.values().toArray();
//        Arrays.sort(valueKey);

        return answer;
    }




}
